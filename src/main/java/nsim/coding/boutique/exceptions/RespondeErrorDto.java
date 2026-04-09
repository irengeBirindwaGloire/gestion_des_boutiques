package nsim.coding.boutique.exceptions;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespondeErrorDto {

    // DTO class to encapsulate error details for API responses
    private String message;
    private String code;
    private LocalDate date = LocalDate.now();
    private int status;

    public RespondeErrorDto(String message, String code, int status, LocalDate date) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.date = date;
    }

}
