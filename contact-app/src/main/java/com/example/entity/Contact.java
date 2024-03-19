package com.example.entity;


import com.example.dto.ContactDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String mail;
    private String phone;
    private LocalDateTime addedDate;


    public ContactDTO toDto() {
        return ContactDTO.builder().id(id).firstname(firstname).lastname(lastname).mail(mail).phone(phone).build();
    }
}
