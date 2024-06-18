package itu.faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReponseJSONController {
    @Autowired
    ReponseRepository reponseRepository;
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/reponse/liste")
    public List<Reponse> liste() {
        return reponseRepository.findAll();
    }

    @PostMapping("/reponse/insert")
    public List<Reponse> insert(@RequestBody Reponse reponse) {
        questionRepository.save(reponse.getQuestion());
        reponseRepository.save(reponse);
        return reponseRepository.findAll();
    }

    @GetMapping("/reponse/delete")
    public List<Reponse> delete(@RequestParam("idReponse") Long idReponse) {
        reponseRepository.deleteById(idReponse);
        return reponseRepository.findAll();
    }

    @GetMapping("/reponse/information")
    public Reponse getUtilisateur(@RequestParam("idReponse") Long idReponse) {
        return reponseRepository.findById(idReponse).get();
    }
    
    @PostMapping("/reponse/update")
    public List<Reponse> modifier(@RequestBody Reponse reponse) {
        reponseRepository.save(reponse);
        return reponseRepository.findAll();
    }
}
