package itu.statistique;

import itu.secteur.Secteur;
import itu.secteur.SecteurRepository;
import itu.secteur.SecteurService;

public class StatistiqueSecteur {
    Secteur secteur;
    long total;

    public StatistiqueSecteur(int secteur, long total, SecteurService secteurService) {
        this.setSecteur(secteur, secteurService);
        this.setTotal(total);
    }
    public void setSecteur(int secteur, SecteurService secteurService) {
        this.secteur = secteurService.getById(secteur).get();
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public Secteur getSecteur() {
        return secteur;
    }
    public long getTotal() {
        return total;
    }
}
