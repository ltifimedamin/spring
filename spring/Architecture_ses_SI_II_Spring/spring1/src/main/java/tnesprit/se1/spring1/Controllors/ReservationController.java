package tnesprit.se1.spring1.Controllors;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tnesprit.se1.spring1.Entities.Etudiant;
import tnesprit.se1.spring1.Entities.Foyer;
import tnesprit.se1.spring1.Entities.Reservation;
import tnesprit.se1.spring1.Services.IEtudiantService;
import tnesprit.se1.spring1.Services.IReservationService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    IReservationService iReservationService;
    IEtudiantService iEtudiantService;

    @GetMapping("/allReservation")
    public List<Reservation> getReservation() {
        List<Reservation> listReservation = iReservationService.retrieveAllReservations();
        return listReservation;
    }

    @GetMapping("/Reservation/{id}")
    public Reservation retrieveReservation(@PathVariable("id") String id) {
        return iReservationService.retrieveReservation(id);
    }

    @PostMapping("/addReservation")
    public Reservation addFoyer(@RequestBody Reservation r) {
        Reservation reservation = iReservationService.addReservation(r);
        return reservation;
    }

    @DeleteMapping("/RemoveReservation/{id}")
    public void removeReservation(@PathVariable("id") String id) {
        iReservationService.removeReservation(id);
    }

    @PutMapping("/UpdateReservation")
    public Reservation updateFoyer(@RequestBody Reservation f) {
        Reservation reservation= iReservationService.updateReservation(f);
        return reservation;
    }
    @PostMapping("/affecterEtudiantAReservation/{nomEt}/{prenomEt}/{idReservation}")
    public Etudiant affecterEtudiantAReservation(@PathVariable("nomEt") String nomEt , @PathVariable("prenomEt") String prenomEt, @PathVariable("idReservation") String idReservation)  {
        Etudiant etudiant = iEtudiantService.affecterEtudiantAReservation( nomEt ,  prenomEt ,  idReservation );
        return etudiant;
    }

    @GetMapping("/reservations")
    public  List<Reservation> getReservationsParAnneeUniversitaires(
            @RequestParam ("/dateDebut")@DateTimeFormat(pattern="yyyy-MM-dd") Date dateDebut,
            @RequestParam ("/dateFin")@DateTimeFormat(pattern="yyyy-MM-dd") Date dateFin){
        return iReservationService.getReservationParAnneeUniversitaire(dateDebut,dateFin) ;

    }
}
