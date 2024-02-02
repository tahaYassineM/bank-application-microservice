package org.learning.accountservice.web;

import org.learning.accountservice.clients.CustomerClientRest;
import org.learning.accountservice.entities.BankAccount;
import org.learning.accountservice.model.Customer;
import org.learning.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerClientRest customerClientRest;

    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerClientRest customerClientRest) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerClientRest = customerClientRest;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        return this.bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id) {
        BankAccount bankAccount =  this.bankAccountRepository.findById(id).get();
        Customer customer = customerClientRest.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);

        return bankAccount;
    }
}
