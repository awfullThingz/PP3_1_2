package web.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "The field cannot be empty")
    @Column(name = "name")
    @Size(min = 2, max = 20, message = "Name to short (2) or long (30)")
    private String name;

    @NotEmpty(message = "The field cannot be empty")
    @Column(name = "lastname")
    @Size(min = 2, max = 20, message = "Name to short (2) or long (30)")
    private String lastName;
    @Column(name = "age")
    @Min(value = 0, message = "Age must be greater than 0")
    private int age;

    public User() {
    }

    public User(int id, String firstName, String lastName, int age) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", lastname=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name == user.name && age == user.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
