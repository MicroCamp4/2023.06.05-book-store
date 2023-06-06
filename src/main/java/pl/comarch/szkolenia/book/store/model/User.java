package pl.comarch.szkolenia.book.store.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String login;
    private String password;
}
