package itu.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeNotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT * FROM typeNotification WHERE id_type_notification = :id_type_notification")
    List<Notification> getTypeNotificationById(String id_type_notification);

    @Query("SELECT * FROM typeNotification as t JOIN Notification as n " +
            "ON n.id_type_notification = t.id_type_notification " +
            "WHERE id_notification = :id_notification")
    List<Notification> getTypeNotifByNotif(String id_notification);
}
