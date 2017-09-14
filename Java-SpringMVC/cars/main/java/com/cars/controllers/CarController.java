package com.cars.controllers;

import com.cars.models.bindingModels.AddCarModel;
import com.cars.models.viewModels.CarWithPartsViewModel;
import com.cars.models.viewModels.CarsViewModel;
import com.cars.models.viewModels.PartViewModel;
import com.cars.servicies.CarService;
import com.cars.servicies.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private PartService partService;

    @GetMapping("all")
    public String showAllCars(Model model, @RequestParam(value = "make", required = false) String make) {
        List<CarsViewModel> cars = this.carService.findAllCarsByMake(make);
        model.addAttribute("cars", cars);

        return "cars";
    }

    @GetMapping("{id}/parts")
    public String showCarsWithParts(@PathVariable long id, Model model) {
        CarWithPartsViewModel car = this.carService.findCarById(id);
        model.addAttribute("car", car);

        return "cars-with-parts";
    }

    @GetMapping("add")
    public String getAddPage(Model model) {
        List<PartViewModel> parts = this.partService.getAllParts();
        model.addAttribute("parts", parts);
        model.addAttribute("carModel", new AddCarModel());
        return "add-car-form";
    }

    @PostMapping("add")
    public String addCar(@ModelAttribute AddCarModel addCarModel) {
        this.carService.save(addCarModel);

        return "redirect:/cars/all";
    }

}
