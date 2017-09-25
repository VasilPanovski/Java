package com.pizzaForum.controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;

import javax.ejb.Stateless;

@Stateless
@Controller
public class CategoriesController {

    @GetMapping("/categories")
    public String loadCategoriesPage() {
        return "";
    }
}
