package tede.morgado.spring5framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tede.morgado.spring5framework.model.Author;
import tede.morgado.spring5framework.repository.IAuthorRepository;

@Controller
public class AuthorController
{

    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorController (final IAuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/author")
    public String getAuthors (final Model model)
    {
        final Iterable<Author> authorIterable = this.authorRepository.findAll();
        model.addAttribute("authors", authorIterable);
        return "authors";
    }

}
