package itu.compatibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

@Service
public class ResultAcceuilService {

    @Autowired
    ResultAcceuilRepository resultAcceuilRepository;

    public List<ResultAcceuil> getAllResults(Long idUtilisateur) {
        return resultAcceuilRepository.findByIdUtilisateur(idUtilisateur);
    }

    // public Page<ResultAcceuil> getPaginatedResults(Long idUtilisateur, int page, int size) {
    //     Pageable pageable = PageRequest.of(page, size);
    //     return resultAcceuilRepository.findByIdUtilisateur(idUtilisateur, pageable);
    // }

    public ResultAcceuil getResult(Long idPoste) {
        return resultAcceuilRepository.getResultAcceuil(idPoste);
    }

    public List<ResultAcceuil> findAll() {
        return resultAcceuilRepository.findAll();
    }

    public List<ResultAcceuil> getPaginatedResults(Long idPoste, int page, int size) {
        List<ResultAcceuil> allResults = getAllResults(idPoste);
        int start = page * size;
        int end = Math.min(start + size, allResults.size());

        if (start > allResults.size()) {
            return Collections.emptyList();
        }
        return allResults.subList(start, end);
    }

    public Long getUserSecteur(Long idUtilisateur) {
        return resultAcceuilRepository.getUserSecteur(idUtilisateur);
    }


}
