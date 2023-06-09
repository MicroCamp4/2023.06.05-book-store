package pl.comarch.szkolenia.book.store.database;

import pl.comarch.szkolenia.book.store.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUserByLogin(String login);
    List<User> getAll();
    void insert(User user);
    void delete(int id);
}
