package itu.diplome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itu.diplome.DiplomeRepository;
import jakarta.servlet.http.HttpSession;

@RestController
public class DiplomeJSONController {
    @Autowired
    DiplomeRepository diplomeRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/diplome/liste")
    public List<Diplome> liste() {
        return diplomeRepository.findAll();
    }

    @PostMapping("/diplome/insert")
    public List<Diplome> insert(@RequestBody Diplome diplome) {
        diplomeRepository.save(diplome);
        return diplomeRepository.findAll();
    }

    @GetMapping("/diplome/delete")
    public List<Diplome> delete(@RequestParam("idDiplome") Long idDiplome) {
        diplomeRepository.deleteById(idDiplome);
        return diplomeRepository.findAll();
    }

    @GetMapping("/diplome/information")
    public Diplome getUtilisateur(@RequestParam("idDiplome") Long idDiplome) {
        return diplomeRepository.findById(idDiplome).get();
    }
    
    @PostMapping("/diplome/update")
    public List<Diplome> modifier(@RequestBody Diplome diplome) {
        diplomeRepository.save(diplome);
        return diplomeRepository.findAll();
    } 
}
