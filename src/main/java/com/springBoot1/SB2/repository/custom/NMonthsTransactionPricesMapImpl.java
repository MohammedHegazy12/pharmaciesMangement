package com.springBoot1.SB2.repository.custom;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NMonthsTransactionPricesMapImpl {
   private Double price;
    private Integer month;
    private Integer year;
}
