package br.com.market.exceptions;

public class EmptyFieldException extends RuntimeException {

    // Field = campo;
    public EmptyFieldException(String message) {
        super(message);
    }
}
