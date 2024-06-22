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
    @GetMapping("/embauche/statistique")
    public List<StatistiqueEntretienReussi> getStatistiqueEntretien(@RequestParam int annee) {
        List<StatistiqueEntretienReussi> valiny=entretienRepository.getStatistiqueEntretien(annee);
        for(int i=0;i<valiny.size();i++){
            if(valiny.get(i).getMois()!=i+1){
                final int moisInd=i+1;
                valiny.add(i,new StatistiqueEntretienReussi() {
                    private int mois=moisInd;
                    private int nbEntretien=0;
                    @Override
                    public int getNbEntretien() {
                        return nbEntretien;
                    }
                
                    @Override
                    public int getMois() {
                        return mois;
                    }
                });
            }
        }
        return valiny;
    }   
}