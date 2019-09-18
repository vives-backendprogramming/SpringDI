package be.vives.ti.model;

import java.time.LocalDate;

public class Student {

    private Integer id;
    private String firstName;
    private String lastName;

    public Student(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
