package ru.geekbrains;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("book")
public class BookController {
    private final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void generateDemoBooks() {
        books.add(new Book("Шантарам"));
        books.add(new Book("Сёгун"));
        books.add(new Book("Отверженные"));
        books.add(new Book("Искусство войны"));
        books.add(new Book("Огнём и мечом"));
    }

    @Timer
    @GetMapping
    public List<Book> getAll() {
        return books;
    }

    @GetMapping("random")
    public Book getById() {
        Random random = new Random();

        return books.get(random.nextInt(books.size()));
    }
}
