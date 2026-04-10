package nsim.coding.boutique.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nsim.coding.boutique.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findProductByNom(String nom);

    public Product findProductByCodeBarre(String codebarre);

    public Page<Product> findByCategorie(String categorie, Pageable p);

}
