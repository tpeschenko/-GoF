package ru.geekbrains;

import lombok.Data;

import java.util.UUID;

@Data
public class BookDto {
    private UUID id;
    private String name;
}
