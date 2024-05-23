package org.example;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Pinar!");
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        String greeting = greetingTranslator.getGreeting(Locale.ENGLISH);

    }
}