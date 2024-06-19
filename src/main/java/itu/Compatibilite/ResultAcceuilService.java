package itu.Compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ResultAcceuilService {

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    public List<ResultAcceuil> getAllResults(Long idUtilisateur) {
        return resultAcceuilRepository.findByIdUtilisateur(idUtilisateur);
    }

    public Page<ResultAcceuil> getPaginatedResults(Long idUtilisateur, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return resultAcceuilRepository.findByIdUtilisateur(idUtilisateur, pageable);
    }

    public ResultAcceuil getResult(Long idPoste) {
        return resultAcceuilRepository.getResultAcceuil(idPoste);
    }
}
