package pl.comarch.szkolenia.book.store.database;

import pl.comarch.szkolenia.book.store.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    List<Book> getAll();
    Optional<Book> getById(int id);
}
