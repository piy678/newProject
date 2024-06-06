package org.example;

import java.util.Locale;

public class GreetingTranslator {
    public String getGreeting(Locale locale){
        if (locale == Locale.GERMAN){
            return "Hallo";
        }
        if (locale == Locale.ENGLISH){
            return "Hello";
        }
        if (locale == Locale.FRENCH){
            return "Bonjour";
        }
        throw new IllegalArgumentException("Unsupported Language " + locale);
    }
}