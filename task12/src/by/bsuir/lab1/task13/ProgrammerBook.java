package by.bsuir.lab1.task13;

import by.bsuir.lab1.task12.Book;

import java.util.Objects;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    @Override
    public boolean equals(Object obj) {
        ProgrammerBook other = (ProgrammerBook) obj;
        return super.equals(obj) && language == other.language && level == other.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, level, super.hashCode());
    }

    @Override
    public String toString() {
        return "Language: " + language + " Level: " + level + " " + super.toString();
    }
}
