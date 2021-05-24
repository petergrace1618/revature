package main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reader {
    @Id
    String name;
    @ManyToMany
    @JoinTable(
            name = "reader_book",
            joinColumns = {@JoinColumn(name = "reader_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id")}
    )
    Set<Book> books = new HashSet<>();

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Reader addBook(Book book) {
        books.add(book);
        return this;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
