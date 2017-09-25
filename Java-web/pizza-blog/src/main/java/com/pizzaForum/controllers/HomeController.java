package com.pizzaForum.controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;

import javax.ejb.Stateless;

@Stateless
@Controller
public class HomeController {

    @GetMapping("/")
    public String loadHomePage() {
        return "templates/home";
    }
}
