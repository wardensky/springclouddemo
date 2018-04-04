package com.example.demo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = "/divided", method = RequestMethod.GET)
	public @ResponseBody String home(@RequestParam int a,@RequestParam int b) {
		if (b == 0) {
			return "b is 0";
		}
		return a / b + " " + new Date().toLocaleString();
	}
	
}
