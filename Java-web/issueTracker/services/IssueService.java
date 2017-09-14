package com.issueTracker.services;

import com.issueTracker.entities.issue.Issue;
import com.issueTracker.entities.user.User;
import com.issueTracker.models.bindingModels.IssueBindingModel;
import com.issueTracker.models.viewModels.IssueViewModel;

import java.util.Set;

public interface IssueService {

    void save(IssueBindingModel issueBindingModel);

    void update(IssueBindingModel issueBindingModel);

    Set<IssueViewModel> findAll();

    Set<IssueViewModel> searchIssues(String status, String name);

    IssueViewModel findById(long id);

    void deleteById(long id);
}
