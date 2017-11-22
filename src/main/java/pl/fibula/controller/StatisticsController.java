package pl.fibula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {
	
	@RequestMapping("statistics")
	public String home(Model model) {
		return "statistics";
	}

	//select column_name from information_schema.columns where table_name='hero' 
	
}
