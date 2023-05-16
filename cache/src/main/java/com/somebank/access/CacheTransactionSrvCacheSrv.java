package com.somebank.access;

import com.somebank.connectors.ReaderConnector;
import com.somebank.connectors.WriterConnector;
import com.somebank.data.TransactionDto;
import com.somebank.storage.Cache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * This layer looks silly at a first glance, but this is due to the fact that this implementation is not real.
 *
 * In a real world this service would have to handle any kind of error from redis and map it to a response understandable for its client.
 * */
@Service
@AllArgsConstructor
public class CacheTransactionSrvCacheSrv implements ReaderConnector<TransactionDto, String>, WriterConnector<TransactionDto> {
    private final Cache cache;

    @Override
    public Optional<TransactionDto> read(
        String id
    ) {
        TransactionDto result = this.cache.get(id);
        return result != null ? Optional.of(result) : Optional.empty();
    }

    @Override
    public TransactionDto write(
        TransactionDto data
    ) {
        return this.cache.add(data);
    }
}
