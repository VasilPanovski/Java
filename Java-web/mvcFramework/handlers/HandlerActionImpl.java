package com.mvcFramework.handlers;

import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.controllerActionPair.ControllerActionPair;
import com.mvcFramework.interfaces.HandlerAction;
import com.mvcFramework.models.Model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;


public class HandlerActionImpl implements HandlerAction {

    @Override
    public String executeControllerAction(HttpServletRequest request, HttpServletResponse response, ControllerActionPair controllerActionPair) throws ReflectiveOperationException, NamingException {
        //TODO Get the controller and it respective method to execute
        Class controller = controllerActionPair.getControllerClass();
        Method method = controllerActionPair.getAction();
        Parameter[] parameters = method.getParameters();
        List<Object> arguments = new ArrayList();

        for (Parameter parameter : parameters) {
            Object argument = null;
            if(parameter.isAnnotationPresent(PathVariable.class)){
                String pathVariableKey = parameter.getAnnotation(PathVariable.class).value();

                String variable = controllerActionPair.getPathVariable(pathVariableKey);
                argument = this.convertArgument(parameter, variable);
            }

            if(parameter.isAnnotationPresent(RequestParam.class)){
                RequestParam requestParam = parameter.getAnnotation(RequestParam.class);
                String requestParamKey = requestParam.value();
                argument = request.getParameter(requestParamKey);
            }

            if(parameter.getType().isAssignableFrom(Model.class)){
                Constructor constructor = parameter.getType().getConstructor(HttpServletRequest.class);
                argument = constructor.newInstance(request);
            }

            if (parameter.isAnnotationPresent(ModelAttribute.class)) {
                argument = this.getModelAttribute(parameter, request);
            }

            if (parameter.getType().isAssignableFrom(HttpSession.class)) {
                argument = request.getSession();
            }

            if (parameter.getType().isAssignableFrom(Cookie[].class)) {
                argument = request.getCookies();
            }

            if (parameter.getType().isAssignableFrom(HttpServletResponse.class)) {
                argument = response;
            }

            arguments.add(argument);
        }

        Context context = new InitialContext();
        String controllerName = controller.getSimpleName();
        Object controllerObject = context.lookup("java:global/" + controllerName);

        String view = (String) method.invoke(controllerObject, (Object[]) arguments.toArray());

        return view;
    }



    private Object getModelAttribute(Parameter parameter, HttpServletRequest request) throws IllegalAccessException,
            InstantiationException {
        Class bindingModel = parameter.getType();
        Object bindingModelObject = bindingModel.newInstance();
        Field[] fields = bindingModel.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String fieldValue = request.getParameter(fieldName);
            if (fieldValue != null) {
                field.set(bindingModelObject, fieldValue);
            }
        }

        return bindingModelObject;
    }

    private <T> T convertArgument(Parameter parameter, String pathVariable)
            throws ReflectiveOperationException {
        String paramType = parameter.getType().getSimpleName();
        Object object = null;
        switch (paramType) {
            case "Integer":
                object = Integer.valueOf(pathVariable);
                break;
            case "int":
                object = Integer.parseInt(pathVariable);
                break;
            case "Long":
                object = Long.valueOf(pathVariable);
                break;
            case "long":
                object = Long.parseLong(pathVariable);
                break;
        }

        return (T) object;
    }

}
