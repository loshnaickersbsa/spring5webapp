package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRespository bookRespository;

    public BookController(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }


    @RequestMapping("/books" ) //the model below is returned to the view layer
    public String getBooks(Model model){

        model.addAttribute("books", bookRespository.findAll());
        return "books/list";
    }

}
