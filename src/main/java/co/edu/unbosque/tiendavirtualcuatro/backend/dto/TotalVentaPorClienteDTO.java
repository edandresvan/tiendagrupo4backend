package co.edu.unbosque.tiendavirtualcuatro.backend.dto;



/**
 * @author
 *
 */
public class TotalVentaPorClienteDTO {
  private long cedulaCliente;
  private String nombreCliente;
  private double totalVentaCliente;

  /**
   * 
   */
  public TotalVentaPorClienteDTO() {
    super();
  }

  /**
   * @param cedulaCliente
   * @param nombreCliente
   * @param totalVentaCliente
   */
  public TotalVentaPorClienteDTO(long cedulaCliente, String nombreCliente,
      double totalVentaCliente) {
    super();
    this.cedulaCliente = cedulaCliente;
    this.nombreCliente = nombreCliente;
    this.totalVentaCliente = totalVentaCliente;
  }

  /**
   * @return the cedulaCliente
   */
  public long getCedulaCliente() {
    return this.cedulaCliente;
  }

  /**
   * @param cedulaCliente the cedulaCliente to set
   */
  public void setCedulaCliente(long cedulaCliente) {
    this.cedulaCliente = cedulaCliente;
  }

  /**
   * @return the nombreCliente
   */
  public String getNombreCliente() {
    return this.nombreCliente;
  }

  /**
   * @param nombreCliente the nombreCliente to set
   */
  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  /**
   * @return the totalVentaCliente
   */
  public double getTotalVentaCliente() {
    return this.totalVentaCliente;
  }

  /**
   * @param totalVentaCliente the totalVentaCliente to set
   */
  public void setTotalVentaCliente(double totalVentaCliente) {
    this.totalVentaCliente = totalVentaCliente;
  }

}
