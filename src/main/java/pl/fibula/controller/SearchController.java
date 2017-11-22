package pl.fibula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.fibula.entity.Hero;
import pl.fibula.repository.HeroRepository;

@Controller
public class SearchController {

	@Autowired
	private HeroRepository heroRepository;

	@RequestMapping("search")
	public String home() {
		return "statistics/search";
	}

	@RequestMapping("character")
	String search(@RequestParam String name, Model model) {
		Hero hero = heroRepository.findByName(name);
		if(hero == null) {
			return "redirect:search";
		}
		model.addAttribute(hero);
		return "character";
	}
}
