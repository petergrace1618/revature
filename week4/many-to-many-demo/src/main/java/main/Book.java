package main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    String title;
    @ManyToMany(mappedBy = "books")
    Set<Reader> readers = new HashSet<>();

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Book addReader(Reader reader) {
        readers.add(reader);
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", readers=" + readers +
                '}';
    }
}
