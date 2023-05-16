package com.somebank.controller.search;

import com.somebank.data.TransactionDto;
import com.somebank.service.search.TransactionSearchSrv;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("transaction")
public class SearchController {
    private final TransactionSearchSrv transactionSearchSrv;

    @GetMapping(
        value = "{reference}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public TransactionSearchRs transactionStatus(
        @PathVariable("reference") String reference
    ) {
        TransactionDto transaction = this.transactionSearchSrv.search(reference);
        return this.from(transaction);
    }

    private TransactionSearchRs from(
        TransactionDto response
    ) {
        return new TransactionSearchRs(
            response.getReference(),
            response.getChannel(),
            response.getAmount().toPlainString(),
            response.getFee().toPlainString(),
            response.getTransactionDate()
        );
    }
}
