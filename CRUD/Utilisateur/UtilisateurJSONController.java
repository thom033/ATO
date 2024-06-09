package itu.utilisateur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

@RestController
public class UtilisateurJSONController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    HttpSession httpSession;

    // Fetch all utilisateurs
    @GetMapping("/utilisateur/liste")
    public List<Utilisateur> liste() {
        return utilisateurRepository.findAll();
    }

    // Insert a new utilisateur
    @PostMapping("/utilisateur/insert")
    public List<Utilisateur> insert(@RequestBody Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return utilisateurRepository.findAll();
    }

    // Delete an utilisateur by id
    @GetMapping("/utilisateur/delete")
    public List<Utilisateur> delete(@RequestParam("idUtilisateur") Long idUtilisateur) {
        utilisateurRepository.deleteById(idUtilisateur);
        return utilisateurRepository.findAll();
    }

    // Fetch a specific utilisateur by id
    @GetMapping("/utilisateur/information")
    public Utilisateur getUtilisateur(@RequestParam("idUtilisateur") Long idUtilisateur) {
        return utilisateurRepository.findById(idUtilisateur).orElse(null);
    }

    // Update an existing utilisateur
    @PostMapping("/utilisateur/update")
    public List<Utilisateur> update(@RequestBody Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return utilisateurRepository.findAll();
    }
}
