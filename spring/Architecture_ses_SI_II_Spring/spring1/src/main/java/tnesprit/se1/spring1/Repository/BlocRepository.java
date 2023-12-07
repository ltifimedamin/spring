package tnesprit.se1.spring1.Repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Etudiant;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
@Query("select b from Bloc b where b.nomBloc =:nomBloc")
public List<Bloc> getBlocWithName(@Param("nomBloc") String nomBloc);

@Query(value = "SELECT * FROM Bloc b WHERE b.nom_bloc = :nomBloc", nativeQuery = true)
List<Bloc> getBlocWithNameB(@Param("nomBloc") String nomBloc);

    Bloc findByNomBloc(String nomBloc);

}
