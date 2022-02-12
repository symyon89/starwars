package com.starwars.exceptions;

public class PageNotFoundException extends Exception {
    public PageNotFoundException(String message) {
        super(message);
    }
}
