package by.babanin.example.greeter.formatter;

import by.babanin.example.greeter.model.Person;

@FunctionalInterface
public interface GreetGenerator {

    String generate(Person person);
}
