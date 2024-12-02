package com.example.springintro.model.entity;

public class Example {

    String firstName;
    String lastName;
    int count;


    public Example(String firstName, String lastName, int count) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = count;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCount() {
        return count;
    }
}
