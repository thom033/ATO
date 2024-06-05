package itu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import itu.model.Secteur;
import itu.repository.SecteurRepository;
import java.util.List;

@Service
public class SecteurService {

    @Autowired
    private SecteurRepository secteurRepository;

    public List<Secteur> getAllSecteurs() {
        return secteurRepository.findAll();
    }
}
