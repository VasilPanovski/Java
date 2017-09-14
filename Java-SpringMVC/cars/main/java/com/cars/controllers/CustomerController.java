package com.cars.controllers;

import com.cars.models.bindingModels.AddCustomerModel;
import com.cars.models.bindingModels.EditCustomerModel;
import com.cars.models.viewModels.CustomerSalesViewModel;
import com.cars.models.viewModels.CustomersViewModel;
import com.cars.servicies.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public String showAllCustomerAsc(Model model, @RequestParam(required = false, value = "sort") String sort) {
        List<CustomersViewModel> customers = null;
        if ("Descending".equalsIgnoreCase(sort)) {
            customers = this.customerService.findAllDesc();
        } else {
            customers = this.customerService.findAllAsc();
        }

        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("{id}")
    public String getTotalSales(@PathVariable long id, Model model) {
        CustomerSalesViewModel customerSalesViewModel = this.customerService.findById(id);
        if (customerSalesViewModel == null) {
            model.addAttribute("error", "Error");
        } else {
            model.addAttribute("customer", customerSalesViewModel);
        }

        return "customer-sales";
    }

    @GetMapping("add")
    public String loadAddCustomerPage(Model model) {
        model.addAttribute("addModel", new AddCustomerModel());
        return "add-customer";
    }

    @PostMapping("add")
    public String addCustomer(@ModelAttribute AddCustomerModel addCustomerModel, RedirectAttributes redirectAttributes) {
        if (addCustomerModel == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid input");
            return "redirect:/customers/add";
        }

        boolean isSaved = this.customerService.save(addCustomerModel);
        if (!isSaved) {
            redirectAttributes.addFlashAttribute("error");
            return "redirect:/customers/add";
        }

        return "redirect:/customers/all";
    }

    @GetMapping("edit/{id}")
    public String showEditCustomer(@PathVariable long id, Model model) {
        EditCustomerModel editModel = this.customerService.findByIdForEdit(id);
        model.addAttribute("editModel", editModel);
        return "edit-customer";
    }

    @PostMapping("edit/{id}")
    public String editCustomer(@PathVariable long id,@ModelAttribute EditCustomerModel editCustomerModel, RedirectAttributes redirectAttributes) {
        editCustomerModel.setId(id);
        boolean isUpdated = this.customerService.update(editCustomerModel);
        if (!isUpdated) {
            redirectAttributes.addAttribute("error");
        }

        return "redirect:/customers/all";
    }
}
