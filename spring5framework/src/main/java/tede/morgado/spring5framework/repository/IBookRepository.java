package tede.morgado.spring5framework.repository;

import org.springframework.data.repository.CrudRepository;

import tede.morgado.spring5framework.model.Book;

public interface IBookRepository
        extends CrudRepository<Book, Long>
{

}
