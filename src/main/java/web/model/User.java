package web.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name = "User")
public class User {@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    @NotEmpty(message = "The field cannot be empty")
    @Size(min = 2, max = 20, message = "Name to short (2) or long (30)")
    private String name;

    @NotEmpty(message = "The field cannot be empty")
    @Size(min = 2, max = 20, message = "Name to short (2) or long (30)")
    private String lastName;

    @Min(value = 0, message = "Age must be greater than 0" )
    private int age;

    public User() {
    }

    public User(int id, String firstName, String lastName, int age, String country) {
        this.id = id;
        this.name = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
