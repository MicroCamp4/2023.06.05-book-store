package pl.comarch.szkolenia.book.store.services;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.comarch.szkolenia.book.store.database.IBookRepository;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.session.SessionData;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Resource
    SessionData sessionData;

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.getAll();
        /*if(this.sessionData.isLogged()) {
            return this.bookRepository.getAll();
        }
        return new ArrayList<>();*/
    }

    @Override
    public List<Book> getBooksByPattern(String pattern) {
        return this.bookRepository.getAll().stream()
                .filter(book -> book.getTitle().toLowerCase()
                        .contains(pattern.toLowerCase()) ||
                        book.getAuthor().toLowerCase()
                                .contains(pattern.toLowerCase()))
                .toList();
        /*if(this.sessionData.isLogged()) {
            return this.bookRepository.getAll().stream()
                    .filter(book -> book.getTitle().toLowerCase()
                            .contains(pattern.toLowerCase()) ||
                            book.getAuthor().toLowerCase()
                                    .contains(pattern.toLowerCase()))
                    .toList();
        }
        return new ArrayList<>();*/
    }
}
