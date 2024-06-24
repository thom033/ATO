package itu.statistique.controller;

import itu.statistique.PointVendu;
import itu.statistique.StatistiquePoint;
import itu.statistique.StatistiqueSecteur;
import itu.statistique.repository.PointVenduRepository;
import itu.statistique.repository.StatistiquePointRepository;
import itu.statistique.repository.StatistiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class StatistiqueJSONController {
    @Autowired
    StatistiqueRepository statRep;
    @Autowired
    StatistiquePointRepository statPoint;
    @Autowired
    PointVenduRepository pointVenduRepository;
    @GetMapping("/statistique/secteurRecherche")
    public List<Object[]> secteurPlusRecherche(){
        return statRep.statSecteurPostule();
    }

    @GetMapping("/statistique/pointTravailPostule")
    public List<StatistiquePoint> pointTravailPostule(){
        return statPoint.statPoint();
    }

    @GetMapping("/statistique/pointVendu")
    public Integer pointVendu(@Param("debut") String debut,@Param("fin") String fin) throws ParseException {
        return pointVenduRepository.statPointVendu(java.sql.Date.valueOf(debut), java.sql.Date.valueOf(fin));
    }
}
