package ru.geekbrains;

import lombok.Data;

import java.util.UUID;

@Data
public class Book {
    private UUID id;
    private String name;

    public Book(String name) {
        this.name = name;
        id = UUID.randomUUID();
    }
}
