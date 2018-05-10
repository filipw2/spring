package com.itemtracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itemtracker.main.Parser;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args){
		SpringApplication.run(Main.class,args);
	}
}
