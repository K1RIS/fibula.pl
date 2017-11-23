package pl.fibula.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.fibula.entity.User;
import pl.fibula.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("account/register")
	public String a(Model model) {
		model.addAttribute("user", new User());
		return "account/register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/register")
	public String register(@Valid User user, BindingResult bresult) {
		if (bresult.hasErrors()) {
			return "account/register";
		} else {
			userRepository.save(user);
			return "account/managment";
		}
	}

	@RequestMapping("account")
	public String homepage(Model model) {
		User user = userRepository.findOne(1l);
		model.addAttribute("user", user);
		return "account/managment";
	}

	@RequestMapping("account/changepassword")
	public String changePassword(Model model) {
		return "account/changepassword";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/changepassword")
	public String changePassword2(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("newPassword2") String newPassword2) {
		User user = userRepository.findOne(1l);
		if (user.getPassword().equals(oldPassword)) {
			if (newPassword.equals(newPassword2)) {
				user.setPassword(newPassword);
				userRepository.save(user);
				return "redirect:";
			}
		}
		return "account/changepassword";
	}

	@RequestMapping("account/changeemail")
	public String changeEmail(Model model) {
		return "account/changeemail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/changeemail")
	public String changeEmail2(@RequestParam("newEmail") String email) {
		User user = userRepository.findOne(1l);
		user.setEmail(email);
		userRepository.save(user);
		return "redirect:";
	}

}
