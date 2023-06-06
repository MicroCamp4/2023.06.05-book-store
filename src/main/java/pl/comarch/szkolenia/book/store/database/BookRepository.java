package pl.comarch.szkolenia.book.store.database;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.comarch.szkolenia.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository implements IBookRepository {
    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(new Book(1, "Title 1", "Author 1", 50.00, 10, "123-123-123-12"));
        this.books.add(new Book(2, "Title 2", "Author 2", 53.00, 10, "234-234-234-23"));
        this.books.add(new Book(3, "Title 3", "Author 3", 55.00, 10, "345-345-345-34"));
        this.books.add(new Book(4, "Title 4", "Author 4", 12.00, 10, "456-456-456-45"));
    }

    @Override
    public List<Book> getAll() {
        return this.books;
    }

    @Override
    public Optional<Book> getById(int id) {
        return this.books.stream().filter(book -> book.getId() == id).findFirst();
    }
}
