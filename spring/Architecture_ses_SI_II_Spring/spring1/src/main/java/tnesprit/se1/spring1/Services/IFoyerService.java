package tnesprit.se1.spring1.Services;

import tnesprit.se1.spring1.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retrieveFoyer(Long idFoyer);

    void removeFoyer(Long idFoyer);


}
