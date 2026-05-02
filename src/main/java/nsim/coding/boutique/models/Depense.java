package nsim.coding.boutique.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "depenses")
@Builder
public class Depense extends FraisOperationnel {

}
