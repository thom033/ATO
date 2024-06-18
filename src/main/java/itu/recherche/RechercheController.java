package itu.recherche;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itu.competence.Competence;
import itu.competence.CompetenceRepository;
import itu.diplome.Diplome;
import itu.diplome.DiplomeRepository;
import itu.secteur.Secteur;
import itu.secteur.SecteurRepository;
import itu.poste.PosteDetail;

@Controller
public class RechercheController {
    @Autowired
    SecteurRepository secteurRepository;

    @Autowired
    DiplomeRepository diplomeRepository;

    @Autowired
    CompetenceRepository competenceRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public RechercheController(SecteurRepository secteurRepository, DiplomeRepository diplomeRepository,
                                CompetenceRepository competenceRepository, JdbcTemplate jdbcTemplate) {
        this.secteurRepository = secteurRepository;
        this.diplomeRepository = diplomeRepository;
        this.competenceRepository = competenceRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/recherche")
    public ModelAndView recherche() {
        ModelAndView mv = new ModelAndView("template");
        List<Secteur> allSec = secteurRepository.findAll();
        List<Diplome> allDip = diplomeRepository.findAll();
        List<Competence> allComp = competenceRepository.findAll();
        mv.addObject("allSecteurs", allSec);
        mv.addObject("allDiplomes", allDip);
        mv.addObject("allCompetences", allComp);

        mv.addObject("page", "recherche/recherche-form");
        return mv;
    }

    @GetMapping("/recherche_result")
    public List<PosteDetail> searchResult(@RequestParam Map<String, String> params) {
        String title = params.get("title");
        String diplome = params.get("diplome");
        String secteur = params.get("secteur");
        String competence = params.get("competence");
        String ageMin = params.get("ageMin");
        String ageMax = params.get("ageMax");
        String salaireMin = params.get("salaireMin");
        String salaireMax = params.get("salaireMax");
        String distance = params.get("distance");
        String anneeExperience = params.get("anneeExperience");

        StringBuilder sql = new StringBuilder("SELECT * FROM postes_details WHERE 1=1");
        List<Object> paramsList = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            sql.append(" AND poste_titre LIKE ?");
            paramsList.add("%" + title + "%");
        }
        if (diplome != null && !diplome.isEmpty()) {
            sql.append(" AND id_diplome = ?");
            paramsList.add(Long.parseLong(diplome));
        }
        if (secteur != null && !secteur.isEmpty()) {
            sql.append(" AND id_secteur = ?");
            paramsList.add(Long.parseLong(secteur));
        }
        if (competence != null && !competence.isEmpty()) {
            sql.append(" AND competence_requise LIKE ?");
            paramsList.add("%" + competence + "%");
        }
        if (ageMin != null && !ageMin.isEmpty()) {
            sql.append(" AND (age_requise IS NULL OR age_requise >= ?)");
            paramsList.add(Integer.parseInt(ageMin));
        }
        if (ageMax != null && !ageMax.isEmpty()) {
            sql.append(" AND (age_requise IS NULL OR age_requise <= ?)");
            paramsList.add(Integer.parseInt(ageMax));
        }
        if (salaireMin != null && !salaireMin.isEmpty()) {
            sql.append(" AND poste_salaire >= ?");
            paramsList.add(Double.parseDouble(salaireMin));
        }
        if (salaireMax != null && !salaireMax.isEmpty()) {
            sql.append(" AND poste_salaire <= ?");
            paramsList.add(Double.parseDouble(salaireMax));
        }
        if (distance != null && !distance.isEmpty()) {
            sql.append(" AND distance <= ?");
            paramsList.add(Double.parseDouble(distance));
        }
        if (anneeExperience != null && !anneeExperience.isEmpty()) {
            sql.append(" AND nbr_annee_experience >= ?");
            paramsList.add(Integer.parseInt(anneeExperience));
        }

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql.toString(), paramsList.toArray());
        List<PosteDetail> results = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Map<String, Object> row : rows) {
            PosteDetail posteDetail = new PosteDetail();
            posteDetail.setIdPoste((Long) row.get("id_poste"));
            posteDetail.setPosteDescription((String) row.get("poste_description"));

            // Conversion de java.sql.Date et java.sql.Timestamp en String
            Date dateInsertion = (Date) row.get("poste_date_insertion");
            posteDetail.setPosteDateInsertion(dateInsertion != null ? dateFormat.format(dateInsertion) : null);

            // Conversion de BigDecimal en Double
            BigDecimal salaire = (BigDecimal) row.get("poste_salaire");
            posteDetail.setPosteSalaire(salaire != null ? salaire.doubleValue() : null);

            posteDetail.setPosteTitre((String) row.get("poste_titre"));
            posteDetail.setNbrAnneeExperience((Integer) row.get("nbr_annee_experience"));
            posteDetail.setNbrAnneeFormation((Integer) row.get("nbr_annee_formation"));
            posteDetail.setAgeRequise((Integer) row.get("age_requise"));
            posteDetail.setIdDiplome((Long) row.get("id_diplome"));
            posteDetail.setDiplomeNom((String) row.get("diplome_nom"));
            posteDetail.setIdSecteur((Long) row.get("id_secteur"));
            posteDetail.setSecteurNom((String) row.get("secteur_nom"));
            posteDetail.setIdEntreprise((Long) row.get("id_entreprise"));
            posteDetail.setEntrepriseNom((String) row.get("entreprise_nom"));
            posteDetail.setEntreprisePoint((Integer) row.get("entreprise_point"));
            posteDetail.setEntrepriseType((String) row.get("entreprise_type"));

            // Conversion de java.sql.Date et java.sql.Timestamp en String
            Date dateCreation = (Date) row.get("entreprise_date_creation");
            posteDetail.setEntrepriseDateCreation(dateCreation != null ? dateFormat.format(dateCreation) : null);

            posteDetail.setEntrepriseAdresse((String) row.get("entreprise_adresse"));
            posteDetail.setEntrepriseSiteWeb((String) row.get("entreprise_site_web"));
            posteDetail.setEntrepriseMail((String) row.get("entreprise_mail"));
            posteDetail.setEntrepriseNumTelephone((String) row.get("entreprise_num_telephone"));
            posteDetail.setEntrepriseLatitude((Double) row.get("entreprise_latitude"));
            posteDetail.setEntrepriseLongitude((Double) row.get("entreprise_longitude"));
            posteDetail.setEntrepriseImage((String) row.get("entreprise_image"));
            posteDetail.setCompetenceRequise((String) row.get("competence_requise"));
            results.add(posteDetail);
        }

        return results;
    }
}
