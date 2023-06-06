package pl.comarch.szkolenia.book.store.services;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.comarch.szkolenia.book.store.database.IUserRepository;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.session.SessionData;

import java.util.Optional;

@Service
public class HashAuthenticationService implements IAuthenticationService {

    @Autowired
    IUserRepository userRepository;

    @Resource
    SessionData sessionData;
    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userRepository.getUserByLogin(login);
        this.sessionData.setLogged(userBox.isPresent() &&
                userBox.get().getPassword().equals(DigestUtils.md5Hex(password)));
    }

    @Override
    public void logout() {
        this.sessionData.setLogged(false);
    }
}
