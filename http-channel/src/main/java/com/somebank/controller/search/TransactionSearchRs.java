package com.somebank.controller.search;

import com.somebank.data.Channel;

import java.time.LocalDate;

public record TransactionSearchRs(
    String reference,
    Channel channel,
    String amount,
    String fee,
    LocalDate transactionDate
) {
}
