package itu.entreprise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itu.entreprise.EntrepriseRepository;
import jakarta.servlet.http.HttpSession;

@RestController
public class EntrepriseJSONController {
    @Autowired
    EntrepriseRepository entrepriseRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/entreprise/liste")
    public List<Entreprise> liste() {
        return entrepriseRepository.findAll();
    }

    @PostMapping("/entreprise/insert")
    public List<Entreprise> insert(@RequestBody Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
        return entrepriseRepository.findAll();
    }

    @GetMapping("/entreprise/delete")
    public List<Entreprise> delete(@RequestParam("idEntreprise") Long idEntreprise) {
        entrepriseRepository.deleteById(idEntreprise);
        return entrepriseRepository.findAll();
    }

    @GetMapping("/entreprise/information")
    public Entreprise getUtilisateur(@RequestParam("idEntreprise") Long idEntreprise) {
        return entrepriseRepository.findById(idEntreprise).get();
    }
    
    @PostMapping("/entreprise/update")
    public List<Entreprise> modifier(@RequestBody Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
        return entrepriseRepository.findAll();
    }
}
