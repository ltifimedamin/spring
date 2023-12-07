package tnesprit.se1.spring1.Services;

import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.Etudiant;
import tnesprit.se1.spring1.Entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(Long idChambre);

    void removeChambre(Long idChambre);

    Bloc affecterChambresABloc(List<Long> numeroChambres, String nomBloc);

    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);
}
