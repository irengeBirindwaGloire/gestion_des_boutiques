package nsim.coding.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nsim.coding.boutique.models.Product;

@Repository
public interface ProduitRepository extends JpaRepository<Product, Long> {

}
