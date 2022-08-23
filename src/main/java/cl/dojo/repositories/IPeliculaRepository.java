package cl.dojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.dojo.models.Pelicula;


@Repository
public interface IPeliculaRepository extends CrudRepository<Pelicula, Integer> {

}
