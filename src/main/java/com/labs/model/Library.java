package com.labs.model;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {
    @XmlElements({
            @XmlElement(name = "vocabulary", type = Vocabulary.class),
            @XmlElement(name = "textBook", type = TextBook.class)
    })
    private List<Book> books;

    public Library () {
        books = new LinkedList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }


    @Override
    public int hashCode() {
        return Objects.hash(books);
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
