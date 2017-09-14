package com.mvcFramework.interfaces;

import com.mvcFramework.controllerActionPair.ControllerActionPair;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerAction {

    String executeControllerAction(HttpServletRequest request, HttpServletResponse response, ControllerActionPair controllerActionPair) throws ReflectiveOperationException, NamingException;
}


