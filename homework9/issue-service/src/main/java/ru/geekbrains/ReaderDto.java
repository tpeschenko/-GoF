package ru.geekbrains;

import lombok.Data;

import java.util.UUID;

@Data
public class ReaderDto {
    private UUID id;
    private String name;
}
