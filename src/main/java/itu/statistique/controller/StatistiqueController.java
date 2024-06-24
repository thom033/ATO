package itu.statistique.controller;

import itu.statistique.StatistiqueSecteur;
import itu.statistique.repository.StatistiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StatistiqueController {
    @Autowired
    StatistiqueRepository statRep;

    @GetMapping("/statistique")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "statistique/statistiqueBatton");
        return mv;
    }
}
