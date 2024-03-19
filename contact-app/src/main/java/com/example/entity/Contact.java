package com.example.entity;


import com.example.dto.ContactDTO;
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
public class Contact {
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
