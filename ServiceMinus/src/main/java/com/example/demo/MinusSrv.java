package com.example.demo;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;

public class MinusSrv {
	@RequestMapping(value = "/minus")
	public int add(@PathParam("a") int a, @PathParam("b") int b) {
		return a - b;
	}
}
