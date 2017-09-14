package com.mvcFramework.interfaces;

import com.mvcFramework.controllerActionPair.ControllerActionPair;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface HandlerMapping {

    ControllerActionPair findController(HttpServletRequest request) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}

