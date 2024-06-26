package itu.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import itu.utilisateur.Utilisateur;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUtilisateurId(Long idUtilisateur);
    List<Notification> findByUtilisateurIdAndPointTrue(Long utilisateurId);
    List<Notification> findByUtilisateurIdAndEntretienNotNullAndAndReussiteIsNull(Long utilisateurId);
    List<Notification> findByUtilisateurIdAndPosteNotNull(Long utilisateurId);
    List<Notification> findByUtilisateurIdAndReussiteNotNull(Long utilisateurId);

}
