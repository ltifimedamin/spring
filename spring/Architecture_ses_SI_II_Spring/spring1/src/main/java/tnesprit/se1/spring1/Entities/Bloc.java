package tnesprit.se1.spring1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@Entity
public class Bloc {
    @Id
    private long idBloc;
    private String nomBloc;
    private long capciteBloc;

    public Bloc() {
    }

    public Bloc(long idBloc, String nomBloc, long capciteBloc) {
        this.idBloc = idBloc;
        this.nomBloc = nomBloc;
        this.capciteBloc = capciteBloc;
    }

    public long getIdBloc() {
        return idBloc;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public long getCapciteBloc() {
        return capciteBloc;
    }

    public void setIdBloc(long idBloc) {
        this.idBloc = idBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public void setCapciteBloc(long capciteBloc) {
        this.capciteBloc = capciteBloc;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Foyer foyer;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> chambres;
}
