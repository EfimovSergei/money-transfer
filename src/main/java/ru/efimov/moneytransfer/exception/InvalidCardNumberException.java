package ru.efimov.moneytransfer.exception;


public class InvalidCardNumberException extends RuntimeException {
    public InvalidCardNumberException(String msg) {
        super(msg);
    }
}
