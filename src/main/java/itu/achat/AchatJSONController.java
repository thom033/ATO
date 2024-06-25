package itu.achat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AchatJSONController {

    @Autowired
    private PrixPointRepository prixPointRepository;
    
    @Autowired
    private ArgentRepository argentRepository;

    @Autowired
    private NombrePromotionRepository nombrePromotionRepository;
    
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

    @GetMapping("/monnaie/statistique")
    public List<StatistiqueArgentEntrant> getStatistiqueMonnaie(@RequestParam("annee") int annee) {
        return prixPointRepository.getStatistiqueArgentEntrants(annee);
    }

    @GetMapping("/monnaie/rentrant_date")
    public double getStatistiqueMonnaie(@RequestParam("dateMin") LocalDate dateMin,@RequestParam("dateMax") LocalDate dateMax) {
        double valiny=0;
        Optional<Double> recep=prixPointRepository.getMonnaieDate(dateMin,dateMax);
        if(recep.isPresent()){
            valiny=recep.get();
        }
        return valiny;
    }

    @GetMapping("/prix_point/actuel")
    public double getPrixPointActuel() {
        return prixPointRepository.getPrixPoint(LocalDate.now()).getPrix();
    }

    @GetMapping("/promotion/actuel")
    public NombrePromotion getPromotion() {
        return nombrePromotionRepository.getPromotionActuel();
    }
    

    @PostMapping("/prix_point/changer")
    public String changePrixPoint(@RequestBody PrixPoint prixPoint) {
        prixPointRepository.save(prixPoint);
        return "{\"message\":\"inserted\"}";
    }
    
    @PostMapping("/promotion/changer")
    public String changePromotion(@RequestBody NombrePromotion nbPromotion) {
        nombrePromotionRepository.save(nbPromotion);
        return "{\"message\":\"inserted\"}";
    }
    
}
