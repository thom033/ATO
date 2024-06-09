package itu.diplome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class DiplomeController {

    @Autowired
    DiplomeRepository diplomeRepository;

    // Fetch all diplomes
    @GetMapping("/diplome/liste")
    public List<Diplome> liste() {
        return diplomeRepository.findAll();
    }

    // Insert a new diplome
    @PostMapping("/diplome/insert")
    public List<Diplome> insert(@RequestBody Diplome diplome) {
        diplomeRepository.save(diplome);
        return diplomeRepository.findAll();
    }

    // Delete a diplome by id
    @GetMapping("/diplome/delete")
    public List<Diplome> delete(@RequestParam("idDiplome") Long idDiplome) {
        diplomeRepository.deleteById(idDiplome);
        return diplomeRepository.findAll();
    }

    // Fetch a specific diplome by id
    @GetMapping("/diplome/information")
    public Diplome getDiplome(@RequestParam("idDiplome") Long idDiplome) {
        return diplomeRepository.findById(idDiplome).orElse(null);
    }

    // Update an existing diplome
    @PostMapping("/diplome/update")
    public List<Diplome> update(@RequestBody Diplome diplome) {
        diplomeRepository.save(diplome);
        return diplomeRepository.findAll();
    }
}
