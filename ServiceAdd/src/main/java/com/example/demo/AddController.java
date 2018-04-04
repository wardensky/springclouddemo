package com.example.demo;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController {
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public String add(@PathParam("a") int a, @PathParam("b") int b) {
		return a + b + "";
	}
}
