package by.babanin.example.greeter;

import static by.babanin.example.greeter.GreetOptions.*;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import by.babanin.example.greeter.formatter.GreetGeneratorFactory;
import by.babanin.example.greeter.formatter.GreetGeneratorFactory.GreetGeneratorType;
import by.babanin.example.greeter.model.Person;

public class Launcher {

    public static void main(String[] args) throws ParseException {
        CommandLine cmd = new DefaultParser().parse(getOptions(), args);

        GreetGeneratorType greetGeneratorType = GreetGeneratorType.parse(GREET_TYPE.getValue(cmd));

        String firstName = FIRST_NAME.getValue(cmd);
        String lastName = LAST_NAME.getValue(cmd);
        String nickname = NICKNAME.getValue(cmd);
        Person person = new Person(firstName, lastName);
        person.setNickname(nickname);

        String greetMessage = GreetGeneratorFactory.factor(greetGeneratorType).generate(person);
        System.out.println(greetMessage);
    }
}