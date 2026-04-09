package nsim.coding.boutique.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import nsim.coding.boutique.models.Approvisionnement;
import nsim.coding.boutique.models.Boutique;

public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Long> {

    /**
     * @param boutique
     * @return
     */
    // @Query("SELECT a FROM Approvisionnement a WHERE a.boutique = :boutique")
    public Page<Approvisionnement> findByBoutique(@Param("boutique") Boutique boutique, Pageable p);
}
