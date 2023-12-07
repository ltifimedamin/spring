package tnesprit.se1.spring1.Controllors;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Repository.BlocRepository;
import tnesprit.se1.spring1.Services.BlocService;
import tnesprit.se1.spring1.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    @Autowired
    IBlocService blocService;
    @Autowired //asna3li instance win nest7a9ha
    private BlocRepository blocRepository;
    @GetMapping("/allBloc")
    public List<Bloc> getBloc() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    @GetMapping("/Bloc/{id}")
    public Bloc retrievebloc(@PathVariable("id") Long id) {
        return blocService.retrieveBloc(id);
    }

    @PostMapping("/addBloc")
    public Bloc addEtudiant(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @DeleteMapping("/RemoveBloc/{id}")
    public void removeBloc(@PathVariable("id") Long id) {
        blocService.removeBloc(id);
    }

    @PutMapping("/UpdateBloc")
    public Bloc updateBloc(@RequestBody Bloc e) {
        Bloc bloc= blocService.updateBloc(e);
        return bloc;
    }

    @GetMapping("/getBlocByNom/{nom}")
    public List<Bloc> getBloc(@PathVariable String nom){
        return blocRepository.getBlocWithName(nom);
     //List<Bloc> x= blocRepository.getBlocWithName(nom);
       //return x;
    }
    @GetMapping("/getBlocByName/{nom}")
    public List<Bloc> getBlocs(@PathVariable String nom) {
        return blocRepository.getBlocWithNameB(nom);
    }

    }
