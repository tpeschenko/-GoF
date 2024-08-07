package ru.geekbrains;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IssueController {
    private List<Issue> issues;
    private final BookProvider bookProvider;
    private final ReaderProvider readerProvider;

    @PostConstruct
    public void generateDemoIssues() {
        issues = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            issues.add(new Issue(bookProvider.getRandomBookDto(), readerProvider.getRandomReaderDto()));
        }
    }

    @GetMapping("refresh")
    public List<Issue> refresh() {
        generateDemoIssues();
        return issues;
    }

    @Timer
    @GetMapping("issue")
    public List<Issue> getAll() {
        return issues;
    }
}
