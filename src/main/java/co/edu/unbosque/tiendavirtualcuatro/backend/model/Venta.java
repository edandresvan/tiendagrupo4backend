package co.edu.unbosque.tiendavirtualcuatro.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

  @Id
  @Column(name = "codigo_venta", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long codigo;

  @Column(name = "cedula_cliente", nullable = false)
  private long cedulaCliente;

  @Column(name = "cedula_usuario", nullable = false)
  private long cedulaUsuario;

  @Column(name = "total_venta", nullable = false)
  private double totalVenta;

  @Column(name = "iva_venta", nullable = false)
  private double ivaVenta;

  @Column(name = "valor_venta", nullable = false)
  private double valorVenta;

  @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private Set<DetalleVenta> detalleVentas = new HashSet<>();

  /**
   * 
   */
  public Venta() {
    super();
  }

  /**
   * @param codigo
   * @param cedulaCliente
   * @param cedulaUsuario
   * @param totalVenta
   * @param ivaVenta
   * @param valorVenta
   * @param detalleVentas
   */
  public Venta(long codigo, long cedulaCliente, long cedulaUsuario,
      double totalVenta, double ivaVenta, double valorVenta,
      Set<DetalleVenta> detalleVentas) {
    super();
    this.codigo = codigo;
    this.cedulaCliente = cedulaCliente;
    this.cedulaUsuario = cedulaUsuario;
    this.totalVenta = totalVenta;
    this.ivaVenta = ivaVenta;
    this.valorVenta = valorVenta;
    this.detalleVentas = detalleVentas;
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
   * @return the cedulaUsuario
   */
  public long getCedulaUsuario() {
    return this.cedulaUsuario;
  }

  /**
   * @param cedulaUsuario the cedulaUsuario to set
   */
  public void setCedulaUsuario(long cedulaUsuario) {
    this.cedulaUsuario = cedulaUsuario;
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
   * @return the ivaVenta
   */
  public double getIvaVenta() {
    return this.ivaVenta;
  }

  /**
   * @param ivaVenta the ivaVenta to set
   */
  public void setIvaVenta(double ivaVenta) {
    this.ivaVenta = ivaVenta;
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

  /**
   * @return the detalleVentas
   */
  public Set<DetalleVenta> getDetalleVentas() {
    return this.detalleVentas;
  }

  /**
   * @param detalleVentas the detalleVentas to set
   */
  public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
    this.detalleVentas = detalleVentas;
  }

  
}