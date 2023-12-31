package com.ichraq.ebanking_backend.repositories;

import com.ichraq.ebanking_backend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {

}
