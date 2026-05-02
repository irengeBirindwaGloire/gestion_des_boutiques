package nsim.coding.boutique.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lignes_vente")
@Builder
public class LigneVente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneVente;

    private int quantite;
    private BigDecimal prixUnitaire; // Prix figé au moment de la vente

    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Product produit;

    @ManyToOne
    @JoinColumn(name = "id_vente")
    private Vente vente;
}
