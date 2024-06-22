package itu.entretien;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EntretienJSONController {

    @Autowired
    EntretienRepository entretienRepository;

    @GetMapping("/admin/entretien/encours")
    public List<Entretien> findCurrent() {
        return entretienRepository.findAllCurrent();
    }

}
