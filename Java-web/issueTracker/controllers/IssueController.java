package com.issueTracker.controllers;

import com.issueTracker.entities.user.User;
import com.issueTracker.models.bindingModels.IssueBindingModel;
import com.issueTracker.models.viewModels.IssueViewModel;
import com.issueTracker.services.IssueService;
import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Set;

@Stateless
@Controller
public class IssueController {

    @Inject
    private IssueService issueService;

    @GetMapping("/issues")
    public String getIssuesPage(Model model, @RequestParam("status") String status, @RequestParam("name") String name) {
        Set<IssueViewModel> issueViewModels = null;
        if(status == null || status.equals("All")){
            issueViewModels = this.issueService.findAll();
        } else {
            issueViewModels = this.issueService.searchIssues(status.toUpperCase(), name);
        }

        model.addAttribute("issueViewModels", issueViewModels);
        return "/templates/issues";
    }

    @GetMapping("/issues/add")
    public String getAddIssuePage() {
        return "/templates/add-issue";
    }

    @PostMapping("/issues/add")
    public String addIssue(@ModelAttribute IssueBindingModel issueBindingModel, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        issueBindingModel.setAuthor(user);
        issueBindingModel.setCreatedOn(new Date());
        this.issueService.save(issueBindingModel);
        return "redirect:/issues";
    }

    @GetMapping("/issues/edit/{issueId}")
    public String getEditIssuesPage(@PathVariable("issueId") long issueId, Model model) {
        IssueViewModel issueViewModel = this.issueService.findById(issueId);
        model.addAttribute("issueViewModel", issueViewModel);
        return "/templates/edit-issue";
    }

    @PostMapping("/issues/edit/{issueId}")
    public String editIssue(@PathVariable("issueId") long issueId, @ModelAttribute IssueBindingModel issueBindingModel) {
        issueBindingModel.setId(issueId);
        this.issueService.update(issueBindingModel);
        return "redirect:/issues";
    }

    @GetMapping("/issues/delete/{issueId}")
    public String deleteIssue(@PathVariable("issueId") long issueId) {
        this.issueService.deleteById(issueId);
        return "redirect:/issues";
    }
}
