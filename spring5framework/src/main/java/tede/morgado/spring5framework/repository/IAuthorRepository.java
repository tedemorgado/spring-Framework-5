package tede.morgado.spring5framework.repository;

import org.springframework.data.repository.CrudRepository;

import tede.morgado.spring5framework.model.Author;

public interface IAuthorRepository
        extends CrudRepository<Author, Long>
{

}
