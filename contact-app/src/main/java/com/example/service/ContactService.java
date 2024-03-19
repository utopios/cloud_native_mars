package com.example.service;


import com.example.dto.ContactDTO;
import com.example.entity.Contact;
import com.example.repository.ContactRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ContactService {

//    private static int count = 0;
//    private List<Contact> contacts = new ArrayList<>();

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Contact addContact(ContactDTO contactDTO) {
        //Logique métier et vérification pour ajouter un contact
        Contact contact = Contact.builder()
                .firstname(contactDTO.getFirstname())
                .lastname(contactDTO.getLastname())
                .mail(contactDTO.getMail())
                .phone(contactDTO.getPhone())
                .addedDate(LocalDateTime.now())
                .build();
        /*if(contacts.add(contact)) {
            return contact;
        }
        throw new RuntimeException("Error add contact");*/
        contactRepository.persistAndFlush(contact);
        return contact;
    }

    public List<Contact> getContacts() {
        //return contacts;
        return contactRepository.listAll();
    }
    public Contact getContactById(int id) {
        return contactRepository.findById(id);
    }

}
