package fr.cda.librairie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AccueilController {

    @GetMapping(value = "/index")
    public void sayHello() {

    }
}
