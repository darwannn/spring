package error;

import java.util.List;

import com.example.ecom_proj.model.ErrorResponse;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private ErrorResponse error;

    public ApiResponse(boolean success, String message, T data, ErrorResponse error) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.error = error;
    }

    // Getters and Setters

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data, null);
    }

    public static <T> ApiResponse<T> failure(String message, ErrorResponse error) {
        return new ApiResponse<>(false, message, null, error);
    }
}
