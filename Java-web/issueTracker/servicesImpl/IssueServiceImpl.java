package com.issueTracker.servicesImpl;

import com.issueTracker.entities.issue.Issue;
import com.issueTracker.entities.issue.Priority;
import com.issueTracker.entities.issue.Status;
import com.issueTracker.entities.user.User;
import com.issueTracker.models.bindingModels.IssueBindingModel;
import com.issueTracker.models.viewModels.IssueViewModel;
import com.issueTracker.repositories.IssueRepository;
import com.issueTracker.services.IssueService;
import com.issueTracker.utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@Stateless
public class IssueServiceImpl implements IssueService {

    @Inject
    private IssueRepository issueRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void save(IssueBindingModel issueBindingModel) {
        Issue issue = this.modelParser.convert(issueBindingModel, Issue.class);
        issue.setStatus(Status.valueOf(issueBindingModel.getStatus().toUpperCase()));
        issue.setPriority(Priority.valueOf(issueBindingModel.getPriority().toUpperCase()));
        this.issueRepository.save(issue);
    }

    @Override
    public void update(IssueBindingModel issueBindingModel) {
        Issue issue = this.modelParser.convert(issueBindingModel, Issue.class);
        issue.setStatus(Status.valueOf(issueBindingModel.getStatus().toUpperCase()));
        issue.setPriority(Priority.valueOf(issueBindingModel.getPriority().toUpperCase()));
        this.issueRepository.update(issue);
    }

    @Override
    public Set<IssueViewModel> findAll() {
        Set<Issue> issues = this.issueRepository.findAll();
        Set<IssueViewModel> issueViewModels = new HashSet<>();
        for (Issue issue : issues) {
            IssueViewModel issueViewModel = this.modelParser.convert(issue, IssueViewModel.class);
            issueViewModels.add(issueViewModel);
        }

        return issueViewModels;
    }

    @Override
    public Set<IssueViewModel> searchIssues(String status, String name) {
        Set<Issue> issues = this.issueRepository.findAllByStatusAndName(status, name);
        Set<IssueViewModel> issueViewModels = new HashSet<>();
        for (Issue issue : issues) {
            IssueViewModel issueViewModel = this.modelParser.convert(issue, IssueViewModel.class);
            issueViewModels.add(issueViewModel);
        }

        return issueViewModels;
    }

    @Override
    public IssueViewModel findById(long id) {
        Issue issue = this.issueRepository.findById(id);
        IssueViewModel issueViewModel = this.modelParser.convert(issue, IssueViewModel.class);
        return issueViewModel;
    }

    @Override
    public void deleteById(long id) {
        this.issueRepository.deleteById(id);
    }
}
