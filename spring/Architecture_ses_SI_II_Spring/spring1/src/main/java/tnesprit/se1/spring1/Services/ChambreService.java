package tnesprit.se1.spring1.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tnesprit.se1.spring1.Entities.Bloc;
import tnesprit.se1.spring1.Entities.Chambre;
import tnesprit.se1.spring1.Entities.TypeChambre;
import tnesprit.se1.spring1.Repository.BlocRepository;
import tnesprit.se1.spring1.Repository.ChambreRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
   ChambreRepository chambreRepository;
   BlocRepository blocRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numeroChambres, String nomBloc) {

            Bloc bloc = blocRepository.findByNomBloc(nomBloc);
            List<Chambre> chambres = chambreRepository.findAllByNumeroChambreIn(numeroChambres);
            chambres.forEach(chambre -> chambre.setBloc(bloc));
            chambreRepository.saveAll(chambres);
            return bloc;

    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        long nb = 0;

        if (bloc != null) {
            List<Chambre> chambres = chambreRepository.findByBloc(bloc);

            for (Chambre chambre : chambres) {
                if (chambre.getTypeChambre() == type) {
                    nb++;
                }
            }
        }
        return nb;
    }
}
