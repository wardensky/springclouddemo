package com.example.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController {
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public int add(@PathParam("a") int a, @PathParam("b") int b) {
		return a + b;
	}
	
	@RequestMapping(value = "/home")
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("url",  "http://www.baidu.com");
		model.addAttribute("frag",  "<h1>哈哈</h1>");
		return "home";
	}
}
