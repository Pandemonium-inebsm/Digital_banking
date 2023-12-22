package com.ichraq.ebanking_backend.services;

import com.ichraq.ebanking_backend.entities.BankAccount;
import com.ichraq.ebanking_backend.entities.Customer;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customerDTO);
    BankAccount saveBankAccount(double initialBalance, String type, Long customerId);
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId);

    void debit(String accountId, double amount, String description);
    void credit(String accountId, double amount, String description);
    void transfer(String accountIdSource, String accountIdDestination, double amount);


}
