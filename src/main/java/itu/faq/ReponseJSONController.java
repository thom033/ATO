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
    public List<Question> liste() {
        return questionRepository.findAll();
    }

    @PostMapping("/reponse/insert")
    public List<Question> insert(@RequestBody Question question) {
        reponseRepository.save(question.getReponse());
        questionRepository.save(question);
        return questionRepository.findAll();
    }

    @GetMapping("/reponse/delete")
    public List<Question> delete(@RequestParam("idQuestion") Long idQuestion) {
        questionRepository.deleteById(idQuestion);
        return questionRepository.findAll();
    }

    @GetMapping("/reponse/information")
    public Question getInformation(@RequestParam("idQuestion") Long idQuestion) {
        return questionRepository.findById(idQuestion).get();
    }
    
    @PostMapping("/reponse/update")
    public List<Question> modifier(@RequestBody Question question) {
        questionRepository.save(question);
        return questionRepository.findAll();
    }
}
