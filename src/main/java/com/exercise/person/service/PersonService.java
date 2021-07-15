package com.exercise.person.service;

import com.exercise.person.service.generator.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService{

    @Autowired
    private Generator generator;

    public Person getPersonInfo() {
        var name = generator.getRandomName();
         var age = generator.getAgeByName(name);
         var gender = generator.getGenderByName(name);
         var nationalities = generator.getNationalitiesByName(name);

        return new Person(name,age, gender, nationalities);
    }

    public Person getPersonInfo(String name) {
        var age = generator.getAgeByName(name);
        var gender = generator.getGenderByName(name);
        var nationalities = generator.getNationalitiesByName(name);

        return new Person(name,age, gender, nationalities);
    }
}
