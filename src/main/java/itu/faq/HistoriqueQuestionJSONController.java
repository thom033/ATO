package itu.faq;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

@RestController
public class HistoriqueQuestionJSONController {

    @Autowired
    HistoriqueQuestionRepository historiqueQuestionRepository;

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/faq/question/{idQuestion}")
    public HashMap<String, String> poserQuestion(@PathVariable("idQuestion") String idQuestion, HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        HistoriqueQuestion hq = new HistoriqueQuestion();
        hq.setUtilisateur(utilisateur);
        hq.setQuestion(questionRepository.getById(Long.valueOf(idQuestion)));
        hq.setDate(null);

        HistoriqueQuestion saved = historiqueQuestionRepository.save(hq);
        HashMap<String, String> reponse = new HashMap<>();
        reponse.put("retour", "" + saved.getId());
        return reponse;
    }
}
