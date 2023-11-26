package com.gabriella.itschool.models.entities;

import lombok.Data;

@Data
public class Book {

    private long id;
    private String title;
    private String author;
    private Double price;
}
