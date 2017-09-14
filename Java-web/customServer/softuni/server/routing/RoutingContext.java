package softuni.server.routing;

import softuni.server.handler.RequestHandler;

import java.util.Map;


public interface RoutingContext {
    RequestHandler getHandler();

    Map<Integer, Class> getArgumentMapping();

    ControllerActionPair getActionPair();
}
