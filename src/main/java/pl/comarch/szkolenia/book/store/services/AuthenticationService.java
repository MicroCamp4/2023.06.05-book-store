package pl.comarch.szkolenia.book.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.book.store.database.IUserRepository;
import pl.comarch.szkolenia.book.store.model.User;

import java.util.Optional;

//@Component
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void authenticate(String login, String password) {
        /*Optional<User> userBox = this.userRepository.getUserByLogin(login);
        if(userBox.isEmpty()) {
            return false;
        }
        return userBox.get().getPassword().equals(password);*/
    }

    @Override
    public void logout() {

    }
}
