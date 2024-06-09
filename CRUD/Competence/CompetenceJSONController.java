package itu.competence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompetenceJSONController {

    @Autowired
    private CompetenceRepository competenceRepository;

    // Fetch all competences
    @GetMapping("/competence/liste")
    public List<Competence> liste() {
        return competenceRepository.findAll();
    }

    // Insert a new competence
    @PostMapping("/competence/insert")
    public Competence insert(@RequestBody Competence competence) {
        return competenceRepository.save(competence);
    }

    // Delete a competence by id
    @DeleteMapping("/competence/delete")
    public void delete(@RequestParam("id") Long id) {
        competenceRepository.deleteById(id);
    }

    // Fetch a specific competence by id
    @GetMapping("/competence/information")
    public Optional<Competence> getCompetence(@RequestParam("id") Long id) {
        return competenceRepository.findById(id);
    }

    // Update an existing competence
    @PutMapping("/competence/update")
    public Competence update(@RequestBody Competence competence) {
        return competenceRepository.save(competence);
    }
}
