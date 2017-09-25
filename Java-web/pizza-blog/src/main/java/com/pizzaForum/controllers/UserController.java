package com.pizzaForum.controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import com.pizzaForum.models.binding.LoginModel;
import com.pizzaForum.models.binding.RegisterModel;
import com.pizzaForum.models.view.LoggedUserModel;
import com.pizzaForum.services.UserService;
import com.pizzaForum.utils.constants.Constants;
import com.pizzaForum.utils.dataValidator.DataValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Stateless
@Controller
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping("/forum/register")
    public String loadRegisterPage() {
        return "templates/register";
    }

    @PostMapping("/forum/register")
    public String registerUser(@ModelAttribute RegisterModel registerModel, Model model) {
        Set<String> errors = DataValidator.validateData(registerModel);
        if (!registerModel.getPassword().equals(registerModel.getConfirmPassword())) {
            errors.add(Constants.CONFIRM_PASSWORD_ERROR);
        }

        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            return "templates/register";
        }

        this.userService.saveUser(registerModel);
        return "redirect:/forum/login";
    }

    @GetMapping("/forum/login")
    public String loadLoginPage() {
        return "templates/login";
    }

    @PostMapping("/forum/login")
    public String loginUser(@ModelAttribute LoginModel loginModel, HttpSession session, Model model) {
        String username = loginModel.getUsername();
        String password  = loginModel.getPassword();
        if (username == null || password == null) {
           return "redirect:/forum/login";
        }

        LoggedUserModel loggedUserModel = null;
        loggedUserModel = this.userService.findByUsernameOrPassword(username);
        if (loggedUserModel == null) {
            model.addAttribute("user", Constants.USER_NOT_FOUND);
            return "templates/login";
        }

        session.setAttribute("user", loggedUserModel);
        model.addAttribute("username", loggedUserModel.getUsername());
        return "templates/home";
    }

    @GetMapping("/forum/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "templates/home";
    }
}
