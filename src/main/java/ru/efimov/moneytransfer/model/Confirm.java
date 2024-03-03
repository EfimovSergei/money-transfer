package ru.efimov.moneytransfer.model;

import lombok.Data;


@Data
public class Confirm {

    private String code;

    private int operationId;

}

