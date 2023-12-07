package tnesprit.se1.spring1.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Universit {
    @Id
    private long idUniversite;
    private String nomUniversite;
    private String adresse;




    @OneToOne // Correct the mappedBy attribute
    private Foyer foyer;
}
