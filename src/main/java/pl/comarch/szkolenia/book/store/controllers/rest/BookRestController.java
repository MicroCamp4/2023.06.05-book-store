package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.model.dto.ListResponse;
import pl.comarch.szkolenia.book.store.services.IBookService;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/book")
public class BookRestController {

    @Autowired
    IBookService bookService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity getBook(@RequestParam(required = false) String pattern) {
        if(pattern == null) {
            return ResponseEntity.status(200).body(
                    new ListResponse<>(this.bookService.getAllBooks()));
        }
        List<Book> books = this.bookService.getBooksByPattern(pattern);
        if(books.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(new ListResponse<>(books));
    }
}
