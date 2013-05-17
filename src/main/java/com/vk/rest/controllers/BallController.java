package com.vk.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BallController {
	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		return "Hello world!";
	}
}
