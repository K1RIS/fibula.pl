package pl.fibula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeroController {
	
	@GetMapping(path = "/createcharacter")
	public String home() {
		return "createCharacter";
	}
	
}
