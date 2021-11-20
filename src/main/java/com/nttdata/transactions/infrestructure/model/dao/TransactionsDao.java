package com.nttdata.transactions.infrestructure.model.dao;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("transaction")
@NoArgsConstructor
public class TransactionsDao {

    @Id
    private Long id;
    private Long idAccount;
    private Long idAccountTwo;
    private Integer amount;
    private String typeCredit;
    private LocalDate date;
}
