package com.somebank.service;

import com.somebank.access.CacheTransactionSrvCacheSrv;
import com.somebank.access.DatabaseTransactionSrv;
import com.somebank.data.TransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionReaderSrv {
    //TODO create specific interfaces
    private final CacheTransactionSrvCacheSrv cacheTransactionSrvCacheSrv;
    private final DatabaseTransactionSrv persistenceTransactionSrv;

    public Optional<TransactionDto> getTransaction(String id) {
        Optional<TransactionDto> optTransaction = this.cacheTransactionSrvCacheSrv.read(id);
        if (optTransaction.isEmpty()) {
            optTransaction = this.persistenceTransactionSrv.read(id);
            optTransaction.ifPresent(this.cacheTransactionSrvCacheSrv::write);
        }
        return optTransaction;
    }
}
