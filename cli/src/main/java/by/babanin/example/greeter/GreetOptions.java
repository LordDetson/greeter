package by.babanin.example.greeter;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import by.babanin.example.greeter.formatter.GreetGeneratorFactory.GreetGeneratorType;

public enum GreetOptions {
    GREET_TYPE(createGreetTypeOption()),
    FIRST_NAME(createFirstNameOption()),
    LAST_NAME(createLastNameOption()),
    NICKNAME(createNicknameOption());

    private static Options options;
    private final Option option;

    GreetOptions(Option option) {
        this.option = option;
    }

    public Option getOption() {
        return option;
    }

    public String getValue(CommandLine cmd) {
        return cmd.getOptionValue(option);
    }

    public static Options getOptions() {
        Options result = options;
        if(result != null) {
            return result;
        }
        synchronized(GreetOptions.class) {
            if(options == null) {
                options = new Options();
                Arrays.stream(GreetOptions.values())
                        .forEach(greetOption -> options.addOption(greetOption.getOption()));
            }
            return options;
        }
    }

    private static Option createGreetTypeOption() {
        return Option.builder("gt")
                .longOpt("greetType")
                .type(GreetGeneratorType.class)
                .required()
                .hasArg()
                .build();
    }

    private static Option createFirstNameOption() {
        return Option.builder("fn")
                .longOpt("firstName")
                .type(String.class)
                .required()
                .hasArg()
                .build();
    }

    private static Option createLastNameOption() {
        return Option.builder("ln")
                .longOpt("lastName")
                .type(String.class)
                .required()
                .hasArg()
                .build();
    }

    private static Option createNicknameOption() {
        return Option.builder("nn")
                .longOpt("nickname")
                .type(String.class)
                .hasArg()
                .build();
    }
}
