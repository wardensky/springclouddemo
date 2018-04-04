package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignAdd {
	@Autowired
	FeignSrv FeignSrv;

	@RequestMapping("/index")
	public int index(@RequestParam("a") int a, @RequestParam("b") int b) {
		return FeignSrv.add(a, b);
	}
}
