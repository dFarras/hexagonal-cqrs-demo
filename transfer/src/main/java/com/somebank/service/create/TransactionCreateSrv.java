package com.somebank.service.create;

import com.somebank.data.TransactionDto;
import com.somebank.service.TransactionWriterSrv;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionCreateSrv {
    private final TransactionWriterSrv transactionWriterSrv;

    public TransactionDto create(TransactionDto request) {
        return this.transactionWriterSrv.writeTransaction(request);
    }
}
