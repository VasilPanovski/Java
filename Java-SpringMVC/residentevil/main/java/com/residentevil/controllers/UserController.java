package com.residentevil.controllers;

import com.residentevil.models.bindingModels.RegisterModel;
import com.residentevil.services.UserService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegisterModel registerModel) {
        return "register";
    }

    @PostMapping("/register")
    public String registerModel(@ModelAttribute RegisterModel registerModel) {
        this.userService.register(registerModel);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
