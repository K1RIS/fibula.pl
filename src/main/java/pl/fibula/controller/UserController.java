package pl.fibula.controller;

import javax.servlet.http.HttpSession;
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
	public String register(@Valid User user, BindingResult bresult, HttpSession ses) {
		if (bresult.hasErrors()) {
			return "account/register";
		} else {
			userRepository.save(user);
			ses.setAttribute("userName", user.getName());
			return "redirect:/account";
		}
	}

	@RequestMapping("account/login")
	public String xzczxc(Model model) {
		return "account/login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/login")
	public String xcz(@RequestParam String name, @RequestParam String password, HttpSession ses) {
		User user = userRepository.findByName(name);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				ses.setAttribute("userName", user.getName());
				return "redirect:";
			} else {
				return "redirect:login";
			}
		}
		return "redirect:login";
	}

	@RequestMapping("account")
	public String homepage(Model model, HttpSession ses) {
		if (ses.getAttribute("userName") != null) {
			String userName = (String) ses.getAttribute("userName");
			User user = userRepository.findByName(userName);
			model.addAttribute("user", user);
			return "account/managment";
		} else {
			return "redirect:account/login";
		}
	}

	@RequestMapping("account/logout")
	public String logout(Model mode, HttpSession ses) {
		if (ses.getAttribute("userName") != null) {
			ses.invalidate();
		}
		return "redirect:/";
	}

	@RequestMapping("account/changepassword")
	public String changePassword(Model model) {
		return "account/changepassword";
	}

	@RequestMapping(method = RequestMethod.POST, value = "account/changepassword")
	public String changePassword2(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("newPassword2") String newPassword2,
			HttpSession ses) {
		String userName = (String) ses.getAttribute("userName");
		User user = userRepository.findByName(userName);
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
	public String changeEmail2(@RequestParam("newEmail") String email, HttpSession ses) {
		String userName = (String) ses.getAttribute("userName");
		User user = userRepository.findByName(userName);
		user.setEmail(email);
		userRepository.save(user);
		return "redirect:";
	}

}
