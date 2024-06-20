package itu.postulation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import itu.compatibilite.PosteDetails;
import itu.compatibilite.PosteDetailsRepository;
import itu.compatibilite.ResultAcceuilRepository;

@RestController
public class PostulationJSONController {

    @Autowired
    PostulationRepository postulationRepository;

    @GetMapping("/postulation/liste")
    public List<Postulation> liste() {
        return postulationRepository.findAll();
    }

}
