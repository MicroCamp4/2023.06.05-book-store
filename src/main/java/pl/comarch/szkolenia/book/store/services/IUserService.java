package pl.comarch.szkolenia.book.store.services;

import pl.comarch.szkolenia.book.store.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getByLogin(String login);
    Optional<User> getById(int id);
    void insert(User user);
    void delete(int id);
}
