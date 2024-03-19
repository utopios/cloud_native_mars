package com.example;


import com.example.entity.Person;
import com.example.service.PersonService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;
@Path("/api/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    public List<Person> get() {
        return Arrays.asList(Person.builder().firstname("toto").lastname("tata").build());
    }

    @POST
    public Person post(Person person) {
        return person;
    }


    @GET
    @Path("{id}")
    public Person get(@PathParam("id") int id) {
        return  Person.builder().build();
    }

}
