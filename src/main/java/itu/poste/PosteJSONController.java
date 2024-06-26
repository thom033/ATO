package itu.poste;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PosteJSONController {
    @Autowired
    PosteRepository posteRepository;
    @PostMapping("/poste/insert")
    public Poste insert(@RequestBody Poste poste) {
        poste.setDateInsertion(LocalDate.now());
        //posteRepository.save(poste);
        return poste;
    }
    
}
