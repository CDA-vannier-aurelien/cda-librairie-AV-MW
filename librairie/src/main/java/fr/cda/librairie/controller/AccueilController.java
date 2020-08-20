package fr.cda.librairie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

<<<<<<< HEAD
    @GetMapping(value = "/accueil")
    public String m2() {
        return "index";
    }

=======
	@GetMapping(value = "/index")
	public void sayHello() {
	
	}
>>>>>>> Dev
}
