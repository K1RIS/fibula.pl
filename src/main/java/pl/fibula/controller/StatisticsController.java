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
public class StatisticsController {

	@Autowired
	private CustomHeroRepository customHeroRepository;

	@RequestMapping("statistics/choose")
	public String home(Model model) {
		return "chose";
	}

	@RequestMapping("statistics")
	public String stats(@RequestParam String skill, Model model) {
		List<Hero> heroes = customHeroRepository.findTheBestIn(skill);
		model.addAttribute("heroes", heroes);	
		return "statistics";
	}

}
