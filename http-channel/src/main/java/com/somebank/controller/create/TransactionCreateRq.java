package com.somebank.controller.create;

import com.somebank.data.Channel;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record TransactionCreateRq(
    String reference,
    Channel channel,
    String amount,
    String fee,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDate transactionDate
) {
}
