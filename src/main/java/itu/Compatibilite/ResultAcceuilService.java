package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultAcceuilService {

    private final ResultAcceuilRepository repository;

    @Autowired
    public ResultAcceuilService(ResultAcceuilRepository repository) {
        this.repository = repository;
    }

    public List<ResultAcceuil> getAllResults(Long idUtilisateur ,Long idSecteur) {
        return repository.getResultAcceuils(idUtilisateur , idSecteur);
    }

    public Long getUserSecteur(Long idUtilisateur) {
        return repository.getUserSecteur(idUtilisateur);
    }

    /*public List<ResultAcceuil> getBestPoint() {
        return repository.getBestPoint();
    }

    public List<String> getPositif(Integer idUtilisateur, Integer idPoste) {
        return repository.getPositif(idUtilisateur, idPoste);
    }

    public List<String> getNegatif(Integer idUtilisateur, Integer idPoste) {
        return repository.getNegatif(idUtilisateur, idPoste);
    }*/
}
