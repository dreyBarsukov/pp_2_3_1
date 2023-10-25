package com.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    @Min(value = 1900, message = "год не должен быть меньше 1900")
    @NotNull(message = "введите год")
    private Integer year;

    @Column(name = "first_name")
    @NotEmpty(message = "укажите имя")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "укажите фамилию")
    private String lastName;

    @Column(name = "email")
    @Email(message = "введенные данные не соответствуют email")
    @NotEmpty(message = "укажите email")
    private String email;

    public User() {
    }

    public User(Integer year, String firstName, String lastName, String email) {
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
        return "User{" +
               "id=" + id +
               ", year=" + year +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}