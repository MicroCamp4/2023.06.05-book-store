package pl.comarch.szkolenia.book.store.database;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.comarch.szkolenia.book.store.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();
    private int newId = 3;

    public UserRepository() {
        this.users.add(new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3"));
        this.users.add(new User(2, "janusz", "087d9c5e13bdd64a82bef8e013625c32"));
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return this.users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }

    @Override
    public void insert(User user) {
        user.setId(this.newId++);
        this.users.add(user);
    }

    @Override
    public void delete(int id) {
        Iterator<User> iterator = this.users.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
