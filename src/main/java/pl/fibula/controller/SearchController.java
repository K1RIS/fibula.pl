package pl.fibula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.fibula.entity.Hero;
import pl.fibula.repository.HeroRepository;

@Controller
public class SearchController {

	@Autowired
	private HeroRepository heroRepository;
	
	@GetMapping(path = "statistics/search")
	public String home() {
		return "statistics/search";
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "statistics/search")
	public String search(String name) {
		return name;
	}
	
}
