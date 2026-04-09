package nsim.coding.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nsim.coding.boutique.models.Boutique;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {

}
