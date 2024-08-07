package ru.geekbrains;

import lombok.Data;

import java.util.UUID;

@Data
public class Reader {
    private UUID id;
    private String name;

    public Reader(String name) {
        this.name = name;
        id = UUID.randomUUID();
    }
}
