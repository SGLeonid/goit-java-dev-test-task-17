package org.forestwizard.goitjavadevtesttask17.exception;

public class DatabaseServiceException extends Exception {
    public DatabaseServiceException(String msg) {
        super(msg);
    }

    public DatabaseServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
