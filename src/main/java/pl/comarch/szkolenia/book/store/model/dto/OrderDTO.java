package pl.comarch.szkolenia.book.store.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.model.User;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private int id;
    private LocalDateTime date;
    private String book;
    private String user;
}
