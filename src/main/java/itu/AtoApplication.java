package itu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtoApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(AtoApplication.class);
	
}
