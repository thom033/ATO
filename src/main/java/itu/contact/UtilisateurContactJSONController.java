package itu.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

public class UtilisateurContactJSONController {
    @Autowired
    UtilisateurContactRepository utilisateurContactRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/utilisateurContact/liste")
    public List<UtilisateurContact> liste(HttpSession session) {
        return utilisateurContactRepository.findByUtilisateurId(((Utilisateur)session.getAttribute("utilisateur")).getId());
    }

    @PostMapping("/utilisateurContact/insert")
    public List<UtilisateurContact> insert(@RequestBody UtilisateurContact utilisateurContact) {
        utilisateurContactRepository.save(utilisateurContact);
        return utilisateurContactRepository.findByUtilisateurId(utilisateurContact.getUtilisateur().getId());
    }

    @GetMapping("/utilisateurContact/delete")
    public List<UtilisateurContact> delete(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("idContact") Long idContact) {
        UtilisateurContactId idUtilisateurContactId=new UtilisateurContactId(idUtilisateur, idContact);
        utilisateurContactRepository.deleteById(idUtilisateurContactId);
        return utilisateurContactRepository.findAll();
    }

    @GetMapping("/utilisateurContact/information")
    public UtilisateurContact getUtilisateur(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("idContact") Long idContact) {
        UtilisateurContactId idUtilisateurContactId=new UtilisateurContactId(idUtilisateur, idContact);
        utilisateurContactRepository.deleteById(idUtilisateurContactId);
        return utilisateurContactRepository.findById(idUtilisateurContactId).get();
    }
    
    @PostMapping("/utilisateurContact/update")
    public List<UtilisateurContact> modifier(@RequestBody UtilisateurContact utilisateurContact) {
        utilisateurContactRepository.save(utilisateurContact);
        return utilisateurContactRepository.findAll();
    }
}
