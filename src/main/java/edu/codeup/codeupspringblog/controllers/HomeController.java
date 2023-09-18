package edu.codeup.codeupspringblog.controllers;//package edu.codeup.codeupspringblog.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//public class HomeController {
//
//	@GetMapping("/")
//	@ResponseBody
//	public String landingPage() {
//		return "This is the landing page";
//	}
//}


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String welcome() {
		return "home";
	}

	@GetMapping("/join")
	public String showJoinForm(Model model) {
		List<docrob.springblog.models.Item> shoppingCart = new ArrayList<>();
		shoppingCart.add(new docrob.springblog.models.Item("screwdriver"));
		shoppingCart.add(new docrob.springblog.models.Item("hammer"));
		shoppingCart.add(new docrob.springblog.models.Item("drill"));
		model.addAttribute("shoppingCart", shoppingCart);
		return "join";
	}

	@PostMapping("/join")
	public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
		model.addAttribute("cohort", "Welcome to " + cohort + "!");
		return "join";
	}
}
