package com.mvcFramework.testControllers;

import com.mvcFramework.annotations.controllers.Controller;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;

@Controller
public class BeerController {

    @GetMapping("/beer")
    public String getBeer(/*Model model*/){
        //model.addAttribute("key", "value");
        return "beer";
    }

    @PostMapping("/beer")
    public String submitBeer(@RequestParam("brand") String beerBrand) {
        System.out.println(beerBrand);
        return "beer";
    }
    @GetMapping("/beer/edit/{id}")
    public String getBeerId(@PathVariable("id") long id){
        System.out.println(id);
        //model.addAttribute("id", id);
        return "beer";
    }

    @PostMapping("/beer/edit/{id}")
    public String postBeerBrand(@RequestParam("brand") String brand){
        System.out.println(brand);
        return "redirect:/beer";
    }
}
