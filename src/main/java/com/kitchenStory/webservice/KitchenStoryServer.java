package com.kitchenStory.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KitchenStoryServer {

	public static void main(String[] args) {
		SpringApplication.run(KitchenStoryServer.class, args);
		System.out.println("spring application works");
	}

}
