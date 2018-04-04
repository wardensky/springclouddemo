package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/divided", method = RequestMethod.GET)
	public @ResponseBody String home(@RequestParam int a,@RequestParam int b) {
		if (b == 0) {
			return "b is 0";
		}
		return a / b + "";
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public @ResponseBody User find() {
		return userDao.selectFirst();
	}
}
