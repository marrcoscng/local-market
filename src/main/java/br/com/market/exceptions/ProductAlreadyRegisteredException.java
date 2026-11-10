package br.com.market.exceptions;

public class ProductAlreadyRegisteredException extends RuntimeException {
    public ProductAlreadyRegisteredException(String message) {
        super(message);
    }
}
