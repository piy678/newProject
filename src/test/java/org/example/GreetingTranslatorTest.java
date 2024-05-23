package org.example;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.util.Locale.*;
import static org.junit.jupiter.api.Assertions.*;

class GreetingTranslatorTest {
    @Test

void when_localGerman_then_GreetingHallo(){
    //Arrange
    GreetingTranslator greetingTranslator = new GreetingTranslator();
    Locale locale = Locale.GERMAN;
    // Act
String greeting = greetingTranslator.getGreeting(locale);
    // Assert
        assertEquals("Hallo", greeting);
}
@Test
    void when_localEnglish_then_GreetingHallo(){
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        assertEquals("Hello", greetingTranslator.getGreeting(Locale.ENGLISH));
}
@Test
    void when_localFrench_then_GreetingHallo(){
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        assertEquals("Bonjour", greetingTranslator.getGreeting(Locale.FRENCH));
}
@Test
    void when_localNotSupported_then_IllegalArgumentException(){
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        assertThrows(IllegalArgumentException.class, () -> greetingTranslator.getGreeting(Locale.ITALIAN));
}
}