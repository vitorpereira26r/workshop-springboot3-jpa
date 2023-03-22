package com.vitorpereira.courseProject.services.excepitions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg) {
        super(msg);

    }
}
