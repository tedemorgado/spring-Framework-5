package tede.morgado.spring5framework.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import tede.morgado.spring5framework.model.Author;
import tede.morgado.spring5framework.model.Book;
import tede.morgado.spring5framework.repository.IAuthorRepository;
import tede.morgado.spring5framework.repository.IBookRepository;

@Component
public class DataMapper
        implements ApplicationListener<ContextRefreshedEvent>
{

    private final IAuthorRepository authorRepository;
    private final IBookRepository   bookRepository;

    @Autowired
    public DataMapper (final IAuthorRepository authorRepository, final IBookRepository bookRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent (final ContextRefreshedEvent contextRefreshedEvent)
    {
        this.initData();
    }

    private void initData ()
    {
        final Author eric = new Author("Eric", "Evans");
        final Book   ddd  = new Book("Domain Deriven Design", "1234", "Harper Collins");
        eric
                .getBooks()
                .add(ddd);
        ddd
                .getAuthors()
                .add(eric);
        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);

        final Author rod   = new Author("Rod", "Johnson");
        final Book   noEjb = new Book("J2EE Development without EJB", "5678", "Worx");
        rod
                .getBooks()
                .add(noEjb);
        noEjb
                .getAuthors()
                .add(rod);
        this.authorRepository.save(rod);
        this.bookRepository.save(noEjb);

    }


}