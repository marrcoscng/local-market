package br.com.market.exceptions;

public class ProductNotRegisterException extends RuntimeException {
    public ProductNotRegisterException(String message) {
        super(message);
    }
}
