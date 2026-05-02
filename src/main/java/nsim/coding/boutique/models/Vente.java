package nsim.coding.boutique.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventes")
@Builder
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVente;

    @NotNull(message = "La date de la vente ne peut pas être nulle.")
    private LocalDate dateVente;

    @NotNull(message = "Le mode de paiement de la vente ne peut pas être nulle.")
    private String modePaiement;

    @NotNull(message = "Le montant de la vente ne peut pas être nulle.")
    private BigDecimal montantVente;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_boutique")
    private Boutique boutique;

    // L'élément clé : une vente contient plusieurs lignes
    @OneToMany(mappedBy = "vente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneVente> lignesVente = new ArrayList<>();

    // Helper method pour ajouter une ligne et maintenir la cohérence
    public void ajouterLigne(LigneVente ligne) {
        lignesVente.add(ligne);
        ligne.setVente(this);
    }
}
