package nsim.coding.boutique.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.ProductDto;

@Service
public interface ProductService {

    public ProductDto createProduct(ProductDto productDto);

    public ProductDto updateProduct(ProductDto productDto);

    public void deleteProduct(Long id);

    public Page<ProductDto> getAllProducts(int page, int size);

    public Page<ProductDto> getProductByCategorie(String categorie, int page, int size);

    public ProductDto getProductByNom(String nom);

    public ProductDto getProductByCodeBarre(String codebarre);

}
