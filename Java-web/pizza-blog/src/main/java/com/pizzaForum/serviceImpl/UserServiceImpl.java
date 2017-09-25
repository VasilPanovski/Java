package com.pizzaForum.serviceImpl;

import com.pizzaForum.entities.User;
import com.pizzaForum.models.binding.LoginModel;
import com.pizzaForum.models.binding.RegisterModel;
import com.pizzaForum.models.view.LoggedUserModel;
import com.pizzaForum.repositories.UserRepository;
import com.pizzaForum.services.UserService;
import com.pizzaForum.utils.parser.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void saveUser(RegisterModel registerModel) {
        User user = this.modelParser.convert(registerModel, User.class);
        this.userRepository.save(user);
    }

    @Override
    public LoggedUserModel findByUsernameOrPassword(String username) {
        User user = this.userRepository.findByEmailOrUsername(username);
        LoggedUserModel loggedUserModel = null;
        if (user != null) {
            loggedUserModel = this.modelParser.convert(user, LoggedUserModel.class);
            if (user.isAdmin()) {
                loggedUserModel.setAdmin(true);
            } else {
                loggedUserModel.setAdmin(false);
            }
        }
        return loggedUserModel;
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        LoginModel registerModel = null;
        if (user != null) {
            registerModel = this.modelParser.convert(user, LoginModel.class);
        }
        return registerModel;
    }
}
