package org.ms.customerservice;

import org.ms.customerservice.dto.CustomerRequestDto;
import org.ms.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args -> {
			customerService.save(new CustomerRequestDto("C01", "Mohamed", "medfarhaoui7@gmail.com"));
			customerService.save(new CustomerRequestDto("C02", "Farhaoui", "mohamed.farhaoui@gmail.com"));

		};
	}

}
