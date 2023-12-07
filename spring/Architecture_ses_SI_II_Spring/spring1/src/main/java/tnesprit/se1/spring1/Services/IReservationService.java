package tnesprit.se1.spring1.Services;

import tnesprit.se1.spring1.Entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();

    Reservation addReservation(Reservation r);

    Reservation updateReservation(Reservation r);

    Reservation retrieveReservation(String idReservation);

    void removeReservation(String idReservation);

    List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin);
}
