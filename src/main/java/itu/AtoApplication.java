package itu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("itu")

public class AtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtoApplication.class, args);
		System.out.println("MANDEHA ATOO!!!");
	}

	private static final Logger log = LoggerFactory.getLogger(AtoApplication.class);
}
