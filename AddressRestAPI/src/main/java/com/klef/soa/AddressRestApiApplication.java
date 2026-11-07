package com.klef.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressRestApiApplication.class, args);
		System.out.println("Address Backend is Running...!!!");
	}

}
