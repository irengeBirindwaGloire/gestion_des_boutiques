package nsim.coding.boutique.models;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nsim.coding.boutique.enums.EtatBoutique;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="boutiques")
public class Boutique {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La désignation de la boutique est obligatoire")
    private String designation;
    @NotNull(message = "Le nom du propriétaire de la boutique est obligatoire")
    private String nomProprietaire;
    @NotNull(message = "L'adresse de la boutique est obligatoire")
    private String adresse;
    @NotNull(message = "La ville de la boutique est obligatoire")   
    private String ville;
    @NotNull(message = "Le code postal de la boutique est obligatoire")
    private String codePostal;
    @NotNull(message = "Le pays de la boutique est obligatoire")
    private String pays;
    @NotNull(message = "L'email de la boutique est obligatoire")
    private String email;
    @NotNull(message = "Le numéro de téléphone de la boutique est obligatoire")
    private String telephone;
    @NotNull(message = "L'horaire d'ouverture de la boutique est obligatoire")
    private String horaireOuverture; // ex: "09:00"
    @NotNull(message = "L'horaire de fermeture de la boutique est obligatoire")
    private String horaireFermeture; // ex: "18:00"
    @NotNull(message = "L'état de la boutique est obligatoire")
    private EtatBoutique etatBoutique;
    @NotNull(message = "Le taux de TVA configuré pour la boutique est obligatoire")
    private BigDecimal configTva;

    @OneToMany(mappedBy = "boutique")
    @Builder.Default
    private List<Produit> produits = new ArrayList<>();

    @OneToMany(mappedBy = "boutique")
    @Builder.Default
    private List<Approvisionnement> approvisionnements = new ArrayList<>();
}
