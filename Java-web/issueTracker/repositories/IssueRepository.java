package com.issueTracker.repositories;

import com.issueTracker.entities.issue.Issue;
import com.issueTracker.entities.user.User;

import java.util.Set;

public interface IssueRepository {

    void save(Issue issue);

    void update(Issue issue);

    Set<Issue> findAll();

    Set<Issue> findAllByStatusAndName(String status, String name);

    Issue findById(long id);

    void deleteById(long id);
}
