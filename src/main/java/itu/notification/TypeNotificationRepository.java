package itu.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeNotificationRepository extends JpaRepository<TypeNotification, Long> {

    // @Query("SELECT t FROM typeNotification t JOIN Notification as n
    // "ON n.id_type_notification = t.id_type_notification
    // "WHERE id_notification = :idNotification")
    // List<Notification> getTypeNotifByNotif(String idNotification);
}
