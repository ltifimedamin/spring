package tnesprit.se1.spring1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tnesprit.se1.spring1.Entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findByNomEtAndPrenomEt(String nomEt, String prenomEt);

}
