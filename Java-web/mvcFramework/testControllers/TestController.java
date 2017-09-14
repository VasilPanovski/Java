package com.mvcFramework.testControllers;

import com.mvcFramework.annotations.controllers.Controller;
import com.mvcFramework.annotations.request.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String getTestPage() {
        return null;
    }
}
