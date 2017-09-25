package com.pizzaForum.controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.pizzaForum.models.binding.CreateTopicModel;
import com.pizzaForum.models.view.LoggedUserModel;
import com.pizzaForum.services.TopicService;
import com.pizzaForum.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Stateless
@Controller
public class TopicsController {

    @Inject
    private TopicService topicService;

    @GetMapping("/home/topics/new")
    public String loadHome() {
        return "templates/home";
    }

    @GetMapping("/home/topics/new")
    public String loadTopicPage() {
        return "templates/topic-new";
    }

    @PostMapping("/home/topics/new")
    public String createTopic(@ModelAttribute CreateTopicModel createTopicModel, HttpSession session) {

        if (createTopicModel.getTitle() == null || createTopicModel.getContent() == null || createTopicModel.getCategoryName() == null) {
            return "templates/topic-new";
        }

        LoggedUserModel loggedUserModel = (LoggedUserModel) session.getAttribute("user");
        createTopicModel.setAuthorUsername(loggedUserModel.getUsername());
        this.topicService.create(createTopicModel);

        return "redirect:/home/topics";
    }
}
