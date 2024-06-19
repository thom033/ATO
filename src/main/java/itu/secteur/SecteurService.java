package itu.secteur;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecteurService {
    private final SecteurRepository secteurRepository;

    public SecteurService(SecteurRepository secteurRepository) {
        this.secteurRepository = secteurRepository;
    }

    public Optional<Secteur> getById(long id){
        return secteurRepository.findById(id);
    }
}
