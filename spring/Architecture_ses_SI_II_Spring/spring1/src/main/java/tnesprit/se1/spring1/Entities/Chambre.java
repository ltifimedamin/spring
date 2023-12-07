package tnesprit.se1.spring1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeCh;

    public Chambre() {
    }

    public Chambre(long idChambre, long numeroChambre, TypeChambre typeC) {
        this.idChambre = idChambre;
        this.numeroChambre = numeroChambre;
        this.typeCh = typeCh;
    }

    public long getIdChambre() {
        return idChambre;
    }

    public long getNumeroChambre() {
        return numeroChambre;
    }

    public TypeChambre getTypeCh() {
        return typeCh;
    }

    public void setIdChambre(long idChambre) {
        this.idChambre = idChambre;
    }

    public void setNumeroChambre(long numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public void setTypeCh(TypeChambre typeCh) {
        this.typeCh = typeCh;
    }

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
    @ManyToOne
    private Bloc bloc;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
