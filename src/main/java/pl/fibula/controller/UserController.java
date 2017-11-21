package pl.fibula.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.fibula.entity.User;
import pl.fibula.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET, value = "account/register")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "account/register";
	}
		
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "account/register")
	public String register(@Valid User user, BindingResult bresult) {
		if(bresult.hasErrors()) {
			return "error";
		}else {
			userRepository.save(user);
			return "dodano";
		}
	}
	
}
