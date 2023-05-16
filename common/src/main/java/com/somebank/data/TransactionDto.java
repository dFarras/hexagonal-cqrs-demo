package com.somebank.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TransactionDto {
    private String reference;
    private Channel channel;
    private BigDecimal amount;
    private BigDecimal fee;
    private LocalDate transactionDate;
}
