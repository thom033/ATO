package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultAcceuilService {

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    public List<ResultAcceuil> getAllResults(Long idUtilisateur) {
        return resultAcceuilRepository.findByIdUtilisateur(idUtilisateur);
    }
    public ResultAcceuil getResult(Long idPoste) {
        return resultAcceuilRepository.getResultAcceuil(idPoste);
    }
}
