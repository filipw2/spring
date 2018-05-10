package com.itemtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itemtracker.main.Parser;
import com.itemtracker.model.dao.Cena;
import com.itemtracker.model.dao.CenaRepository;

@Controller
public class DataController {

	@Autowired
	CenaRepository cenaRepository;
	@Autowired
	Parser parser;
	@RequestMapping("/data")
	public ModelAndView getData() {
		parser.parse();
		ModelAndView modelAndView=new ModelAndView();
		List<Cena> ceny = cenaRepository.findAll();
		//kopalnie.stream().forEach(d->System.out.println(d.getName()));
		System.out.println(ceny.size());
		modelAndView.addObject("ceny",ceny);
		
		modelAndView.addObject("test","test");
		return modelAndView;
	}
	
}
