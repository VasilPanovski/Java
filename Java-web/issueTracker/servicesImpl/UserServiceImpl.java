package com.issueTracker.servicesImpl;

import com.issueTracker.entities.user.Role;
import com.issueTracker.entities.user.User;
import com.issueTracker.models.bindingModels.CreateUserModel;
import com.issueTracker.models.bindingModels.LogInModel;
import com.issueTracker.repositories.UserRepository;
import com.issueTracker.services.UserService;
import com.issueTracker.utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void registerUser(CreateUserModel createUserModel) {
        User user = modelParser.convert(createUserModel, User.class);
        Role defaultRole = Role.USER;
        user.setRole(defaultRole);
        this.userRepository.save(user);
    }

    @Override
    public User findLoggedInUser(LogInModel logInModel) {
        User user = this.userRepository.findByUsernameAndPassword(logInModel.getUsername(), logInModel.getPassword());
        return user;
    }
}
