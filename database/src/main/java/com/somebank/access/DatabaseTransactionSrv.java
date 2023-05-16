package com.somebank.access;

import com.somebank.connectors.ReaderConnector;
import com.somebank.connectors.WriterConnector;
import com.somebank.data.TransactionDto;
import com.somebank.entity.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DatabaseTransactionSrv implements ReaderConnector<TransactionDto, String>, WriterConnector<TransactionDto> {
    private final TransactionRepo transactionRepo;

    @Override
    public Optional<TransactionDto> read(
        String reference
    ) {
        return this.transactionRepo.getTransactionByReference(reference);
    }

    @Override
    public TransactionDto write(
        TransactionDto data
    ) {
        try {
            this.transactionRepo.save(
                new Transaction(
                    data.getReference(),
                    data.getChannel(),
                    data.getAmount().toPlainString(),
                    data.getFee().toPlainString(),
                    data.getTransactionDate()
                )
            );
            return data;
        } catch (Exception e) {
            //TODO create specific exception
            throw new RuntimeException();
        }
    }
}
