package org.learning.customerservice.web;

import lombok.AllArgsConstructor;
import org.learning.customerservice.entities.Customer;
import org.learning.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

   private CustomerRepository customerRepository;

   CustomerRestController(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
   }

    @GetMapping("/customers")
   public List<Customer> allCustomers() {
       return this.customerRepository.findAll();
   }

   @GetMapping("/customers/{id}")
   public Customer getCustomerById(@PathVariable Long id) {
       return this.customerRepository.findById(id).get();
   }
}
