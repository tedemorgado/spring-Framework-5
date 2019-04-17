package tede.morgado.spring5framework.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long      id;
    private String    firstName;
    private String    lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author ()
    {
        this(null, null);
    }

    public Author (final String firstName, final String lastName)
    {
        this(firstName, lastName, new HashSet<>());
    }

    public Author (final String firstName, final String lastName, final Set<Book> books)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId ()
    {
        return this.id;
    }

    public void setId (final Long id)
    {
        this.id = id;
    }

    public String getFirstName ()
    {
        return this.firstName;
    }

    public void setFirstName (final String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName ()
    {
        return this.lastName;
    }

    public void setLastName (final String lastName)
    {
        this.lastName = lastName;
    }

    public Set<Book> getBooks ()
    {
        return this.books;
    }

    public void setBooks (final Set<Book> books)
    {
        this.books = books;
    }

}
