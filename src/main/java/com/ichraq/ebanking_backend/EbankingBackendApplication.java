package com.ichraq.ebanking_backend;

import com.ichraq.ebanking_backend.entities.*;
import com.ichraq.ebanking_backend.entities.AccountOperation;
import com.ichraq.ebanking_backend.entities.CurrentAccount;
import com.ichraq.ebanking_backend.entities.Customer;
import com.ichraq.ebanking_backend.entities.SavingAccount;
import com.ichraq.ebanking_backend.enums.AccountStatus;
import com.ichraq.ebanking_backend.enums.OperationType;
import com.ichraq.ebanking_backend.repositories.AccountOperationRepository;
import com.ichraq.ebanking_backend.repositories.BankAccountRepository;
import com.ichraq.ebanking_backend.repositories.CustomerRepository;
import com.ichraq.ebanking_backend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(EbankingBackendApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(BankService bankService) {
		return args -> {
			bankService.consulter();
		};
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							BankAccountRepository bankAccountRepository,
							AccountOperationRepository accountOperationRepository){
		return args -> {
			Stream.of("ichraq","sabrine","mohammed").forEach(name->{
				Customer customer=new Customer();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				CurrentAccount currentAccount=new CurrentAccount();
				currentAccount.setId(UUID.randomUUID().toString());
				currentAccount.setBalance(Math.random()*90000);
				currentAccount.setCreatedAt(new Date());
				currentAccount.setStatus(AccountStatus.CREATED);
				currentAccount.setCustomer(customer);
				currentAccount.setOverDraft(9000);
				bankAccountRepository.save(currentAccount);

				SavingAccount savingAccount=new SavingAccount();
				savingAccount.setId(UUID.randomUUID().toString());
				savingAccount.setBalance(Math.random()*90000);
				savingAccount.setCreatedAt(new Date());
				savingAccount.setStatus(AccountStatus.CREATED);
				savingAccount.setCustomer(customer);
				savingAccount.setInterestRate(5.5);
				bankAccountRepository.save(savingAccount);
			});

			bankAccountRepository.findAll().forEach(account->{
				for (int i=0; i<5; i++){
					AccountOperation accountOperation=new AccountOperation();
					accountOperation.setOperationDate(new Date());
					accountOperation.setAmount(Math.random()*12000);
					accountOperation.setType(Math.random()>0.5? OperationType.DEBIT:OperationType.CREDIT);
					accountOperation.setBankAccount(account);
					accountOperationRepository.save(accountOperation);
				}

			});
		};

	}



}
