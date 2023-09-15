package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

	@GetMapping("/add/{num1}/and/{num2}")
	@ResponseBody
	public String addNums(@PathVariable int num1, @PathVariable int num2) {
		int sum = num1 + num2;
		return String.format(num1 + " plus " + num2 + " is " + sum);
	}


	@GetMapping("/subtract/{num1}/from/{num2}")
	@ResponseBody
	public String subtractNums(@PathVariable int num1, @PathVariable int num2) {
		int total = num2 - num1;
		return String.format(num2 + " minus " + num1 + " is " + total);
	}


	@GetMapping("/multiply/{num1}/and/{num2}")
	@ResponseBody
	public String multiplyNums(@PathVariable int num1, @PathVariable int num2) {
		int sum = num1 * num2;
		return String.format(num1 + " minus " + num2 + " is " + sum);
	}


	@GetMapping("/divide/{num1}/by/{num2}")
	@ResponseBody
	public String divideNums(@PathVariable double num1, @PathVariable double num2) {
		double total = num1 / num2;
		return String.format(num1 + " divided " + num2 + " is " + total);
	}

}
