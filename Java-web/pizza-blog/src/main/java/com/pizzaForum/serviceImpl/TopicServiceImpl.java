package com.pizzaForum.serviceImpl;

import com.pizzaForum.entities.Topic;
import com.pizzaForum.models.binding.CreateTopicModel;
import com.pizzaForum.repositories.TopicRepository;
import com.pizzaForum.services.TopicService;
import com.pizzaForum.utils.parser.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TopicServiceImpl implements TopicService {

    @Inject
    private TopicRepository topicRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void create(CreateTopicModel createTopicModel) {
        Topic topic = this.modelParser.convert(createTopicModel, Topic.class);
        this.topicRepository.createTopic(topic);
    }
}
