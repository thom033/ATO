package itu.secteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SecteurController {

    @Autowired
    private SecteurRepository secteurRepository;

    // GET method to retrieve all Secteurs
    @GetMapping("/secteur/liste")
    public List<Secteur> getAllSecteurs() {
        return secteurRepository.findAll();
    }

    // POST method to create a new Secteur
    @PostMapping("/secteur/insert")
    public Secteur insertSecteur(@RequestBody Secteur secteur) {
        return secteurRepository.save(secteur);
    }

    // GET method to delete a Secteur by id
    @GetMapping("/secteur/delete")
    public List<Secteur> deleteSecteur(@RequestParam("idSecteur") Long idSecteur) {
        secteurRepository.deleteById(idSecteur);
        return secteurRepository.findAll();
    }

    // GET method to retrieve a specific Secteur by id
    @GetMapping("/secteur/information")
    public Optional<Secteur> getSecteur(@RequestParam("idSecteur") Long idSecteur) {
        return secteurRepository.findById(idSecteur);
    }

    // POST method to update an existing Secteur
    @PostMapping("/secteur/update")
    public Secteur updateSecteur(@RequestBody Secteur secteur) {
        return secteurRepository.save(secteur);
    }
}
