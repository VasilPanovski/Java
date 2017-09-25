package com.issueTracker.repositoriesImpl;

import com.issueTracker.entities.issue.Issue;
import com.issueTracker.entities.issue.Status;
import com.issueTracker.entities.user.User;
import com.issueTracker.repositories.IssueRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class IssueRepositoryImpl implements IssueRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Issue issue) {
        this.entityManager.persist(issue);
    }

    @Override
    public void update(Issue issue) {
        this.entityManager.merge(issue);
    }

    @Override
    public Set<Issue> findAll() {
        Query query = this.entityManager.createQuery("SELECT i FROM Issue AS i");
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Set<Issue> findAllByStatusAndName(String status, String name) {
        Query query = this.entityManager.createQuery("SELECT i FROM Issue AS i " +
                "WHERE i.status = :status " +
                "AND i.name LIKE :name");
        query.setParameter("name", "%" + name + "%");
        query.setParameter("status", Status.valueOf(status));
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Issue findById(long id) {
        Query query = this.entityManager.createQuery("SELECT i FROM Issue AS i WHERE i.id = :id");
        query.setParameter("id", id);
        List<Issue> issues = query.getResultList();
        Issue issue = null;
        if(issues.size() > 0){
            issue = issues.stream().findFirst().get();
        }

        return issue;
    }

    @Override
    public void deleteById(long id) {
        Query query = this.entityManager.createQuery("DELETE FROM Issue AS i WHERE i.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
