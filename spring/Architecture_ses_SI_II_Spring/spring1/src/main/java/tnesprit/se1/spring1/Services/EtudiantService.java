package tnesprit.se1.spring1.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tnesprit.se1.spring1.Entities.Etudiant;
import tnesprit.se1.spring1.Entities.Reservation;
import tnesprit.se1.spring1.Repository.EtudiantRepository;
import tnesprit.se1.spring1.Repository.ReservationRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {etudiantRepository.deleteById(idEtudiant);}

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Etudiant etudiant = etudiantRepository.findByNomEtAndPrenomEt(nomEt, prenomEt);
        Reservation reserv = reservationRepository.findById(idReservation).get();


        List<Etudiant> etudiants = new ArrayList<>(reserv.getEtudiants());

        etudiants.add(etudiant);
        reserv.setEtudiants(new HashSet<>(etudiants));
        reservationRepository.save(reserv);
        return etudiant;
    }



}
