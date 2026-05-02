package nsim.coding.boutique.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    @NotNull(message = "Le nom de l'utilisateur ne peut pas être nulle.")
    @Size(min = 4, max = 60, message = "Le nom doit contenir au minim 4 et 60 caractères")
    private String nom;

    @NotNull(message = "Le prénom de l'utilisateur ne peut pas être nulle.")
    @Size(min = 4, max = 60, message = "Le prénom doit contenir au minim 4 et 60 caractères")
    private String prenom;

    @NotNull(message = "Le mot de passe ne peut pas être nulle.")
    @Size(min = 4, max = 10, message = "Le mot de passe doit contenir au minim 4 et 10 caractères")
    private String password;

    @NotBlank(message = "L'email ne doit pas être nulle.")
    @Email(message = "Email invalide")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Format email incorrect"
    )
    private String email;

    @NotNull(message = "Le rôle de l'utilisateur ne peut pas être nulle.")
    @Size(min = 4, max = 40, message = "Le rôle doit contenir au minim 4 et 40 caractères")
    private String role;

    @NotNull(message = "L'état de l'utilisateur ne peut pas être nulle.")
    private Boolean estActif;
}
