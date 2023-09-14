package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

	@GetMapping("/add/{num1}/and/{num2}")
	@ResponseBody
	public String distanceFromNum(@PathVariable int num1, @PathVariable int num2) {
		int add = num1 + num2;
		return String.format(num1 + " plus " + num2 + " is 7 ", num1, add, num2);
	}

}
