package itu.poste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poste")
public class PosteController {

    @Autowired
    private PosteRepository posteRepository;

    @GetMapping("/liste")
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @PostMapping("/ajouter")
    public Poste addPoste(@RequestBody Poste poste) {
        return posteRepository.save(poste);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deletePoste(@PathVariable("id") Long id) {
        posteRepository.deleteById(id);
    }

    @GetMapping("/details/{id}")
    public Poste getPosteById(@PathVariable("id") Long id) {
        return posteRepository.findById(id).orElse(null);
    }

    @PutMapping("/modifier")
    public Poste updatePoste(@RequestBody Poste poste) {
        return posteRepository.save(poste);
    }
}
