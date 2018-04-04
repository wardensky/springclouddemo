package com.example.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
		System.out.println("我走到这里了");
	}
}

@RestController
class BusinessController1 {
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		ServiceInstance instance = this.loadBalancerClient.choose("add-service");
		URI helloUri = URI
				.create(String.format("http://%s:%s/add?a=%s&b=%s", instance.getHost(), instance.getPort(), 1, 2));
		return new RestTemplate().getForEntity(helloUri, String.class).getBody();
	}
}