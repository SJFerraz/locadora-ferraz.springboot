package br.com.locadoraferraz.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.locadoraferraz.error.ErrorDetails;
import br.com.locadoraferraz.error.ResourceNotFoundDetails;
import br.com.locadoraferraz.error.ResourceNotFoundException;
import br.com.locadoraferraz.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler {
     @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException){
    	 ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
    	          .newBuilder()
    	          .timestamp(new Date().getTime())
    	          .status(HttpStatus.NOT_FOUND.value())
    	          .title("Resource not found")
    	          .detail(rnfException.getMessage())
    	          .developerMessage(rnfException.getClass().getName())
    	          .build();
    	 return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
     }
     
     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException, 
    		                                                    HttpHeaders headers, 
    		                                                    HttpStatus status, 
    		                                                    WebRequest request) {
    	 //System.out.println("Erros: "+manvException);
    	 List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
    	 String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
    	 String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
    	 ValidationErrorDetails manvDetails = ValidationErrorDetails.Builder
    	          .newBuilder()
    	          .timestamp(new Date().getTime())
    	          .status(HttpStatus.BAD_REQUEST.value())
    	          .title("Field Validation Error")
    	          .detail("Field Validation Error")
    	          .developerMessage(manvException.getClass().getName())
    	          .field(fields)
    	          .fieldMessage(fieldMessages)
    	          .build();
    	 return new ResponseEntity<>(manvDetails, HttpStatus.BAD_REQUEST);
     }
     
     @ExceptionHandler
     public ResponseEntity<Object> handleExceptionInternal(Exception ex, 
    		                                               @Nullable Object body, 
    		                                               HttpHeaders headers, 
    		                                               HttpStatus status, 
    		                                               WebRequest request) {
    	 ErrorDetails errorDetails = ErrorDetails.Builder
    	          .newBuilder()
    	          .timestamp(new Date().getTime())
    	          .status(status.value())
    	          .title("Internal Exception")
    	          .detail(ex.getMessage())
    	          .developerMessage(ex.getClass().getName())
    	          .build();
    	 return new ResponseEntity<>(errorDetails,headers,status);
     }
}
