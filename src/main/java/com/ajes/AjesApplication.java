package com.ajes;

import com.ajes.utility.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AjesApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AjesApplication.class, args);
	}

}
