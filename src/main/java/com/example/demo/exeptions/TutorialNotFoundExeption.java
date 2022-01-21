package com.example.demo.exeptions;

public class TutorialNotFoundExeption extends RuntimeException {
    public TutorialNotFoundExeption(String message) {
        super(message);
    }
}
