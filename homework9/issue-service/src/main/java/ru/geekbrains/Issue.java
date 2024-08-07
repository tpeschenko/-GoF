package ru.geekbrains;

import lombok.Data;

import java.util.UUID;

@Data
public class Issue {
    private UUID id;
    private BookDto book;
    private ReaderDto reader;

    public Issue(BookDto book, ReaderDto reader) {
        id = UUID.randomUUID();
        this.book = book;
        this.reader = reader;
    }
}
