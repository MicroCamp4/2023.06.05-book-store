package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.model.dto.ListResponse;
import pl.comarch.szkolenia.book.store.services.IUserService;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/user")
public class UserRestController {

    @Autowired
    IUserService userService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity getUser(@RequestParam(required = false) String login) {
        if(login == null) {
            return ResponseEntity.status(200).body(new ListResponse<>(this.userService.getAll()));
        }
        Optional<User> userBox = this.userService.getByLogin(login);
        if(userBox.isPresent()) {
            return ResponseEntity.status(200).body(userBox.get());
        }
        return ResponseEntity.status(404).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> userBox = this.userService.getById(id);
        if(userBox.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(userBox.get());
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        this.userService.insert(user);
        return ResponseEntity.status(201).body(user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable int id) {
        this.userService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
