package com.mvcFramework.dispatcher;

import com.mvcFramework.controllerActionPair.ControllerActionPair;
import com.mvcFramework.handlers.HandlerActionImpl;
import com.mvcFramework.handlers.HandlerMappingImpl;
import com.mvcFramework.interfaces.Dispatcher;
import com.mvcFramework.interfaces.HandlerAction;
import com.mvcFramework.interfaces.HandlerMapping;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet("/")
public class DispatcherServlet extends HttpServlet implements Dispatcher{

    private HandlerMapping handlerMapping;

    private HandlerAction handlerAction;

    public DispatcherServlet() {
        this.handlerMapping = new HandlerMappingImpl();
        this.handlerAction = new HandlerActionImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.handleRequest(request, response);
    }

    @Override
    public ControllerActionPair dispatchRequest(HttpServletRequest request) {
        ControllerActionPair controllerActionPair = null;
        try {
            controllerActionPair = this.handlerMapping.findController(request);
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return controllerActionPair;
    }

    @Override
    public String dispatchAction(HttpServletRequest request, HttpServletResponse response, ControllerActionPair controllerActionPair) {
        String view = null;

        try {
            view = this.handlerAction.executeControllerAction(request, response, controllerActionPair);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException | NamingException e) {
            e.printStackTrace();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        ControllerActionPair controllerActionPair = this.dispatchRequest(request);
        if (controllerActionPair != null) {
            String view = this.dispatchAction(request, response, controllerActionPair);
            request.getRequestDispatcher("/templates/" + view + ".jsp").forward(request, response);
        }
    }
}
