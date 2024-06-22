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
        List<StatistiquePoint> valiny=argentRepository.getStatistiquePoint(annee);
        for(int i=0;i<valiny.size();i++){
            if(valiny.get(i).getMois()!=i+1){
                final int moisInd=i+1;
                valiny.add(i,new StatistiquePoint() {
                    private int nombre=0;
                    private int mois=moisInd;
                    @Override
                    public int getNombre(){
                        return nombre;
                    }
                    @Override
                    public int getMois(){
                        return mois;
                    }
                });
            }
        }
        return valiny;
    }
}
