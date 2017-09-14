package com.cars.controllers;

import com.cars.models.viewModels.SupplierViewModel;
import com.cars.servicies.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/{type}")
    public String showLocalSuppliers(@PathVariable String type, Model model) {
        if (type == null) {
            model.addAttribute("error", "Error");
            return "redirect:/suppliers";
        }

        List<SupplierViewModel> suppliers = null;
        if ("local".equalsIgnoreCase(type)) {
            suppliers = this.supplierService.findLocalSuppliers();
        } else if ("importers".equalsIgnoreCase(type)) {
            suppliers = this.supplierService.findImportersSuppliers();
        } else {
            model.addAttribute("error", "Error");
            return "redirect:/suppliers";
        }

        model.addAttribute("suppliers", suppliers);
        return "suppliers";
    }
}
