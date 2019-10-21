package be.vives.ti.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Student {

    private Integer id;
    @NotBlank(message = "Voornaam mag niet leeg zijn")
    @Size(min=2, max=20, message="Voornaam must have min length of 2, and max of 20")
    private String firstName;
    @Size(min=5, max=50, message="Familienaam must have min length of 5, and max of 50")
    @NotBlank(message = "Familienaam mag niet leeg zijn")
    private String lastName;
    @NotBlank(message = "Email mag niet leeg zijn")
    @Email(message="please enter a valid email", regexp=".+@.+\\..+")
    private String email;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
