package nsim.coding.boutique.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.ProductDto;
import nsim.coding.boutique.exceptions.EntityNotFoundException;
import nsim.coding.boutique.exceptions.InvalidEntityException;
import nsim.coding.boutique.repository.ProductRepository;
import nsim.coding.boutique.services.ProductService;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        if (productDto == null) {
            throw new InvalidEntityException("Invalide, Le produit n'est pas valide.");
        }

        return ProductDto.fromEntity(productRepository.save(
                ProductDto.toEntity(productDto)
        ));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        if (productDto == null) {
            throw new InvalidEntityException("Invalide, Le produit n'est pas valide.");
        }
        productRepository.findById(productDto.getId())
                .map(ProductDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun produit n'a été trouver avec l'ID: " + productDto.getId()));

        return ProductDto.fromEntity(productRepository.save(
                ProductDto.toEntity(productDto)
        ));
    }

    @Override
    public void deleteProduct(Long id) {
        if (id == null) {
            throw new InvalidEntityException("L'ID ne doit pas être nulle.");
        }
        productRepository.findById(id)
                .map(ProductDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun produit n'a été trouver avec l'ID: " + id));
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductDto> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size))
                .map(ProductDto::fromEntity);
    }

    @Override
    public Page<ProductDto> getProductByCategorie(String categorie, int page, int size) {
        if (categorie == null) {
            throw new InvalidEntityException("Le code barre ne doit pas être nulle.");
        }
        return productRepository.findByCategorie(categorie, PageRequest.of(page, size))
                .map(ProductDto::fromEntity);
    }

    @Override
    public ProductDto getProductByNom(String nom) {
        if (nom == null) {
            throw new InvalidEntityException("L'ID ne doit pas être nulle.");
        }
        return ProductDto.fromEntity(productRepository.findProductByNom(nom));
    }

    @Override
    public ProductDto getProductByCodeBarre(String codebarre) {
        if (codebarre == null) {
            throw new InvalidEntityException("Le code barre ne doit pas être nulle.");
        }
        return ProductDto.fromEntity(productRepository.findProductByCodeBarre(codebarre));
    }

}
