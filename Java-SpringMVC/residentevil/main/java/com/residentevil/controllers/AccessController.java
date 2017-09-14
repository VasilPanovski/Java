package com.residentevil.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

    @GetMapping("/access")
    public String getNoAccess(){
        return "No Access";
    }

}
