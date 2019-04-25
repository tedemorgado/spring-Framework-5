package tede.morgado.spring5framework.repository;

import org.springframework.data.repository.CrudRepository;

import tede.morgado.spring5framework.model.Publisher;

public interface IPublisherRepository
        extends CrudRepository<Publisher, Long>
{

}
