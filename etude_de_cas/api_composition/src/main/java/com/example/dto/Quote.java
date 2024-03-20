package com.example.dto;


import lombok.Data;

@Data
public class Quote {

        private Long id;
        private String content;
        private Long authorId;
}
