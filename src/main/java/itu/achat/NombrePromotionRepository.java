package itu.achat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NombrePromotionRepository extends JpaRepository<NombrePromotion,Long> {
    @Query(value="select * from nombre_promotion where date_changement<CURRENT_DATE order by id_nombre_promotion desc limit 1",nativeQuery=true)
    NombrePromotion getPromotionActuel();
}
