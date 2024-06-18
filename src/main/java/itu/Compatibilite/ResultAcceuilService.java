package itu.compatibilite;

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
}
