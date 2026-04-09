package nsim.coding.boutique.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidEntityException extends RuntimeException {

    private List<ErrorCodes> errorCode;

    public InvalidEntityException(String message) {
        super(message); 
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, List<ErrorCodes> errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, Throwable cause, List<ErrorCodes> errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
