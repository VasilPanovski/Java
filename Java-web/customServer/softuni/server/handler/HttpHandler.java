package softuni.server.handler;

import softuni.server.http.HttpContext;
import softuni.server.http.response.HttpResponse;
import softuni.server.routing.RoutingContext;
import softuni.server.routing.ServerRouteConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HttpHandler implements RequestHandler {
    private Writer writer;
    private ServerRouteConfig serverRouteConfig;
    private Map<Class, Function<String, Object>> typeConversions;

    public HttpHandler(ServerRouteConfig serverRouteConfig, PrintWriter printWriter) {
        this.serverRouteConfig = serverRouteConfig;
        this.writer = printWriter;

        this.fillTypeConversions();
    }

    private void fillTypeConversions() {
        this.typeConversions = new HashMap<Class, Function<String, Object>>() {{
            put(String.class, s -> s);
            put(Integer.class, Integer::parseInt);
            put(int.class, Integer::parseInt);
            put(Double.class, Double::parseDouble);
            put(double.class, Double::parseDouble);
            put(Long.class, Long::parseLong);
            put(long.class, Long::parseLong);
        }};
    }

    @Override
    public void handle(HttpContext httpContext) throws IOException {
        for (Map.Entry<String, RoutingContext> entry : serverRouteConfig.getRoutes().get(httpContext.getHttpRequest().getRequestType()).entrySet()) {

            Pattern pattern = Pattern.compile(entry.getKey());
            Matcher matcher = pattern.matcher(httpContext.getHttpRequest().getPath());

            if(!matcher.find()){
                continue;
            }

            entry.getValue().getHandler().setFunction((context) -> {
                Method method = entry.getValue().getActionPair().getAction();
                Map<Integer, Class> argumentPosition = entry.getValue().getArgumentMapping();
                String[] urlTokens = httpContext.getHttpRequest().getPath().split("/");
                Object[] argumentToPass = new Object[argumentPosition.size()];

                int index = 0;
                for (Map.Entry<Integer, Class> typeMapping : argumentPosition.entrySet()) {
                    String valueToParse = urlTokens[typeMapping.getKey()];
                    Class classToParseFrom = typeMapping.getValue();

                    argumentToPass[index++] = this.typeConversions.get(classToParseFrom).apply(valueToParse);
                }

                HttpResponse httpResponse = null;
                try {
                    Object response = method.invoke(entry.getValue().getActionPair().getController(),
                            argumentToPass);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                return httpResponse;

            });

            entry.getValue().getHandler().setWriter(this.writer);
            entry.getValue().getHandler().handle(httpContext);

            return;
        }

        throw new FileNotFoundException();
    }

    @Override
    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void setFunction(Function<HttpContext, HttpResponse> function) {

    }

}
