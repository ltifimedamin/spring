package tnesprit.se1.spring1.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tnesprit.se1.spring1.Entities.Foyer;
import tnesprit.se1.spring1.Entities.Universit;
import tnesprit.se1.spring1.Repository.FoyerRepository;
import tnesprit.se1.spring1.Repository.UniversitRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UniversitService implements IUniverstService{
    UniversitRepository universitRepository;
    FoyerRepository foyerRepository;
    @Override
    public List<Universit> retrieveAllUniversits() {
        return universitRepository.findAll();
    }

    @Override
    public Universit addUniversit(Universit u) {
        return universitRepository.save(u);
    }

    @Override
    public Universit updateUniversit(Universit u) {
        return universitRepository.save(u);
    }

    @Override
    public Universit retrieveUniversit(Long idUniversit) {
        return universitRepository.findById(idUniversit).get();
    }

    @Override
    public Universit removeUniversit(Long idUniversit) {
    universitRepository.deleteById(idUniversit);
        return null;
    }
    @Override
    public Universit affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universit universit=universitRepository.findByNom(nomUniversite);
        Foyer foyer=foyerRepository.findById(idFoyer).get();
        universit.setFoyer(foyer);
        return universitRepository.save(universit);
    }

    @Override
    public Universit desaffecterFoyerAUniversite(long idFoyer) {

        Universit universit = universitRepository.findByFoyer(idFoyer);
        universit.setFoyer(null);
        return universitRepository.save(universit);

    }

}
