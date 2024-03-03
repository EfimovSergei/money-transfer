package ru.efimov.moneytransfer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.efimov.moneytransfer.model.Confirm;
import ru.efimov.moneytransfer.model.Transaction;
import ru.efimov.moneytransfer.service.TransferService;

@AllArgsConstructor
@RestController
public class TransferController {
    private TransferService service;
    @PostMapping("/transfer")
    public int addTransaction(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }

    @PostMapping("/confirmOperation")
    public Transaction getConfirm(@RequestBody Confirm confirm) {
        return service.getTransactionById(confirm);
    }
}

