package com.example.repository;

import com.example.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

}
