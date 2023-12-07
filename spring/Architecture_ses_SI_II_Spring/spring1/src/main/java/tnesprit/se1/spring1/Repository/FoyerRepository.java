package tnesprit.se1.spring1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}
