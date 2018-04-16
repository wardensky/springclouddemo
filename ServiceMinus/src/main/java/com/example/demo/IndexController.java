package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@Autowired
	MinusSrv minusSrv;
	@Autowired
	FeignAddSrv feignAddSrv;

	@RequestMapping("/index")
	public @ResponseBody String index(@RequestParam("a") int a, @RequestParam("b") int b) {
		int num1 = minusSrv.exec(a, b);
		int num2 = feignAddSrv.exec(a, b);
		return String.format("(%d - %d) - (%d + %d) = %d", a, b, a, b, (num1 - num2));
	}
}
