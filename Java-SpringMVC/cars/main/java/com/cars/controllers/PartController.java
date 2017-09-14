package com.cars.controllers;

import com.cars.models.bindingModels.AddPartModel;
import com.cars.models.bindingModels.SupplierModel;
import com.cars.models.viewModels.PartViewModel;
import com.cars.models.viewModels.SupplierViewModel;
import com.cars.servicies.PartService;
import com.cars.servicies.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("part")
public class PartController {

    @Autowired
    private PartService partService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("all")
    public String getAllParts(Model model) {
        List<PartViewModel> parts = this.partService.getAllParts();
        model.addAttribute("parts", parts);

        return "parts";
    }

    @GetMapping("add")
    public String loadAddPartPage(Model model) {
        List<SupplierViewModel> suppliers = this.supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("partModel", new AddPartModel());
        return "add-part-form";
    }

    @PostMapping("add")
    public String addPart(@ModelAttribute AddPartModel addPartModel, @RequestParam String supplierName) {
        SupplierModel supplierModel = this.supplierService.findByName(supplierName);
        addPartModel.setSupplier(supplierModel);
        addPartModel.setQuantity(addPartModel.getQuantity() < 1 ? 1 : addPartModel.getQuantity());

        partService.savePart(addPartModel);

        return "redirect:/part/all";
    }

    @GetMapping("delete/{id}")
    public String getDeletePage(@PathVariable Long id, Model model) {
        PartViewModel partViewModel = this.partService.getPartById(id);
        model.addAttribute("partModel", partViewModel);
        return "delete-part-form";
    }

    @PostMapping("delete/{id}")
    public String deletePart(@PathVariable Long id, @ModelAttribute PartViewModel partViewModel) {
        partViewModel.setId(id);
        this.partService.deletePart(partViewModel);
        return "redirect:/part/all";
    }

    @GetMapping("edit/{id}")
    public String getEditPage(@PathVariable Long id, Model model) {
        PartViewModel partViewModel = this.partService.getPartById(id);
        model.addAttribute("partModel", partViewModel);
        return "edit-part-form";
    }

    @PostMapping("edit/{id}")
    public String editPart(@PathVariable Long id, @ModelAttribute PartViewModel partViewModel) {
        partViewModel.setId(id);
        this.partService.update(partViewModel);
        return "redirect:/part/all";
    }
}
