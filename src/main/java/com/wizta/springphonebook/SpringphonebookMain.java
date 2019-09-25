package com.wizta.springphonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication
public class SpringphonebookMain {

  

	public static void main(String[] args)throws Exception{
		SpringApplication.run(SpringphonebookMain.class, args);
	}

}