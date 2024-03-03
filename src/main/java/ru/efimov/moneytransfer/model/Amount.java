package ru.efimov.moneytransfer.model;

import lombok.Data;

@Data

public class Amount {
    int value;
    String currency;
}
