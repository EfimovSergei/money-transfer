package ru.efimov.moneytransfer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    private String cardReplenish;
    private String cardCharge;
    private String dateCardReplish;
    private String cvv;
    private Amount amount;

}
