package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.comarch.szkolenia.book.store.model.User;

@RestController
@RequestMapping(path = "/api")
public class TestRestController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public void test() {
        System.out.println("dziala nasz pierwszy endpiont restowy !!!");
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public User test2() {
        User user = new User();
        user.setId(10);
        user.setLogin("janusz");
        user.setPassword("janusz123");

        return user;
    }

    @RequestMapping(path = "/test3", method = RequestMethod.POST)
    public User test3(@RequestBody User user) {
        System.out.println(user);
        user.setId(100);
        return user;
    }

    @RequestMapping(path = "/test4", method = RequestMethod.GET)
    public void test4(@RequestHeader("header1") String h1,
                      @RequestHeader String header2) {
        System.out.println(h1);
        System.out.println(header2);
    }

    @RequestMapping(path = "/test5/{age}", method = RequestMethod.POST)
    public User test5(@RequestParam String name,
                      @RequestParam String surname,
                      @PathVariable int age,
                      @RequestBody User user,
                      @RequestHeader String h1,
                      @RequestHeader String h2) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        System.out.println(user);
        System.out.println(h1);
        System.out.println(h2);

        return new User(25, "wiesiek", "malinowski");
    }

    @RequestMapping(path = "/test6", method = RequestMethod.GET)
    public ResponseEntity<User> test6() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("naglowek1", "jakas wartos")
                .header("naglowek2", "jakas inna wartosc")
                .body(new User(10, "Karol", "Jakis"));
    }
}
