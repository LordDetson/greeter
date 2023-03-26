package by.babanin.example.greeter.formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.babanin.example.greeter.model.Person;

public class FormalGreetGenerator implements GreetGenerator {

    private static final Logger log = LoggerFactory.getLogger(FormalGreetGenerator.class);

    public static final String FORMAL_GREET_FORMAT = "Hello, %s.";

    @Override
    public String generate(Person person) {
        String greet = String.format(FORMAL_GREET_FORMAT, person.getFullName());
        log.info("Generated greet: {}", greet);
        return greet;
    }
}
