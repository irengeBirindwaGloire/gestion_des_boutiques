package nsim.coding.boutique.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class FraisOperationnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepense;

    @NotEmpty(message = "Le montant de l'opération ne doit pas être vide.")
    private BigDecimal montant;

    @NotEmpty(message = "Le motif de l'opération ne doit pas être vide.")
    private String motif;

    @Column(nullable = false)
    @NotEmpty(message="La date de l'opération ne doit pas être vide.")
    private LocalDate dateDep;

    @NotEmpty(message = "Le type de l'opération ne doit pas être vide.")
    private String typeOperation;

}
