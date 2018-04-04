package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "add-service")
public interface AddRemote {
	@RequestMapping(value = "/add")
    public String add(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b);
}
