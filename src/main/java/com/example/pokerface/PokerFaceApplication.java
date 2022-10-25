package com.example.pokerface;

import com.example.pokerface.Controllers.PokerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokerFaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokerFaceApplication.class, args);
		System.out.println("Let's deal some cards!");
		//PokerController p = new PokerController();
	}


}

