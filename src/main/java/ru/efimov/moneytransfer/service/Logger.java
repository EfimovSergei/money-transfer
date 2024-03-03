package ru.efimov.moneytransfer.service;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    private void writeMsg(String operationMsg) {
        try (FileWriter writer = new FileWriter("Logs.txt")) {
            writer.append(operationMsg);
            System.out.println(operationMsg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
