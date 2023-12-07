package tnesprit.se1.spring1.Controllors;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.TypeChambre;
import tnesprit.se1.spring1.Services.IBlocService;
import tnesprit.se1.spring1.Services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    IChambreService iChambreService;
    IBlocService iblocService;

    @GetMapping("/allChambre")
    public List<Chambre> getBloc() {
        List<Chambre> listChambres = iChambreService.retrieveAllChambres();
        return listChambres;
    }

    @GetMapping("/Chambre/{id}")
    public Chambre retrieveChambre(@PathVariable("id") Long id) {
        return iChambreService.retrieveChambre(id);
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = iChambreService.addChambre(c);
        return chambre;
    }

    @DeleteMapping("/RemoveChambre/{id}")
    public void removeChambre(@PathVariable("id") Long id) {
        iChambreService.removeChambre(id);
    }

    @PutMapping("/UpdateChambre")
    public Chambre updateBloc(@RequestBody Chambre c) {
        Chambre chambre= iChambreService.updateChambre(c);
        return chambre;
    }


    @PostMapping("/affecterChambresABloc/{numeroChambres}/{nomBloc}")
    public Bloc affecterChambresABloc(@PathVariable List<Long> numeroChambres,@PathVariable String nomBloc){
        return iChambreService.affecterChambresABloc(numeroChambres,nomBloc);
    }


    @GetMapping("/bloc/{idBloc}/chambresCountType/{type}")
    public long countChmbresByTypeAndBloc(
            @PathVariable long idBloc,
            @PathVariable TypeChambre type
    ){
        return iChambreService.nbChambreParTypeEtBloc(type,idBloc);
    }
}
