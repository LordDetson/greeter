package by.babanin.example.greeter.formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.babanin.example.greeter.model.Person;

public class InformalGreetGenerator implements GreetGenerator {

    private static final Logger log = LoggerFactory.getLogger(InformalGreetGenerator.class);

    public static final String INFORMAL_GREET = "Sup!";
    public static final String INFORMAL_GREET_FORMAT = "Sup, %s!";

    @Override
    public String generate(Person person) {
        String nickname = person.getNickname();
        String greet;
        if(nickname != null) {
            greet = String.format(INFORMAL_GREET_FORMAT, nickname);
        }
        else {
            greet = INFORMAL_GREET;
        }
        log.info("Generated greet: {}", greet);
        return greet;
    }
}
