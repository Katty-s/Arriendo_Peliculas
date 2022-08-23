package cl.dojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.dojo.models.Arriendo;

@Repository
public interface IArriendoRepository extends CrudRepository<Arriendo, Integer> {

}
