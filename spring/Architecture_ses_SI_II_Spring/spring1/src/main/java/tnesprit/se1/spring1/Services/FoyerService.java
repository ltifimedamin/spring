package tnesprit.se1.spring1.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Foyer;
import tnesprit.se1.spring1.Repository.FoyerRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }


    Foyer addFoyerWithBloc (Foyer foyer){

        return null;
    }

}