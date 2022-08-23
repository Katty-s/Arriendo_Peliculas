package cl.dojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.dojo.models.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

}
