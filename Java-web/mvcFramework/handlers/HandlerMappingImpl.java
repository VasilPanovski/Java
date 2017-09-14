package com.mvcFramework.handlers;


import com.mvcFramework.annotations.controllers.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.controllerActionPair.ControllerActionPair;
import com.mvcFramework.interfaces.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HandlerMappingImpl implements HandlerMapping {

    @Override
    public ControllerActionPair findController(HttpServletRequest request) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String uriPath = request.getRequestURI();
        String projectPath = request.getServletContext().getRealPath("/WEB-INF/classes");
        List<Class> controllers = this.findAllControllers(projectPath);
        ControllerActionPair controllerActionPair = null;
        for (Class controller : controllers) {
            Method[] methods = controller.getDeclaredMethods();
            for (Method method : methods) {
                String methodPath = this.findMethodPath(method, request);
                if (methodPath == null) {
                    continue;
                }

                if (this.isPathMatching(uriPath, methodPath)) {
                    controllerActionPair = new ControllerActionPair(controller, method);
                    this.addPathVariables(controllerActionPair, uriPath, methodPath);
                }
            }
        }

        return controllerActionPair;
    }

    private void addPathVariables(ControllerActionPair controllerActionPair, String urlPath, String methodPath) {
        String[] uriTokens = urlPath.split("/");
        String[] methodTokens = methodPath.split("/");

        for (int i = 0; i < uriTokens.length; i++) {
            if (methodTokens[i].startsWith("{") && methodTokens[i].endsWith("}")) {
                String key = methodTokens[i].replaceAll("[{}]", "");
                String value = uriTokens[i];
                controllerActionPair.addPathVariable(key, value);
            }
        }
    }


    private boolean isPathMatching(String urlPath, String methodPath) {
        boolean isMatching = true;
        if (urlPath.endsWith("/") && !methodPath.endsWith("/")) {
            isMatching = false;
            return isMatching;
        }

        String[] uriTokens = urlPath.split("/");
        String[] methodTokens = methodPath.split("/");
        if (uriTokens.length != methodTokens.length) {
            isMatching = false;
            return isMatching;
        }

        for (int i = 0; i < methodTokens.length; i++) {
            if (methodTokens[i].startsWith("{") && methodTokens[i].endsWith("}")) {
                continue;
            }

            if (!uriTokens[i].equals(methodTokens[i])) {
                isMatching = false;
                break;
            }
        }

        return isMatching;
    }

    private String findMethodPath(Method method, HttpServletRequest request) {
        String methodPath = null;
        String methodType = request.getMethod();
        switch (methodType.toLowerCase()) {
            case "get":
                if (method.isAnnotationPresent(GetMapping.class)) {
                    methodPath = method.getAnnotation(GetMapping.class).value();
                }
                break;
            case "post":
                if (method.isAnnotationPresent(PostMapping.class)) {
                    methodPath = method.getAnnotation(PostMapping.class).value();
                }
                break;
        }

        return methodPath;
    }

    private List<Class> findAllControllers(String projectDirectory) throws ClassNotFoundException {
        List<Class> controllerClasses = new ArrayList<>();
        File directory = new File(projectDirectory);
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                Class controllerClass = this.getClass(file);
                if (controllerClass != null) {
                    if (controllerClass.isAnnotationPresent(Controller.class)) {
                        controllerClasses.add(controllerClass);
                    }
                }
            } else if (file.isDirectory()) {
                String subDirectory = file.getAbsolutePath();
                controllerClasses.addAll(this.findAllControllers(subDirectory));
            }
        }

        return controllerClasses;
    }

    private Class getClass(File file) throws ClassNotFoundException {
        String absolutePath = file.getAbsolutePath();
        String clazz = absolutePath.split("classes\\\\")[1].replaceAll("\\\\", ".").replaceAll(".class", "");
        Class currentClass = null;
        if (!clazz.endsWith("DispatcherServlet")) {
            currentClass = Class.forName(clazz);
        }

        return currentClass;
    }
}
