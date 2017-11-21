package pl.fibula.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.fibula.entity.Gender;
import pl.fibula.entity.Hero;
import pl.fibula.repository.GenderRepository;
import pl.fibula.repository.HeroRepository;
import pl.fibula.repository.ProfessionRepository;

@Controller
public class HeroController {

	@Autowired
	private HeroRepository heroRepository;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private ProfessionRepository professionRepository;

	@GetMapping(path = "account/createcharacter")
	public String home(Model model) {
		model.addAttribute("hero", new Hero());
		return "account/createcharacter";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "account/createcharacter")
	public String create(@Valid Hero hero, BindingResult bresult) {
		if (bresult.hasErrors()) {
			return bresult.toString();
		} else {
			hero.setProfession(professionRepository.findById(1l));
			heroRepository.save(hero);
			return "dodano";
		}
	}

	@ModelAttribute("genders")
	public List<Gender> findAllGenders() {
		return genderRepository.findAll();
	}

}
