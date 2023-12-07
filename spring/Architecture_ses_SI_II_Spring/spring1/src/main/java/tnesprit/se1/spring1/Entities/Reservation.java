package tnesprit.se1.spring1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Reservation {
    @Id

    private String idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;



    public Reservation(String idReservation, Date anneeUniversitaire, boolean estValide) {
        this.idReservation = idReservation;
        this.anneeUniversitaire = anneeUniversitaire;
        this.estValide = estValide;
    }


    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;
}
