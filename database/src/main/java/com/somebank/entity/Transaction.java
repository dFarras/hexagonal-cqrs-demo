package com.somebank.entity;

import com.somebank.data.Channel;
import com.somebank.data.TransactionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name = "Transaction.getTransactionByReference",
    query = "SELECT " +
        "trn.reference as reference " +
        "trn.channel as channel " +
        "trn.amount as amount " +
        "trn.fee as fee " +
        "trn.transactionDate as transactionDate " +
        "FROM transaction trn " +
        "WHERE trn.reference = :reference",
    resultSetMapping = "Mapping.TransactionDTO"
)
@SqlResultSetMapping(name = "Mapping.TransactionDTO",
    classes = @ConstructorResult(targetClass = TransactionDto.class,
        columns =
            {
                @ColumnResult(name = "reference"),
                @ColumnResult(name = "channel"),
                @ColumnResult(name = "amount"),
                @ColumnResult(name = "fee"),
                @ColumnResult(name = "transactionDate")
            }
    )
)
public class Transaction {
    @Id
    private String reference;
    @Enumerated(EnumType.STRING)
    private Channel channel;
    private String amount;
    private String fee;
    private LocalDate transactionDate;
}
