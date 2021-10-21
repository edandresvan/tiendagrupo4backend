/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "detalle_ventas")
public class DetalleVenta {

  @Id
  @Column(name = "codigo_detalle_venta", nullable = false, unique = true)
  private long codigo;
  
  @Column(name = "codigo_venta", nullable = false)
  private long codigoVenta;
  
  @Column(name = "codigo_producto", nullable = false)
  private long codigoProducto;
  
  @Column(name = "cantidad_producto", nullable = false)
  private int cantidadProducto;
  
  @Column(name = "total_venta", nullable = false)
  private double totalVenta;
  
  @Column(name = "valor_iva", nullable = false)
  private double valorIva;
  
  @Column(name = "valor_venta", nullable = false)
  private double valorVenta;

  /**
   * 
   */
  public DetalleVenta() {
    super();
  }

  /**
   * @param codigo
   * @param codigoVenta
   * @param codigoProducto
   * @param cantidadProducto
   * @param totalVenta
   * @param valorIva
   * @param valorVenta
   */
  public DetalleVenta(long codigo, long codigoVenta, long codigoProducto,
      int cantidadProducto, double totalVenta, double valorIva,
      double valorVenta) {
    super();
    this.codigo = codigo;
    this.codigoVenta = codigoVenta;
    this.codigoProducto = codigoProducto;
    this.cantidadProducto = cantidadProducto;
    this.totalVenta = totalVenta;
    this.valorIva = valorIva;
    this.valorVenta = valorVenta;
  }

  /**
   * @return the codigo
   */
  public long getCodigo() {
    return this.codigo;
  }

  /**
   * @param codigo the codigo to set
   */
  public void setCodigo(long codigo) {
    this.codigo = codigo;
  }

  /**
   * @return the codigoVenta
   */
  public long getCodigoVenta() {
    return this.codigoVenta;
  }

  /**
   * @param codigoVenta the codigoVenta to set
   */
  public void setCodigoVenta(long codigoVenta) {
    this.codigoVenta = codigoVenta;
  }

  /**
   * @return the codigoProducto
   */
  public long getCodigoProducto() {
    return this.codigoProducto;
  }

  /**
   * @param codigoProducto the codigoProducto to set
   */
  public void setCodigoProducto(long codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  /**
   * @return the cantidadProducto
   */
  public int getCantidadProducto() {
    return this.cantidadProducto;
  }

  /**
   * @param cantidadProducto the cantidadProducto to set
   */
  public void setCantidadProducto(int cantidadProducto) {
    this.cantidadProducto = cantidadProducto;
  }

  /**
   * @return the totalVenta
   */
  public double getTotalVenta() {
    return this.totalVenta;
  }

  /**
   * @param totalVenta the totalVenta to set
   */
  public void setTotalVenta(double totalVenta) {
    this.totalVenta = totalVenta;
  }

  /**
   * @return the valorIva
   */
  public double getValorIva() {
    return this.valorIva;
  }

  /**
   * @param valorIva the valorIva to set
   */
  public void setValorIva(double valorIva) {
    this.valorIva = valorIva;
  }

  /**
   * @return the valorVenta
   */
  public double getValorVenta() {
    return this.valorVenta;
  }

  /**
   * @param valorVenta the valorVenta to set
   */
  public void setValorVenta(double valorVenta) {
    this.valorVenta = valorVenta;
  }
  
  
}
