package com.somebank.storage;

import com.somebank.data.TransactionDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {
    private final Map<String, TransactionDto> cache = new HashMap<>();

    public TransactionDto get(String id) {
        return this.cache.get(id);
    }

    public TransactionDto add(TransactionDto transaction) {
        return this.cache.put(transaction.getReference(), transaction);
    }
}
