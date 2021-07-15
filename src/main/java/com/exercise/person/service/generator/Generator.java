package com.exercise.person.service.generator;


import org.springframework.stereotype.Repository;
import com.exercise.person.service.Nationality;
import com.exercise.person.service.bean.Age;
import com.exercise.person.service.bean.Countries;
import com.exercise.person.service.bean.Country;
import com.exercise.person.service.bean.Gender;
import com.github.javafaker.Faker;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Generator {

    RestTemplate restTemplate = new RestTemplate();

    public String getRandomName() {
        var faker = new Faker();
        return faker.name().firstName();
    }

    public int getAgeByName(String name) {
        var uriAge = "https://api.agify.io/?name=" + name;
        var resultForAge = restTemplate.getForObject(uriAge, Age.class);
        assert resultForAge != null;
        return resultForAge.getAge();
    }

    public String getGenderByName(String name) {
        var uriGender = "https://api.genderize.io?name=" + name;
        var resultForGender = restTemplate.getForObject(uriGender, Gender.class);
        assert resultForGender != null;
        return resultForGender.getGender();
    }

    public List<Nationality> getNationalitiesByName(String name) {
        var uriNationality = "https://api.nationalize.io/?name=" + name;
        var resultForNationality = restTemplate.getForObject(uriNationality, Countries.class);
        assert resultForNationality != null;
        var countries = resultForNationality.getCountry().stream().map(Country::getCountry_id).collect(Collectors.toList());
        var nationalities = new ArrayList<Nationality>();
        for (String country : countries) {
            nationalities.add(new Nationality(country));
        }
        return nationalities;
    }
}
