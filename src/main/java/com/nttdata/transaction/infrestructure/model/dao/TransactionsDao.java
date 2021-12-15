package com.nttdata.transaction.infrestructure.model.dao;


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
    private Long idAccount;                 // Codigo de cuenta
    private Integer amount;                 // Monto de la trasferencia
    private Integer commissionTrans;        // Comision por transferencia
    private LocalDate date;                 // Fecha de trasferencia

}
