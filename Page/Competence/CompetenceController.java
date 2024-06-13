package itu.competence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CompetenceController {

    @Autowired
    private CompetenceRepository competenceRepository;


    @GetMapping("/competence/CRUD")
    public ModelAndView crud() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "crud/competence.jsp");
        return mv;
    }

    // GET method to retrieve all competences
    @GetMapping("/competence/liste")
    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    // POST method to create a new competence
    @PostMapping("/competence/insert")
    public Competence insertCompetence(@RequestBody Competence competence) {
        return competenceRepository.save(competence);
    }

    // GET method to delete a competence by id
    @DeleteMapping("/competence/delete/{id}")
    public void deleteCompetence(@PathVariable("id") Long id) {
        competenceRepository.deleteById(id);
    }

    // GET method to retrieve a specific competence by id
    @GetMapping("/competence/information/{id}")
    public Optional<Competence> getCompetence(@PathVariable("id") Long id) {
        return competenceRepository.findById(id);
    }

    // PUT method to update an existing competence
    @PutMapping("/competence/update")
    public Competence updateCompetence(@RequestBody Competence competence) {
        return competenceRepository.save(competence);
    }
}
