package tnesprit.se1.spring1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    Reservation findByIdReservation(String IdReservation);


    List<Reservation> findByAnneeUniversitaireBetween(Date dateDebut, Date dateFin);
}
