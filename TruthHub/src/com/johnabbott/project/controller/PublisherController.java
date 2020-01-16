//package com.johnabbott.project.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping({"/home", "/welcome", "/"})
//public class PublisherController {
//	
//	@RequestMapping(value = "/getPublishers", method = RequestMethod.GET)
//	public String getFootagesList() {
//		return "publisher-list";
//	}
//}

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

import com.johnabbott.project.model.PublisherEntity;
import com.johnabbott.project.service.PublisherService;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

	@Autowired
	PublisherService service;

	@RequestMapping("/testmethod")
	public ModelAndView getName() {
		ModelAndView mv = new ModelAndView("test-jsp");
		mv.addObject("gao", "peng");

		return mv;
	}

	@RequestMapping(value = "/getpublishers", method = RequestMethod.GET)
	public ModelAndView getPublishersList() {
		ModelAndView modelView = new ModelAndView("publisher-list");

		List<PublisherEntity> publishers = service.getPublishers();
		modelView.addObject("publisherList", publishers);
		modelView.addObject("publisher", new PublisherEntity());

		return modelView;
	}

	// ..../TruthHub/footages/footage/Accident
	// Accident would be passed via path variable
	@RequestMapping(value = "/publisher/{title}", method = RequestMethod.GET)
	public ModelAndView getPublisher(@PathVariable("title") String publisherTitle) {
		ModelAndView modelView = new ModelAndView("publisher");
		modelView.addObject("publisherTitle", publisherTitle);

		return modelView;
	}

	@RequestMapping(value = "addpublisher")
	public ModelAndView addPublisher() {
		ModelAndView mv = new ModelAndView("add-publisher");
		mv.addObject("publisher", new PublisherEntity());
		return mv;
	}
	
	@RequestMapping(value = "savePublisher", method = RequestMethod.POST)
	public String savePublisher(@ModelAttribute("publisher") PublisherEntity pblsr) {
		if (service.addPublisher(pblsr))
			return "redirect:/publishers/getpublishers";
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping(value = "deletefootage")
	public String deletePublisher(@RequestParam("studentId") int footageId) {
		if (service.deletePublisher(footageId)) {
			return "redirect:/publishers/getpublishers";
		}
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping(value = "editpublisher")
	public ModelAndView editPublisher(@RequestParam("publisherId") int publisherId) {
		ModelAndView mv = new ModelAndView("update-publisher");
		PublisherEntity fetchedPublisher = service.getPublisherById(publisherId);
		mv.addObject("editedpublisher", fetchedPublisher);
		return mv;
	}

	@RequestMapping(value = "updatePublisher")
	public String updatePublisher(@ModelAttribute("publisher") PublisherEntity pblsr) {
		if (service.updatePublisher(pblsr)) {
			return "redirect:/publishers/getpublishers";
		} else {
			return "ErrorPage";
		}
	}

}

