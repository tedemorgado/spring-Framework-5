package tede.morgado.spring5framework.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import tede.morgado.spring5framework.model.Author;
import tede.morgado.spring5framework.model.Book;
import tede.morgado.spring5framework.model.Publisher;
import tede.morgado.spring5framework.repository.IAuthorRepository;
import tede.morgado.spring5framework.repository.IBookRepository;
import tede.morgado.spring5framework.repository.IPublisherRepository;

@Component
public class DataMapper
        implements ApplicationListener<ContextRefreshedEvent>
{

    private final IAuthorRepository    authorRepository;
    private final IBookRepository      bookRepository;
    private final IPublisherRepository publisherRepository;

    @Autowired
    public DataMapper (final IAuthorRepository authorRepository, final IBookRepository bookRepository,
            final IPublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent (final ContextRefreshedEvent contextRefreshedEvent)
    {
        this.initData();
    }

    private void initData ()
    {
        final Publisher publisher = new Publisher("Publisher Abc", "No Address");
        this.publisherRepository.save(publisher);

        final Author eric = new Author("Eric", "Evans");
        final Book   ddd  = new Book("Domain Deriven Design", "1234", publisher);
        eric
                .getBooks()
                .add(ddd);
        ddd
                .getAuthors()
                .add(eric);
        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);

        final Author rod   = new Author("Rod", "Johnson");
        final Book   noEjb = new Book("J2EE Development without EJB", "5678", publisher);
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