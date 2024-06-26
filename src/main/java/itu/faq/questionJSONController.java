package itu.faq;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class QuestionJSONController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/question/get")
    public List<Question> getMethodName() {
        return questionRepository.findAll();
    }

    @GetMapping("/question/liste")
    public List<Question> liste() {
        return questionRepository.findAll();
    }

    @PostMapping("/question/insert")
    public List<Question> insert(@RequestBody Question question) {
        questionRepository.save(question);
        return questionRepository.findAll();
    }

    @GetMapping("/question/delete")
    public List<Question> delete(@RequestParam("idQuestion") Long idQuestion) {
        questionRepository.deleteById(idQuestion);
        return questionRepository.findAll();
    }

    @GetMapping("/question/information")
    public Question getUtilisateur(@RequestParam("idQuestion") Long idQuestion) {
        return questionRepository.findById(idQuestion).get();
    }

    @PostMapping("/question/update")
    public List<Question> modifier(@RequestBody Question question) {
        questionRepository.save(question);
        return questionRepository.findAll();
    }

    @GetMapping("/question/statistique")
    public List<StatistiqueQuestion> statistique() {
        return questionRepository.getStatistiqueQuestion();
    }
}
