package ru.geekbrains;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("reader")
public class ReaderController {
    private final List<Reader> readers = new ArrayList<>();

    @PostConstruct
    public void generateDemoReaders() {
        readers.add(new Reader("Константин"));
        readers.add(new Reader("Андрей"));
        readers.add(new Reader("Василиий"));
        readers.add(new Reader("Ирина"));
        readers.add(new Reader("Марина"));
    }

    @Timer
    @GetMapping
    public List<Reader> getAll() {
        return readers;
    }

    @GetMapping("random")
    public Reader getRandomReader() {
        Random random = new Random();
        return readers.get(random.nextInt(readers.size()));
    }
}
