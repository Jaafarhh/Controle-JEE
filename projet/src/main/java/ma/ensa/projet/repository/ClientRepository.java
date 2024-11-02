package ma.ensa.projet.repository;

import ma.ensa.projet.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
