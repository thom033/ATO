package itu.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT * FROM Notification WHERE id_utilisateur = :id_utilisateur ORDER BY date_notification DESC")
    List<Notification> getNotifByUtilisateur(String id_utilisateur);

}
