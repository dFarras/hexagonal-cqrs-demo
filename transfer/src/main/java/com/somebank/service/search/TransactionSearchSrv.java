package com.somebank.service.search;

import com.somebank.data.TransactionDto;
import com.somebank.service.TransactionReaderSrv;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionSearchSrv {
    private final TransactionReaderSrv transactionReaderSrv;

    public TransactionDto search(String reference) {
        Optional<TransactionDto> transactionReadResult = this.transactionReaderSrv.getTransaction(reference);
        if (transactionReadResult.isEmpty()) {
            //TODO create specific exception
            throw new RuntimeException();
        }
        return transactionReadResult.get();
    }
}
