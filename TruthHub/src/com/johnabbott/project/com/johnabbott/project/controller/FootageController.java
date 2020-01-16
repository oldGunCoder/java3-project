package com.johnabbott.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.project.model.AddressEntity;
import com.johnabbott.project.model.FootageEntity;
import com.johnabbott.project.service.FootageService;

@Controller
@RequestMapping("/footages")
public class FootageController {

	@Autowired
	FootageService service;

	@RequestMapping("/testmethod")
	public ModelAndView getName() {
		ModelAndView mv = new ModelAndView("test-jsp");
		mv.addObject("obj", "reza");

		return mv;
	}

	@RequestMapping(value = "/getfootages", method = RequestMethod.GET)
	public ModelAndView getFootagesList() {
		ModelAndView modelView = new ModelAndView("footage-list");

		List<FootageEntity> footages = service.getFootages();
		modelView.addObject("footageList", footages);
		modelView.addObject("footage", new FootageEntity());

		return modelView;
	}

	// ..../testconfigproject/students/student/Alex
	// Alex would be passed via path variable
	@RequestMapping(value = "/footage/{name}", method = RequestMethod.GET)
	public ModelAndView getFootage(@PathVariable("name") String footageName) {
		ModelAndView modelView = new ModelAndView("footage");
		modelView.addObject("footageName", footageName);

		return modelView;
	}

	@RequestMapping(value = "addfootage")
	public ModelAndView addFootage() {
		ModelAndView mv = new ModelAndView("add-footage");
		mv.addObject("footage", new FootageEntity());
		return mv;
	}
	
	@RequestMapping(value = "saveFootage", method = RequestMethod.POST)
	public String saveFootage(@ModelAttribute("footage") FootageEntity ftg) {
		AddressEntity address = new AddressEntity();
		address.setStreetName("Sherbrook");
		address.setStreetNo(16);
		ftg.setAddress(address);
		if (service.addFootage(ftg))
			return "redirect:/footages/getfootages";
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping(value = "deletestudent")
	public String deleteFootage(@RequestParam("footageId") int footageId) {
		if (service.deleteFootage(footageId)) {
			return "redirect:/footages/getfootages";
		}
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping(value = "editfootage")
	public ModelAndView editStudent(@RequestParam("footageId") int footageId) {
		ModelAndView mv = new ModelAndView("update-footage");
		FootageEntity fetchedFootage = service.getFootageById(footageId);
		mv.addObject("editedfootage", fetchedFootage);
		return mv;
	}

	@RequestMapping(value = "updateFootage")
	public String updateFootage(@ModelAttribute("footage") FootageEntity ftg) {
		if (service.updateFootage(ftg)) {
			return "redirect:/footages/getfootages";
		} else {
			return "ErrorPage";
		}
	}

}
