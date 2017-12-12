package pl.fibula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.fibula.dao.CustomHeroRepository;
import pl.fibula.entity.Hero;

@Controller
public class HighscoresController {

	@Autowired
	private CustomHeroRepository customHeroRepository;

	@RequestMapping("highscores")
	public String showHighscoresOrForm(@RequestParam(value = "skill", required = false)String skill, Model model) {
		if (skill != null) {
			List<Hero> heroes = customHeroRepository.findTheBestIn(skill);
			model.addAttribute("heroes", heroes);
			return "highscores/highscores";
		}
		return "highscores/form";
	}

}
