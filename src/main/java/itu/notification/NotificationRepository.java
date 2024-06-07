package itu.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE utilisateur= :idUtilisateur ORDER BY dateNotification DESC")
    List<Notification> getNotifByUtilisateur(String idUtilisateur);

}
