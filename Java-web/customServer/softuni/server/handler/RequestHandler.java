package softuni.server.handler;

import softuni.server.http.HttpContext;
import softuni.server.http.response.HttpResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.function.Function;

public interface RequestHandler {
    void handle(HttpContext httpContext) throws IOException;
    void setWriter(Writer writer);
    void setFunction(Function<HttpContext, HttpResponse> function);
}
