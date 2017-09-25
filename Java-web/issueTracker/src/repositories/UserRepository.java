package com.issueTracker.repositories;

import com.issueTracker.entities.user.User;

public interface UserRepository {

    void save(User user);

    User findByUsernameAndPassword(String username, String password);
}
