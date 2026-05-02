package nsim.coding.boutique.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "autres_depenses")
@Builder
public class AutresDepenses extends FraisOperationnel {

}
