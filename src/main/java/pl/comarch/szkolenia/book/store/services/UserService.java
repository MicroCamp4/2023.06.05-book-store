package pl.comarch.szkolenia.book.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.comarch.szkolenia.book.store.database.IUserRepository;
import pl.comarch.szkolenia.book.store.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return this.userRepository.getUserByLogin(login);
    }

    @Override
    public Optional<User> getById(int id) {
        return this.userRepository.getAll().stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    @Override
    public void insert(User user) {
        this.userRepository.insert(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.delete(id);
    }
}
