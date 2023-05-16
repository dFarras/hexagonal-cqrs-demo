package com.somebank.controller.create;

import com.somebank.controller.search.TransactionSearchRs;
import com.somebank.data.TransactionDto;
import com.somebank.service.create.TransactionCreateSrv;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping("transaction")
public class CreateController {
    private final TransactionCreateSrv transactionCreateSrv;

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public TransactionSearchRs transactionStatus(
        @RequestBody TransactionCreateRq request
    ) {
        TransactionDto systemRequest = this.from(request);
        TransactionDto transaction = this.transactionCreateSrv.create(systemRequest);
        return this.from(transaction);
    }

    private TransactionDto from(
        TransactionCreateRq request
    ) {
        return new TransactionDto(
            request.reference(),
            request.channel(),
            new BigDecimal(request.amount()),
            new BigDecimal(request.fee()),
            request.transactionDate()
        );
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
