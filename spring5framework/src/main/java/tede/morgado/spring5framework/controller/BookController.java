package tede.morgado.spring5framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tede.morgado.spring5framework.model.Book;
import tede.morgado.spring5framework.repository.IBookRepository;

@Controller
public class BookController
{

    private final IBookRepository bookRepository;

    @Autowired
    public BookController (final IBookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/book")
    public String getBooks (final Model model)
    {
        final Iterable<Book> bookList = this.bookRepository.findAll();
        model.addAttribute("books", bookList);
        return "books";
    }

}
