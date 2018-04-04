package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "add-service")
public interface FeignSrv {
	@RequestMapping(value = "/add")
	public int add(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b);
}
