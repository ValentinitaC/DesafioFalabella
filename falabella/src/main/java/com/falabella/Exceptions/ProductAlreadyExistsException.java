package com.falabella.Exceptions;

public class ProductAlreadyExistsException extends RuntimeException {

    private String product;

    public ProductAlreadyExistsException(String message, String product) {
        super(message);
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

}
