package com.exercise.person.service;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private String gender;
    private List<Nationality> nationalities = new ArrayList<>();


    public Person(String name, int age, String gender, List<Nationality> nationalities) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationalities = nationalities;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<Nationality> getNationalities() {
        return nationalities;
    }

}
