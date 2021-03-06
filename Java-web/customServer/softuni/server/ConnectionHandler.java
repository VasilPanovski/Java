package softuni.server;

import softuni.server.exception.BadRequestException;
import softuni.server.handler.HttpHandler;
import softuni.server.http.HttpContext;
import softuni.server.http.HttpContextImpl;
import softuni.server.http.HttpSession;
import softuni.server.routing.ServerRouteConfig;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ConnectionHandler implements Runnable {
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final PrintWriter printWriter;
    private final ServerRouteConfig serverRouteConfig;
    private final Map<String, HttpSession> sessionMap;

    public ConnectionHandler(Socket clientSocket, ServerRouteConfig serverRouteConfig, Map<String, HttpSession> sessionMap) throws IOException {
        this.socket = clientSocket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.printWriter = new PrintWriter(socket.getOutputStream());
        this.serverRouteConfig = serverRouteConfig;
        this.sessionMap = sessionMap;
    }

    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            while(this.bufferedReader.ready()
                    || stringBuilder.length() == 0){
                stringBuilder.append((char) this.bufferedReader.read());
            }

            try {
                HttpContext httpContext = new HttpContextImpl(stringBuilder.toString(), this.sessionMap);
                new HttpHandler(this.serverRouteConfig, this.printWriter).handle(httpContext);
                HttpSession session = httpContext.getHttpRequest().getHttpSession();
                this.sessionMap.put(session.getId(), session);
            } catch (BadRequestException e) {
                this.printWriter.write("HTTP/1.1 400 Bad Request");
            } catch (FileNotFoundException e){
                this.printWriter.write("HTTP/1.1 404 Not Found");
            } catch (Exception e) {
                e.printStackTrace();
                this.printWriter.write("HTTP/1.1 500 Internal Server Error");
            }

            this.printWriter.close();
            this.bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
