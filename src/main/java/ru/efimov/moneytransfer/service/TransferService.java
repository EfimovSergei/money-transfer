package ru.efimov.moneytransfer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.efimov.moneytransfer.exception.InvalidDateCardException;
import ru.efimov.moneytransfer.model.Confirm;
import ru.efimov.moneytransfer.model.Transaction;
import ru.efimov.moneytransfer.repository.TransferRepository;

import java.time.LocalDate;
import java.util.Arrays;


@AllArgsConstructor
@Service
public class TransferService {
    private final int CARD_NUMBER_QUANTITY = 16;
    private final Logger logs = Logger.getLogger();
    TransferRepository repository;

    public int addTransaction(Transaction transaction) {
        if (!validTransaction(transaction)) {
            throw new RuntimeException();
        }
        int id = repository.addTransaction(transaction);
        return id;
    }

    private boolean validTransaction(Transaction transaction) {
        if (!validCardNumbers(transaction)) {
            throw new InvalidDateCardException("Неверный формат номера карты");

        }
        if (!validCardDate(transaction)) {
            throw new InvalidDateCardException("Карта устарела");
        }
        return true;
    }

    private boolean validCardDate(Transaction transaction) {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int[] numbers = Arrays.stream(transaction.getDateCardReplish().split("/"))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (numbers[1] >= year) {
            if ((0 < numbers[0]) && (numbers[0] <= 12)) {
                return numbers[0] > month;
            }
        }
        return false;
    }

    private boolean validCardNumbers(Transaction transaction) {
        long cardChargeQuantity = String.valueOf(transaction.getCardCharge())
                .chars()
                .filter(Character::isDigit)
                .count();
        long cardReplishQuantity = String.valueOf(transaction.getCardReplenish())
                .chars()
                .filter(Character::isDigit)
                .count();
        return cardChargeQuantity == CARD_NUMBER_QUANTITY && cardReplishQuantity == CARD_NUMBER_QUANTITY;
    }

    public Transaction getTransactionById(Confirm confirm) {
        Transaction transaction = repository.getTransactionByCode(confirm.getCode());
        return transaction;
    }
}
