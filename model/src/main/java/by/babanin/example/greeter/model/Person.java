package by.babanin.example.greeter.model;

import lombok.Data;

@Data
public class Person {

    public static final String FULL_NAME_FORMAT = "%s %s";

    private final String firstName;
    private final String lastName;
    private String nickname;

    public String getFullName() {
        return String.format(FULL_NAME_FORMAT, getFirstName(), getLastName());
    }
}
