package itu.competence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CompetenceJSONController {
    @Autowired
    CompetenceRepository competenceRepository;
    @GetMapping("/competenceUtilisateur/liste")
    public List<Competence> liste() {
        return competenceRepository.findAll();
    }
    
}
