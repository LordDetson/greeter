package by.babanin.example.greeter.formatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.babanin.example.greeter.model.Person;

class GreetFormattersTest {

    @Test
    void formalGreetTest() {
        // Given
        Person person = new Person("Dmitry", "Babanin");
        GreetGenerator formatter = new FormalGreetGenerator();
        // When
        String greet = formatter.generate(person);
        // Then
        Assertions.assertNotNull(greet);
        Assertions.assertEquals("Hello, Dmitry Babanin.", greet);
    }

    @Test
    void informalGreetWithNicknameTest() {
        // Given
        Person person = new Person("Dmitry", "Babanin");
        person.setNickname("Det");
        GreetGenerator formatter = new InformalGreetGenerator();
        // When
        String greet = formatter.generate(person);
        // Then
        Assertions.assertNotNull(greet);
        Assertions.assertEquals("Sup, Det!", greet);
    }

    @Test
    void informalGreetWithoutNicknameTest() {
        // Given
        Person person = new Person("Dmitry", "Babanin");
        GreetGenerator formatter = new InformalGreetGenerator();
        // When
        String greet = formatter.generate(person);
        // Then
        Assertions.assertNotNull(greet);
        Assertions.assertEquals("Sup!", greet);
    }
}