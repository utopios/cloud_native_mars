package com.example.service;


import com.example.dto.ContactDTO;
import com.example.entity.Contact;
import jakarta.enterprise.context.ApplicationScoped;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ApplicationScoped
public class ContactService {

    private static int count = 0;
    private List<Contact> contacts = new ArrayList<>();

    public Contact addContact(ContactDTO contactDTO) {
        //Logique métier et vérification pour ajouter un contact
        Contact contact = Contact.builder()
                .id(++count)
                .firstname(contactDTO.getFirstname())
                .lastname(contactDTO.getLastname())
                .mail(contactDTO.getMail())
                .phone(contactDTO.getPhone())
                .addedDate(LocalDateTime.now())
                .build();
        if(contacts.add(contact)) {
            return contact;
        }
        throw new RuntimeException("Error add contact");
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
