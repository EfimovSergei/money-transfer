package ru.efimov.moneytransfer.repository;

import org.springframework.stereotype.Repository;
import ru.efimov.moneytransfer.model.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TransferRepository {
    AtomicInteger idCounter = new AtomicInteger();
   private final Map<Integer,Transaction> transactions = new HashMap<>();
    public int addTransaction(Transaction transaction) {
        int id = idCounter.getAndIncrement();
        transactions.put(id,transaction);
        return id;
    }

    public Transaction getTransactionByCode(String code) {
        int codeInt= Integer.parseInt(code);
        return transactions.get(codeInt);
    }
}
