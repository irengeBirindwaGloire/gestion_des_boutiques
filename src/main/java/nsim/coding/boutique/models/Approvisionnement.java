package nsim.coding.boutique.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "stocks")
public class Approvisionnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;

    @NotNull(message = "La quantité approvisionnée est obligatoire")    
    private int quantite;
    
    @NotNull(message = "Le seuil de réapprovisionnement est obligatoire")
    private int seuilReapprovisionnement;
             
    @NotNull(message = "La date d'approvisionnement est obligatoire")
    private LocalDate dateApprovisionnement;
       
    @NotNull(message = "Le fournisseur est obligatoire")
    private String fournisseur; 
    
    @NotNull(message = "Le numéro de lot est obligatoire")
    private String numeroLot;
   
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "boutique_id")
    private Boutique boutique;

}
