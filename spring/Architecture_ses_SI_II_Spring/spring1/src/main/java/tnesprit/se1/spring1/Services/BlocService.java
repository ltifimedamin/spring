package tnesprit.se1.spring1.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.Foyer;
import tnesprit.se1.spring1.Repository.BlocRepository;
import tnesprit.se1.spring1.Repository.ChambreRepository;
import tnesprit.se1.spring1.Repository.FoyerRepository;

import java.util.Collections;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class BlocService implements IBlocService{
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);

        if (bloc != null) {
            return chambreRepository.findByBloc(bloc);
        } else {
            return Collections.emptyList();
        }
    }
    @Override
    public Foyer addBlocWithFoyer  (Foyer foyer){

        Foyer foy =foyerRepository.save(foyer);

        foyer.getBlocs().forEach(
                bloc -> {
                    bloc.setFoyer(foy);
                    blocRepository.save(bloc);

                }

        );

        return foyer;
    }

}
