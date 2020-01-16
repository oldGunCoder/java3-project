package com.johnabbott.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/home", "/welcome", "/"})
public class PublisherController {
	
	@RequestMapping(value = "/getPublishers", method = RequestMethod.GET)
	public String getFootagesList() {
		return "publisher-list";
	}
}
