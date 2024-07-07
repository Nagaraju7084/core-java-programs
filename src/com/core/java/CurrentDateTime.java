package com.core.java;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CurrentDateTime {

    public static void main(String[] args) {
        System.out.println("Current Date and Time is: " + LocalDateTime.now());
        System.out.println("Current Date and Time is: " + LocalDate.now());
    }
}