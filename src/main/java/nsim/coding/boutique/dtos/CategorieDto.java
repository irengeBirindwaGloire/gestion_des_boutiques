package nsim.coding.boutique.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nsim.coding.boutique.models.Categorie;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieDto {

    private Long id;

    private String libelle;

    private String description;

    public static CategorieDto fromEntity(Categorie categorie) {
        if (categorie == null) {
            return null;
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .libelle(categorie.getLibelle())
                .description(categorie.getDescription())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorie) {
        if (categorie == null) {
            return null;
        }

        return Categorie.builder()
        .id(categorie.getId())
                .libelle(categorie.getLibelle())
                .description(categorie.getDescription())
        .build();
    }
}
