package com.pizzaForum.repositories;


import com.pizzaForum.entities.User;

public interface UserRepository {

    boolean isAdmin();

    User findById(long id);

    User findByEmailOrUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    void save(User user);
}
