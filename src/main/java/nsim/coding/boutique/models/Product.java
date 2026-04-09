package nsim.coding.boutique.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "produits")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le nom du produit est obligatoire")
    private String nom;

    @NotNull(message = "La description du produit est obligatoire") 
    private String description;

    @NotNull(message = "Le prix du produit est obligatoire")
    private BigDecimal prix;

    @NotNull(message = "La TVA du produit est obligatoire")
    private BigDecimal tva;

    @NotNull(message = "L'URL de l'image du produit est obligatoire")
    private String imageUrl;
    
    @NotNull(message = "Le code à barres du produit est obligatoire")
    private String codeBarre;

    @ManyToOne(fetch = FetchType.EAGER, optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "boutique_id")
    private Boutique boutique;

    @ManyToOne(fetch = FetchType.EAGER, optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    private List<Approvisionnement> approvisionnements;
}
