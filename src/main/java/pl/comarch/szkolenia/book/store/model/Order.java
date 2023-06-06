package pl.comarch.szkolenia.book.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private LocalDateTime date;
    private Book book;
    private User user;
}
