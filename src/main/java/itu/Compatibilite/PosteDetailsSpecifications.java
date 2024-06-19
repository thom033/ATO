package itu.compatibilite;

import org.springframework.data.jpa.domain.Specification;

public class PosteDetailsSpecifications {

    public static Specification<PosteDetails> withTitre(String titre) {
        return (root, query, criteriaBuilder) -> {
            if (titre == null || titre.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            String titreLower = titre.toLowerCase();
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("posteTitre")), "%" + titreLower + "%");
        };
    }

    public static Specification<PosteDetails> withIdDiplome(Long idDiplome) {
        return (root, query, criteriaBuilder) -> {
            if (idDiplome == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("posteDiplome"), idDiplome);
        };
    }

    public static Specification<PosteDetails> withSecteur(Integer secteur) {
        return (root, query, criteriaBuilder) -> {
            if (secteur == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("idSecteur"), secteur);
        };
    }

    public static Specification<PosteDetails> withCompetence(Long competence) {
        return (root, query, criteriaBuilder) -> {
            if (competence == null ) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("idCompetence"), "%" + competence + "%");
        };
    }

    public static Specification<PosteDetails> withAgeRange(Integer ageMin, Integer ageMax) {
        return (root, query, criteriaBuilder) -> {
            if (ageMin == null && ageMax == null) {
                return criteriaBuilder.conjunction();
            }
            if (ageMin != null && ageMax != null) {
                return criteriaBuilder.between(root.get("posteAgeMin"), ageMin, ageMax);
            }
            if (ageMin != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("posteAgeMin"), ageMin);
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("posteAgeMax"), ageMax);
        };
    }

    public static Specification<PosteDetails> withSalaireRange(Double salaireMin, Double salaireMax) {
        return (root, query, criteriaBuilder) -> {
            if (salaireMin == null && salaireMax == null) {
                return criteriaBuilder.conjunction();
            }
            if (salaireMin != null && salaireMax != null) {
                return criteriaBuilder.between(root.get("posteSalaire"), salaireMin, salaireMax);
            }
            if (salaireMin != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("posteSalaire"), salaireMin);
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("posteSalaire"), salaireMax);
        };
    }

    public static Specification<PosteDetails> withDistance(Integer distance) {
        return (root, query, criteriaBuilder) -> {
            if (distance == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("distance"), distance);
        };
    }

    public static Specification<PosteDetails> withAnneeExperience(Integer anneeExperience) {
        return (root, query, criteriaBuilder) -> {
            if (anneeExperience == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("nbrAnneeExperience"), anneeExperience);
        };
    }
}
