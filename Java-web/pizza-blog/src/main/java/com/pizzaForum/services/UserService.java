package com.pizzaForum.services;


import com.pizzaForum.models.binding.LoginModel;
import com.pizzaForum.models.binding.RegisterModel;
import com.pizzaForum.models.view.LoggedUserModel;

public interface UserService {

    void saveUser(RegisterModel registerModel);

    LoggedUserModel findByUsernameOrPassword(String username);

    LoginModel findByUsernameAndPassword(String username, String password);
}
