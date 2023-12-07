package tnesprit.se1.spring1.Controllors;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tnesprit.se1.spring1.Entities.Reservation;
import tnesprit.se1.spring1.Entities.Universit;
import tnesprit.se1.spring1.Services.IUniverstService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@RequestMapping("/universit")
public class UniversitController {
    IUniverstService iUniverstService;

    @GetMapping("/allUniversit")
    public List<Universit> getUniversit() {
        List<Universit> listUniversit = iUniverstService.retrieveAllUniversits();
        return listUniversit;
    }

    @GetMapping("/Universit/{id}")
    public Universit retrieveUniversit(@PathVariable("id") Long id) {
        return iUniverstService.retrieveUniversit(id);
    }

    @PostMapping("/addUniversit")
    public Universit addUniversit(@RequestBody Universit u) {
        Universit universit = iUniverstService.addUniversit(u);
        Logger.getLogger("amin").warning("amin ok");
        return universit;
    }

    @DeleteMapping("/RemoveUniversit/{id}")
    public void removeUniversit(@PathVariable("id") Long id) {
        iUniverstService.removeUniversit(id);
    }

    @PutMapping("/UpdateUniversit")
    public Universit updateUniversit(@RequestBody Universit f) {
        Universit universit= iUniverstService.updateUniversit(f);
        return universit;
    }
    @PostMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public Universit affecterFoyerAUniversite(@PathVariable ("idFoyer") Long idFoyer,
                                              @PathVariable ("nomUniversite") String nomUniversite) {
        Universit universit = iUniverstService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    //Logger.getLogger("amin").warning(universit.getFoyer().getIdFoyer()+"");
        return universit;
    }

    @PostMapping("/desaffecterFoyerAUniversite/{idFoyer}")
    public Universit desaffecterFoyerAUniversite(@PathVariable ("idFoyer") Long idFoyer) {
        Universit universit = iUniverstService.desaffecterFoyerAUniversite(idFoyer);
        //Logger.getLogger("amin").warning(universit.getFoyer().getIdFoyer()+"");
        return universit;
    }
}
