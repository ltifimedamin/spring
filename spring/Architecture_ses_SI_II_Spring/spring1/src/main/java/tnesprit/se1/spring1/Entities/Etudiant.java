package tnesprit.se1.spring1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long idEtudiant;
    @Column(name="nom")
    private String nomEt;
    @Column(name="prenom")
    private String prenomEt;
    private long cin ;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    public Etudiant() {
    }

    public Etudiant(long idEtudiant, String nomEt, String prenomEt, long cin, String ecole, Date dateNaissance) {
        this.idEtudiant = idEtudiant;
        this.nomEt = nomEt;
        this.prenomEt = prenomEt;
        this.cin = cin;
        this.ecole = ecole;
        this.dateNaissance = dateNaissance;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
