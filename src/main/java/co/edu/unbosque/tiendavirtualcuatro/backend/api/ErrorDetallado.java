package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorDetallado {

  private HttpStatus estadoHttp;

  /**
   * @return the estadoHttp
   */
  public HttpStatus getEstadoHttp() {
    return estadoHttp;
  }

  /**
   * @param estadoHttp the estadoHttp to set
   */
  public void setEstadoHttp(HttpStatus estadoHttp) {
    this.estadoHttp = estadoHttp;
  }

  /**
   * @return the mensaje
   */
  public String getMensaje() {
    return mensaje;
  }

  /**
   * @param mensaje the mensaje to set
   */
  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  /**
   * @return the errores
   */
  public List<String> getErrores() {
    return errores;
  }

  /**
   * @param errores the errores to set
   */
  public void setErrores(List<String> errores) {
    this.errores = errores;
  }

  private String mensaje;
  private List<String> errores;

  public ErrorDetallado(HttpStatus estadoHttp, String mensaje, List<String> errores) {
    super();
    this.estadoHttp = estadoHttp;
    this.mensaje = mensaje;
    this.errores = errores;
  }

  public ErrorDetallado(HttpStatus status, String message, String error) {
    super();
    this.estadoHttp = status;
    this.mensaje = message;
    errores = Arrays.asList(error);
  }
}