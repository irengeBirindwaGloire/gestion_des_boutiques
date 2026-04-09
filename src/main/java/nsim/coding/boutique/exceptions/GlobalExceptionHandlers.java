package nsim.coding.boutique.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalExceptionHandlers extends RuntimeException {

    @ModelAttribute("error")
    public void addErrorAttribute(Model model) {
        model.addAttribute("appMessage", "Comptabilite Boutique.");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFoundException(EntityNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("code", ex.getErrorCode() != null ? ex.getErrorCode().getCode() : "N/A");
        model.addAttribute("status", 404);
        return "exceptions/error-not-found";
    }

    @ExceptionHandler(InvalidEntityException.class)
    public String handleInvalidEntityException(InvalidEntityException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("code", ex.getErrorCode() != null && !ex.getErrorCode().isEmpty() ? ex.getErrorCode().get(0).getCode() : "N/A");
        model.addAttribute("status", 400);

        return "exceptions/error-validation";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("message", "Une exception s'est produite : " + ex.getMessage());
        model.addAttribute("status", 500);
        return "exceptions/error-general";
    }
}
