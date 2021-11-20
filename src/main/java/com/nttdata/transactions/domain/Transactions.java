package com.nttdata.transactions.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Transactions {

    private Long id;
    private Long idAccount;
    private Long idAccountTwo;
    private Integer amount;
    private String typeCredit;
    private LocalDate date;


}
