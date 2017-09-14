package com.issueTracker.services;

import com.issueTracker.entities.user.User;
import com.issueTracker.models.bindingModels.CreateUserModel;
import com.issueTracker.models.bindingModels.LogInModel;

public interface UserService {

    void registerUser(CreateUserModel createUserModel);

    User findLoggedInUser(LogInModel logInModel);
}
