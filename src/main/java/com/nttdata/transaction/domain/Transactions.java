package com.nttdata.transaction.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Transactions {

    private Long id;
    private Long idAccount;                 // Codigo de cuenta
    private Integer amount;                 // Monto de la trasferencia
    private Integer commissionTrans;        // Comision por transferencia
    private LocalDate date;                 // Fecha de trasferencia


}
