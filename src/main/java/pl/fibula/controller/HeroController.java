package pl.fibula.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.ResponseBody;

import pl.fibula.entity.Gender;
import pl.fibula.entity.Hero;
import pl.fibula.entity.World;
import pl.fibula.entity.User;
import pl.fibula.repository.GenderRepository;
import pl.fibula.repository.HeroRepository;
import pl.fibula.repository.ProfessionRepository;
import pl.fibula.repository.WorldRepository;
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

	@Autowired
	private WorldRepository worldRepository;

	@GetMapping("account/character/create")
	public String showCreatingCharacterForm(Model model) {
		model.addAttribute("hero", new Hero());
		return "account/hero/create";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/character/create")
	public String createCharacterAndRedirect(@Valid Hero hero, BindingResult bresult, HttpSession ses) {
		if (bresult.hasErrors()) {
			return "account/hero/create";
		} else if (ses.getAttribute("userName") != null) {
			String userName = (String) ses.getAttribute("userName");
			User user = userRepository.findByName(userName);
			hero.setUser(user);
			hero.setProfession(professionRepository.findOne(1l));
			heroRepository.save(hero);
			return "redirect:/account";
		} else {
			return "redirect:login";
		}
	}

	@ModelAttribute("genders")
	public List<Gender> findAllGenders() {
		return genderRepository.findAll();
	}

	@ModelAttribute("worlds")
	public List<World> findAllWorlds() {
		return worldRepository.findAll();
	}

	@RequestMapping("account/character/edit/{name}")
	String showEditForm(@PathVariable String name, Model model) {
		Hero hero = heroRepository.findByName(name);
		model.addAttribute(hero);
		return "account/hero/edit";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/character/edit/{name}")
	public String editAndRedirectToAccountManagment(@Valid Hero hero) {
		heroRepository.save(hero);
		return "redirect:/account";
	}

	@RequestMapping("account/character/delete/{name}")
	String delete(@PathVariable String name, Model model) {
		heroRepository.delete(heroRepository.findByName(name));
		return "redirect:/account";
	}

	@ResponseBody
	@RequestMapping(value = "heroValidate", method = RequestMethod.POST)
	public String heroNameValidate(Model model, String variable) {
		if(variable.length() < 8 || variable.length() > 15) {
			return "The character name must have at least 8 and less than 15 letters!";
		} else if (heroRepository.findByName(variable) == null) {
			return "name already used";
		} else {
			return "dobrze";
		} 
	}
	
}
