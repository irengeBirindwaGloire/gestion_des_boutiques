package nsim.coding.boutique.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nsim.coding.boutique.models.Approvisionnement;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@lombok.Builder
public class ApprovisionnementDto {

    private Long idApp;

    private int quantite;

    private int seuilReapprovisionnement;

    private LocalDate dateApprovisionnement;

    private String fournisseur;

    private String numeroLot;

    private ProductDto produit;

    private BoutiqueDto boutique;

    public static ApprovisionnementDto fromEntity(Approvisionnement approv) {
        if (approv == null) {
            return null;
        }
        ApprovisionnementDto approvDto = new ApprovisionnementDto();

        approvDto.setIdApp(approv.getIdApp());
        approvDto.setQuantite(approv.getQuantite());
        approvDto.setSeuilReapprovisionnement(approv.getSeuilReapprovisionnement());
        approvDto.setDateApprovisionnement(approv.getDateApprovisionnement());
        approvDto.setFournisseur(approv.getFournisseur());
        approvDto.setNumeroLot(approv.getNumeroLot());
        approvDto.setBoutique(BoutiqueDto.fromEntity(approv.getBoutique()));
        approvDto.setProduit(ProductDto.fromEntity(approv.getProduit()));

        return approvDto;

    }

    public static Approvisionnement toEntity(ApprovisionnementDto approvDto) {
        if (approvDto == null) {
            return null;
        }
        Approvisionnement approv = new Approvisionnement();

        approv.setIdApp(approvDto.getIdApp());
        approv.setQuantite(approvDto.getQuantite());
        approv.setSeuilReapprovisionnement(approvDto.getSeuilReapprovisionnement());
        approv.setDateApprovisionnement(approvDto.getDateApprovisionnement());
        approv.setFournisseur(approvDto.getFournisseur());
        approv.setNumeroLot(approvDto.getNumeroLot());
        approv.setBoutique(BoutiqueDto.toEntity(approvDto.getBoutique()));
        approv.setProduit(ProductDto.toEntity(approvDto.getProduit()));

        return approv;

    }
}
