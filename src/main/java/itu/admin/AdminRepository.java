package itu.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("select a from Admin a where a.mail= :nomUtilisateur and a.motDePasse= :motpasse")
    List<Admin> getAdmin(@Param("nomUtilisateur") String nomUtilisateur,@Param("motpasse") String motpasse);
}
