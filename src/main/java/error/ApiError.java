//package error;
//
//import java.sql.Date;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.example.ecom_proj.model.ErrorMessage;
//
//@ControllerAdvice
//public class ApiError extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
//       String errorMessage = ex.getLocalizedMessage();
//       if (errorMessage == null) errorMessage = ex.toString();
//       
//       ErrorMessage errorMes = new ErrorMessage(new Date(0), errorMessage);
//      
//       return new ResponseEntity<>(errorMes, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR)
//    }
//
//    
//}
