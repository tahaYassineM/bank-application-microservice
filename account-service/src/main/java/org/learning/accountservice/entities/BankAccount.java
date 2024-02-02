package org.learning.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.learning.accountservice.enums.AccountType;
import org.learning.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;
    private Long customerId;
}
