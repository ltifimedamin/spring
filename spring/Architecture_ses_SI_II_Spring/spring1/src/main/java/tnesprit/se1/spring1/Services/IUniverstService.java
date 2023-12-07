package tnesprit.se1.spring1.Services;

import tnesprit.se1.spring1.Entities.Universit;

import java.util.List;

public interface IUniverstService {
    List<Universit> retrieveAllUniversits();

    Universit addUniversit(Universit u);

    Universit updateUniversit(Universit u);

    Universit retrieveUniversit(Long idUniversit);

    Universit removeUniversit(Long idUniversit);

    Universit affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universit desaffecterFoyerAUniversite(long idFoyer);
}
