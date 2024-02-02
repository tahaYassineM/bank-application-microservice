package org.learning.customerservice;

import org.learning.customerservice.entities.Customer;
import org.learning.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {

			List<Customer> customers = List.of(
				Customer.builder()
					.firstName("Abdellah")
					.lastName("Cherrak")
					.email("test@gmail.com")
					.build(),
					Customer.builder()
							.firstName("Taha")
							.lastName("Yassine")
							.email("test1@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Dakouan")
							.email("test2@gmail.com")
							.build()
			);

			customerRepository.saveAll(customers);
		};
	}
}
