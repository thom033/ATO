package itu.faq;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class questionJSONController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/question/get")
    public List<Question> getMethodName() {
        return questionRepository.findAll();
    }

}
