package ma.ensa.projet.repository;

import ma.ensa.projet.entities.Facture;
import org.springframework.data.repository.CrudRepository;

public interface FactureRepository extends CrudRepository<Facture, Long> {
}
