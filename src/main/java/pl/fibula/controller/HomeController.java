package pl.fibula.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model, HttpSession ses) {
		if (ses.getAttribute("userName") != null) {
			return "redirect:account";
		}
		return "index";
	}

}
