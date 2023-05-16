package com.somebank.access;

import com.somebank.data.TransactionDto;
import com.somebank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String> {
    @Transactional(readOnly = true)
    @Query(nativeQuery = true)
    public Optional<TransactionDto> getTransactionByReference(
        @Param("reference") String reference
    );
}
