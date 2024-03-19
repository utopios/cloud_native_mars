package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String mail;
    private String phone;

}
