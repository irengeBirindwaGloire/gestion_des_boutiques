package nsim.coding.boutique.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nsim.coding.boutique.models.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;

    private String nom;

    private String description;

    private BigDecimal prix;

    private BigDecimal tva;

    private String imageUrl;

    private String codeBarre;

    private CategorieDto categorie;

    public static ProductDto fromEntity(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setNom(product.getNom());
        productDto.setDescription(product.getDescription());
        productDto.setPrix(product.getPrix());
        productDto.setTva(product.getPrix());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setCodeBarre(product.getCodeBarre());
        productDto.setCategorie(CategorieDto.fromEntity(product.getCategorie()));

        return productDto;
    }

    public static Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product prod = new Product();

        prod.setId(productDto.getId());
        prod.setNom(productDto.getNom());
        prod.setDescription(productDto.getDescription());
        prod.setPrix(productDto.getPrix());
        prod.setTva(productDto.getPrix());
        prod.setImageUrl(productDto.getImageUrl());
        prod.setCodeBarre(productDto.getCodeBarre());
        prod.setCategorie(CategorieDto.toEntity(productDto.getCategorie()));

        return prod;
    }
}
