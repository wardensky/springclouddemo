package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MinusSrv {

	public int exec(int a, int b) {
		return a - b;
	}
}
