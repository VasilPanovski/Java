package softuni.server.routing;

import softuni.server.handler.GetHandler;
import softuni.server.handler.PostHandler;
import softuni.server.handler.RequestHandler;
import softuni.server.http.HttpRequestMethod;
import softuni.server.parser.ControllerAnnotationParser;
import softuni.server.provider.ClassProvider;

import java.util.HashMap;
import java.util.Map;

public class ServerRouteConfigImpl implements ServerRouteConfig {

    private final Map<HttpRequestMethod, Map<String, RoutingContext>> routes;
    private final ClassProvider classProvider;

    public ServerRouteConfigImpl(ClassProvider classProvider) throws IllegalAccessException, InstantiationException {
        this.classProvider = classProvider;
        this.routes = new HashMap<>();

        for (HttpRequestMethod httpRequestMethod : HttpRequestMethod.values()) {
            this.routes.put(httpRequestMethod, new HashMap<>());
        }

        this.initializeServerConfig();
    }

    @Override
    public Map<HttpRequestMethod, Map<String, RoutingContext>> getRoutes() {
        return this.routes;
    }

    private void initializeServerConfig() throws InstantiationException, IllegalAccessException {
        Map<HttpRequestMethod, Map<String, ControllerActionPair>> annotationRoutes = new HashMap<>();
        ControllerAnnotationParser annotationParser = new ControllerAnnotationParser(this.classProvider);

        annotationParser.parse(annotationRoutes);

        for (Map.Entry<HttpRequestMethod, Map<String, ControllerActionPair>> mapEntry : 
                annotationRoutes.entrySet()) {
            for (Map.Entry<String,ControllerActionPair> actionPairEntry : mapEntry.getValue().entrySet()) {
                RequestHandler requestHandler = null;

                if (mapEntry.getKey() == HttpRequestMethod.GET) {
                    requestHandler = new GetHandler();
                } else {
                    requestHandler = new PostHandler();
                }

                Map<Integer, Class> args = actionPairEntry.getValue().getArgumentMapping();
                ControllerActionPair actionPair = actionPairEntry.getValue();
                RoutingContext routingContext = new RoutingContextImpl(requestHandler, actionPair, args);

                this.routes.get(mapEntry.getKey()).put(actionPairEntry.getKey(), routingContext);
            }
            
        }
    }
}
