package nsim.coding.boutique.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nsim.coding.boutique.enums.EtatBoutique;
import nsim.coding.boutique.models.Boutique;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoutiqueDto {

    private Long id;

    private String designation;

    private String nomProprietaire;

    private String adresse;

    private String ville;

    private String codePostal;

    private String pays;

    private String email;

    private String telephone;

    private String horaireOuverture; // ex: "09:00"

    private String horaireFermeture; // ex: "18:00"

    private EtatBoutique etatBoutique;

    private BigDecimal configTva;

    public static BoutiqueDto fromEntity(Boutique boutique) {
        if (boutique == null) {
            return null;
        }
        
        return BoutiqueDto.builder()
                .id(boutique.getId())
                .designation(boutique.getDesignation())
                .nomProprietaire(boutique.getNomProprietaire())
                .adresse(boutique.getAdresse())
                .ville(boutique.getVille())
                .codePostal(boutique.getCodePostal())
                .pays(boutique.getPays())
                .email(boutique.getEmail())
                .telephone(boutique.getTelephone())
                .horaireOuverture(boutique.getHoraireOuverture())
                .horaireFermeture(boutique.getHoraireFermeture())
                .etatBoutique(boutique.getEtatBoutique())
                .configTva(boutique.getConfigTva())
                .build();
    }

    public static Boutique toEntity(BoutiqueDto boutiqueDto) {
        if (boutiqueDto == null) {
            return null;
        }
        return Boutique.builder()
                .id(boutiqueDto.getId())
                .designation(boutiqueDto.getDesignation())
                .nomProprietaire(boutiqueDto.getNomProprietaire())
                .adresse(boutiqueDto.getAdresse())
                .ville(boutiqueDto.getVille())
                .codePostal(boutiqueDto.getCodePostal())
                .pays(boutiqueDto.getPays())
                .email(boutiqueDto.getEmail())
                .telephone(boutiqueDto.getTelephone())
                .horaireOuverture(boutiqueDto.getHoraireOuverture())
                .horaireFermeture(boutiqueDto.getHoraireFermeture())
                .etatBoutique(boutiqueDto.getEtatBoutique())
                .configTva(boutiqueDto.getConfigTva())
                .build();
    }
}
