package com.cars.controllers;

import com.cars.models.viewModels.SaleViewModel;
import com.cars.servicies.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("all")
    public String showAllSales(Model model) {
        List<SaleViewModel> sales = this.saleService.getAllSales();
        model.addAttribute("sales", sales);

        return "sales";
    }

    @GetMapping("{id}")
    public String showSaleById(@PathVariable long id, Model model) {
        SaleViewModel saleViewModel = this.saleService.findById(id);
        model.addAttribute("sales", saleViewModel);
        return "sale-details";
    }

    @GetMapping("discounted")
    public String getAllDiscountedSales(Model model) {
        List<SaleViewModel> sales = this.saleService.findAllDiscountedSales();
        model.addAttribute("sales", sales);
        return "sales";
    }

    @GetMapping("discounted/{percent:.+}")
    public String showDiscountedSales(@PathVariable String percent, Model model) {

        try {
            double discount = Double.valueOf(percent);
            List<SaleViewModel> sales = this.saleService.findSalesByPercentage(discount);
            if (sales == null) {
                model.addAttribute("error", "Error");
            } else {
                model.addAttribute("sales", sales);
            }
        } catch (NumberFormatException nfe) {
            model.addAttribute("error", "Error");
        }

        return "sales-discounted";
    }
}
