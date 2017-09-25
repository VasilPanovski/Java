package com.pizzaForum.repositoryImpl;

import com.pizzaForum.entities.Topic;
import com.pizzaForum.repositories.TopicRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TopicRepositoryImpl implements TopicRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createTopic(Topic topic) {
        this.entityManager.persist(topic);
    }
}
