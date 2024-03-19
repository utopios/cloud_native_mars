package com.example.repository;

import com.example.entity.Contact;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContactRepository implements PanacheRepositoryBase<Contact, Integer> {
}
