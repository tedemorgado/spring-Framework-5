package tede.morgado.spring5framework.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long        id;
    private String      title;
    private String      isbn;

    @OneToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public Book (final String title, final String isbn, final Publisher publisher, final Set<Author> authors)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Book (final String title, final String isbn, final Publisher publisher)
    {
        this(title, isbn, publisher, new HashSet<>());
    }

    public Book ()
    {
        this(null, null, null);
    }

    public Long getId ()
    {
        return this.id;
    }

    public void setId (final Long id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return this.title;
    }

    public void setTitle (final String title)
    {
        this.title = title;
    }

    public String getIsbn ()
    {
        return this.isbn;
    }

    public void setIsbn (final String isbn)
    {
        this.isbn = isbn;
    }

    public Publisher getPublisher ()
    {
        return this.publisher;
    }

    public void setPublisher (final Publisher publisher)
    {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors ()
    {
        return this.authors;
    }

    public void setAuthors (final Set<Author> authors)
    {
        this.authors = authors;
    }

}
