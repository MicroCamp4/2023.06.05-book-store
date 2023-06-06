package pl.comarch.szkolenia.book.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.comarch.szkolenia.book.store.database.IBookRepository;
import pl.comarch.szkolenia.book.store.services.IBookService;

@Controller
public class CommonController {

    @Autowired
    IBookService bookService;

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String main(Model model,
                       @RequestParam(required = false) String pattern) {
        if(pattern == null) {
            model.addAttribute("books",
                    this.bookService.getAllBooks());
        } else {
            model.addAttribute("books",
                    this.bookService.getBooksByPattern(pattern));
        }
        return "index";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }
}
