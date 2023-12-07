package tnesprit.se1.spring1.Controllors;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.Etudiant;
import tnesprit.se1.spring1.Services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    IEtudiantService iEtudiantService;

    @GetMapping("/allEtudiant")
    public List<Etudiant> getBloc() {
        List<Etudiant> listEtudiant = iEtudiantService.retrieveAllEtudiants();
        return listEtudiant;
    }

    @GetMapping("/Etudiant/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") Long id) {
        return iEtudiantService.retrieveEtudiant(id);
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = iEtudiantService.addEtudiant(e);
        return etudiant;
    }

    @DeleteMapping("/RemoveEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id") Long id) {
        iEtudiantService.removeEtudiant(id);
    }

    @PutMapping("/UpdateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant= iEtudiantService.updateEtudiant(e);
        return etudiant;
    }
    @PutMapping("/affec/{nomEt}/{prenomEt}/{idReservation}")
    public Etudiant affec(@PathVariable("nomEt") String nomEt ,@PathVariable("prenomEt") String prenomEt,@PathVariable("idReservation") String idReservation)  {
        Etudiant etudiant = iEtudiantService.affecterEtudiantAReservation( nomEt ,  prenomEt ,  idReservation );
        return etudiant;
    }
}
