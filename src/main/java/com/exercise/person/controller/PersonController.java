package com.exercise.person.controller;

import com.exercise.person.service.Person;
import com.exercise.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public Person getPerson(){
        return personService.getPersonInfo();
    }

    @GetMapping("/persons/{name}")
    public Person getPerson(@PathVariable("name") String name){
        return personService.getPersonInfo(name);
    }

}
