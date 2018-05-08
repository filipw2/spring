package com.itemtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itemtracker.model.dao.Kopalnia;
import com.itemtracker.model.dao.KopalniaRepository;

@Controller
public class DataController {

	@Autowired
	KopalniaRepository kopalniaRepository;
	
	@RequestMapping("/data")
	public ModelAndView getData() {
		ModelAndView modelAndView=new ModelAndView();
		List<Kopalnia> kopalnie = kopalniaRepository.findAll();
		//kopalnie.stream().forEach(d->System.out.println(d.getName()));
		System.out.println(kopalnie.size());
		modelAndView.addObject("kopalnie",kopalnie);
		
		modelAndView.addObject("test","test");
		return modelAndView;
	}
	
}
