package br.com.market.exceptions;

public class RegisteredAlreadyProductException extends RuntimeException {
    public RegisteredAlreadyProductException(String message) {
        super(message);
    }
}
