package com.quasarcelestio.springBootDemo.Spring.Boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Anotation
public class SpringBootDemoApplication implements CommandLineRunner {

	@Autowired //used to tell spring boot that it has to be connected with bean
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//		db = new ProdDB();
		System.out.println(db.getdata());
	}
}
