package tnesprit.se1.spring1.Services;

import tnesprit.se1.spring1.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);

    Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation);
}
