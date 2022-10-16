package com.kata.rover;

import com.kata.rover.service.interfaces.RoverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class RoverApplication {

	private final RoverService roverService;

	@Autowired
	public RoverApplication(RoverService roverService) {
		this.roverService = roverService;
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			List<String> results = roverService.processFile("instructionsPassesLimits.txt");
			results.forEach(log::info);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(RoverApplication.class, args);
	}
}
