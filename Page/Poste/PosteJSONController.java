package itu.poste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poste/json")
public class PosteJSONController {

    @Autowired
    private PosteRepository posteRepository;

    @GetMapping("/liste")
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @PostMapping("/ajouter")
    public List<Poste> addPoste(@RequestBody Poste poste) {
        posteRepository.save(poste);
        return posteRepository.findAll();
    }

    @DeleteMapping("/supprimer/{id}")
    public List<Poste> deletePoste(@PathVariable("id") Long id) {
        posteRepository.deleteById(id);
        return posteRepository.findAll();
    }

    @GetMapping("/details/{id}")
    public Poste getPosteById(@PathVariable("id") Long id) {
        return posteRepository.findById(id).orElse(null);
    }

    @PostMapping("/modifier")
    public List<Poste> updatePoste(@RequestBody Poste poste) {
        posteRepository.save(poste);
        return posteRepository.findAll();
    }
}
