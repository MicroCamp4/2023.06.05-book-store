package pl.comarch.szkolenia.book.store.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private String isbn;
}
