package com.bing.controller.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/*")
@Log4j2
public class SampleController {

	@RequestMapping("/s01")
	public void basic() {
		log.info("## basic.....");
	}

	@RequestMapping("/ex01")
	public String ex01(@RequestParam("name") String name, @RequestParam("age") int age) {

		log.info("name: " + name);
		log.info("age: " + age);

		return "ex01";
	}

	@RequestMapping("/ex02")
	public String ex02(@ModelAttribute("page") int page) {

		log.info("page: " + page);

		return "ex02";
	}
}
