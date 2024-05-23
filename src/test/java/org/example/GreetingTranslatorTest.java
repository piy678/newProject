package org.example;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTranslatorTest {
    @Test

void when_localGerman_then_GreetingHallo(){
    //Arrange
    GreetingTranslator greetingTranslator = new GreetingTranslator();
    Locale locale = new Locale("en");
    // Act

    // Assert
}
}