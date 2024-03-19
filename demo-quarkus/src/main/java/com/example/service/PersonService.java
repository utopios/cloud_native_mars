package com.example.service;


import com.example.entity.Person;
import com.example.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    @Transactional
    public Person addPerson(String firstname, String lastname) {
        Person p = Person.builder().firstname(firstname).lastname(lastname).build();
        personRepository.persist(p);
        return p;
    }

    public List<Person> getPersons() {
        return personRepository.listAll();
    }
}
