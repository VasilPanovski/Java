package softuni.server.routing;

import softuni.server.handler.RequestHandler;

import java.util.List;
import java.util.Map;


public class RoutingContextImpl implements RoutingContext {
    private RequestHandler handler;
    private List<String> paramNames;


    public RoutingContextImpl(RequestHandler requestHandler, ControllerActionPair actionPair, Map<Integer, Class>
            args) {
        this.handler = requestHandler;
    }

    @Override
    public RequestHandler getHandler() {
        return this.handler;
    }

    @Override
    public Map<Integer, Class> getArgumentMapping() {
        return null;
    }

    @Override
    public ControllerActionPair getActionPair() {
        return null;
    }
}
