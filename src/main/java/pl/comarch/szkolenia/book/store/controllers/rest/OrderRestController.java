package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.comarch.szkolenia.book.store.model.Order;
import pl.comarch.szkolenia.book.store.model.dto.OrderDTO;
import pl.comarch.szkolenia.book.store.services.IBookService;
import pl.comarch.szkolenia.book.store.services.IUserService;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/v1/api/order")
public class OrderRestController {

    @Autowired
    IBookService bookService;

    @Autowired
    IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public OrderDTO getOrder() {
        Order order = new Order();
        order.setId(10);
        order.setDate(LocalDateTime.now());
        order.setUser(this.userService.getById(1).get());
        order.setBook(this.bookService.getBooksByPattern("4").get(0));

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDate(order.getDate());
        orderDTO.setUser("http://localhost:8080/v1/api/user/" + order.getUser().getId());
        orderDTO.setBook("http://localhost:8080/v1/api/book/" + order.getBook().getId());

        return orderDTO;
    }
}
