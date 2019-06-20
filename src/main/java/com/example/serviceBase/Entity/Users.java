package com.example.serviceBase.Entity;


import javax.persistence.*;

@Entity
@Table(name="users")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String numberOne;
    private String numberTwo;
    private String numberThree;

    public Users(){}

    public Users(String name, String surname, String patronymic, String numberOne, String numberTwo, String numberThree) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.numberThree = numberThree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(String numberOne) {
        this.numberOne = numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(String numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getNumberThree() {
        return numberThree;
    }

    public void setNumberThree(String numberThree) {
        this.numberThree = numberThree;
    }
}
