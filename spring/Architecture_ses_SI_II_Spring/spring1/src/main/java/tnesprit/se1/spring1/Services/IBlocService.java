package tnesprit.se1.spring1.Services;

import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.Etudiant;
import tnesprit.se1.spring1.Entities.Foyer;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();

    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Bloc retrieveBloc(Long idBloc);

    void removeBloc(Long idBloc);

    List<Chambre> getChambresParNomBloc(String nomBloc);

    Foyer addBlocWithFoyer(Foyer foyer);
}
