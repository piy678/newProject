package org.example;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        String greeting = greetingTranslator.getGreeting(Locale.ENGLISH);
        greeting += "Technikum";
        System.out.println(greeting);
    }
}