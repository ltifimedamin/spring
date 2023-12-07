package tnesprit.se1.spring1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.Universit;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {

    @Query(value = "SELECT * FROM Universit u WHERE u.foyer_id_foyer = :id", nativeQuery = true)
    Universit findByFoyer(@Param("id") Long id);

    List<Chambre> findAllByNumeroChambreIn(List<Long> numeroChambre);
    List<Chambre> findByBloc(Bloc bloc);
}
