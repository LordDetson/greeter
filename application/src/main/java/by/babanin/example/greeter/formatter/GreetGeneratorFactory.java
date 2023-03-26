package by.babanin.example.greeter.formatter;

import java.util.Arrays;

public class GreetGeneratorFactory {

    public enum GreetGeneratorType {
        FORMAL("formal"),
        INFORMAL("informal");

        private final String name;

        GreetGeneratorType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static GreetGeneratorType parse(String name) {
            final String finalName = name.trim();
            return Arrays.stream(GreetGeneratorType.values())
                    .filter(type -> type.name.equalsIgnoreCase(finalName))
                    .findFirst()
                    .orElseThrow();
        }
    }

    public static GreetGenerator factor(GreetGeneratorType type) {
        return switch(type) {
            case FORMAL -> new FormalGreetGenerator();
            case INFORMAL -> new InformalGreetGenerator();
        };
    }
}
