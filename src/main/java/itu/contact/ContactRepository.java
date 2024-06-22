package itu.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    @Query("select c from Contact c where c.numTelephone= :contact")
    public List<Contact> getContact(String contact);
}
