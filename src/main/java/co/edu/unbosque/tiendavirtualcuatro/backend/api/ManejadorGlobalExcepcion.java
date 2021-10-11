package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
@RestControllerAdvice
public class ManejadorGlobalExcepcion extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    List<String> errores = new ArrayList<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errores.add(error.getField() + ": " + error.getDefaultMessage());
    }
    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
      errores.add(error.getObjectName() + ": " + error.getDefaultMessage());
    }
   
    
    ErrorDetallado errorDetallado = new ErrorDetallado(HttpStatus.BAD_REQUEST, 
      ex.getLocalizedMessage(), errores, ex.getBindingResult().getTarget());
    //errorDetallado.setModelo(ex.getBindingResult().getTarget());
    return handleExceptionInternal(ex, errorDetallado, headers, errorDetallado.getEstadoHttp(), request);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    String error = "Hace falta el parámetro " + ex.getParameterName();

    ErrorDetallado errorDetallado = new ErrorDetallado(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    return new ResponseEntity<>(errorDetallado, new HttpHeaders(), errorDetallado.getEstadoHttp());
  }

  @ExceptionHandler({ ConstraintViolationException.class })
  public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
    List<String> errores = new ArrayList<>();
    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
      errores.add(
          violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
    }

    ErrorDetallado errorDetallado = new ErrorDetallado(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errores);
    return new ResponseEntity<>(errorDetallado, new HttpHeaders(), errorDetallado.getEstadoHttp());
  }

  @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
  public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
      WebRequest request) {
    String error = ex.getName() + " debería ser de tipo" + ex.getRequiredType().getName();

    ErrorDetallado apiError = new ErrorDetallado(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getEstadoHttp());
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    StringBuilder builder = new StringBuilder();
    builder.append("El método");
    builder.append(ex.getMethod());
    builder.append(" no tiene soporte para esta solicitud. Los métodos soportados son: ");
    ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

    ErrorDetallado errorDetallado = new ErrorDetallado(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(),
        builder.toString());
    return new ResponseEntity<>(errorDetallado, new HttpHeaders(), errorDetallado.getEstadoHttp());
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    StringBuilder builder = new StringBuilder();
    builder.append("El tipo de medios ");
    builder.append(ex.getContentType());
    builder.append(" no está soportado. Los tipos de medios soportados son: ");
    ex.getSupportedMediaTypes().forEach(t -> builder.append(t + ", "));

    ErrorDetallado errorDetallado = new ErrorDetallado(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getLocalizedMessage(),
        builder.substring(0, builder.length() - 2));
    return new ResponseEntity<>(errorDetallado, new HttpHeaders(), errorDetallado.getEstadoHttp());
  }

  @ExceptionHandler({ Exception.class })
  public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
    ErrorDetallado errorDetallado = new ErrorDetallado(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(),
        "ocurrió un error: "+ ex.getLocalizedMessage());
    return new ResponseEntity<>(errorDetallado, new HttpHeaders(), errorDetallado.getEstadoHttp());
  }
}
