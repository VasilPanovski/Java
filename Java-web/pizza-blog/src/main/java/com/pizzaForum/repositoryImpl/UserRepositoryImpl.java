package com.pizzaForum.repositoryImpl;

import com.pizzaForum.entities.User;
import com.pizzaForum.repositories.UserRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean isAdmin() {
        User user = this.findById(1L);

        return user == null ? true : false;
    }

    @Override
    public User findById(long id) {
        Query query = this.entityManager.createQuery("SELECT u FROM users AS u WHERE u.id =:id");
        query.setParameter("id", id);
        List<User> users = query.getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User findByEmailOrUsername(String username) {
        List<User> users = null;
        Query query = null;
        if (username.contains("@")) {
            query = this.entityManager.createQuery("SELECT u FROM users AS u WHERE u.email =:email");
            query.setParameter("email", username);
            users = query.getResultList();
        } else {
            query = this.entityManager.createQuery("SELECT u FROM users AS u WHERE u.username =:username");
            query.setParameter("username", username);
            users = query.getResultList();
        }

        return users.stream().findFirst().orElse(null);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Query query = this.entityManager.createQuery("SELECT u FROM users AS u WHERE u.username =:username AND u.password =:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> users = query.getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void save(User user) {
        if (this.isAdmin()) {
            user.setAdmin(true);
        } else {
            user.setAdmin(false);
        }

        this.entityManager.persist(user);
    }
}
