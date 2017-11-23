package pl.fibula.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.fibula.entity.Gender;
import pl.fibula.entity.Hero;
import pl.fibula.repository.GenderRepository;
import pl.fibula.repository.HeroRepository;
import pl.fibula.repository.ProfessionRepository;
import pl.fibula.repository.UserRepository;

@Controller
public class HeroController {

	@Autowired
	private HeroRepository heroRepository;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private ProfessionRepository professionRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("account/createcharacter")
	public String home(Model model) {
		model.addAttribute("hero", new Hero());
		return "account/createcharacter";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/createcharacter")
	public String create(@Valid Hero hero, BindingResult bresult) {
		if (bresult.hasErrors()) {
			return "account/createcharacter";
		} else {
			hero.setProfession(professionRepository.findOne(1l));
			hero.setUser(userRepository.findOne(1l));
			heroRepository.save(hero);
			return "redirect:/account";
		}
	}

	@ModelAttribute("genders")
	public List<Gender> findAllGenders() {
		return genderRepository.findAll();
	}
	
	@RequestMapping("account/character/edit/{name}")
	String edit(@PathVariable String name, Model model) {
		Hero hero = heroRepository.findByName(name);
		model.addAttribute(hero);
		return "account/edit";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "account/character/edit/{name}")
	public String edit2(@Valid Hero hero) {
		heroRepository.save(hero);
		return "redirect:/account";
	}
	
	@RequestMapping("account/character/delete/{name}")
	String delete(@PathVariable String name, Model model) {
		heroRepository.delete(heroRepository.findByName(name));
		return "redirect:/account";
	}
	
}
