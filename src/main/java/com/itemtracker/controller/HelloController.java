package com.itemtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itemtracker.model.dao.Kopalnia;
import com.itemtracker.model.dao.KopalniaRepository;

@Controller
public class HelloController {
	
	@Autowired
	KopalniaRepository kopR;
	@RequestMapping(value ="/", method = RequestMethod.GET)
	   public String index() {
	      return "index";
	   }
	
	@RequestMapping(value ="/", method = RequestMethod.POST)
	public String saveKopalnia(@ModelAttribute("kopalnia") Kopalnia kopalnia) {
		kopR.save(kopalnia);
		return "data";
	}
}
