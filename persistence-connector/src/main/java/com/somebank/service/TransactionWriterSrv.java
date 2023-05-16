package com.somebank.service;

import com.somebank.access.CacheTransactionSrvCacheSrv;
import com.somebank.access.DatabaseTransactionSrv;
import com.somebank.data.TransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionWriterSrv {
    //TODO create specific interfaces
    private final CacheTransactionSrvCacheSrv cacheTransactionSrvCacheSrv;
    private final DatabaseTransactionSrv databaseTransactionSrv;

    public TransactionDto writeTransaction(final TransactionDto transactionDto) {
        TransactionDto result;
        try {
            result = this.databaseTransactionSrv.write(transactionDto);
            this.cacheTransactionSrvCacheSrv.write(transactionDto);
        } catch (RuntimeException e) {
            //TODO create specific exception and capture in exception handler
            throw new RuntimeException();
        }
        return result;
    }
}
