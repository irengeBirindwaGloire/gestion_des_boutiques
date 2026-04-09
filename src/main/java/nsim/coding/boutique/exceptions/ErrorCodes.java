package nsim.coding.boutique.exceptions;

import lombok.Getter;

@Getter 
public enum ErrorCodes {

    PRODUCT_NOT_FOUND("Product not found", 1001),
    INVALID_PRODUCT_ID("Invalid product ID", 1002),
    DATABASE_ERROR("Database error occurred", 1003),
    UNKNOWN_ERROR("An unknown error occurred", 1004);

    private final String message;
    private final int code;

    ErrorCodes(String message, int code) {
        this.message = message;
        this.code = code;
    }
            
}
