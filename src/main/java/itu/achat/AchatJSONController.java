package itu.achat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchatJSONController {
    
    @Autowired
    private ArgentRepository argentRepository; 
    
    @GetMapping("/point/statistique")
    public List<StatistiquePoint> pointStatistique(@RequestParam int annee) {
        return argentRepository.getStatistiquePoint(annee);
    }
}
