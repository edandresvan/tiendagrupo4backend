/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author
 *
 */

@Entity
@Table(name = "proveedores")
public class Proveedor {

  @Id
  @Column(name = "nit_proveedor", nullable = false, unique = true)
  private long nit;

  @NotBlank(message = "Nombre del proveedor no puede ser vacío.")
  @Column(name = "nombre_proveedor", nullable = false, unique = true)
  private String nombre;

  @NotBlank(message = "Dirección del proveedor no puede ser vacío.")
  @Column(name = "direccion_proveedor", nullable = false)
  private String direccion;

  @NotBlank(message = "Ciudad del proveedor no puede ser vacío.")
  @Column(name = "ciudad_proveedor", nullable = false)
  private String ciudad;

  @NotBlank(message = "Teléfono del proveedor no puede ser vacío.")
  @Column(name = "telefono_proveedor", nullable = false)
  private String telefono;

  /**
   * 
   */
  public Proveedor() {
    super();

  }

  /**
   * @param nit
   * @param nombre
   * @param direccion
   * @param ciudad
   * @param telefono
   */
  public Proveedor(long nit, String nombre, String direccion, String ciudad, String telefono) {
    super();
    this.nit = nit;
    this.nombre = nombre;
    this.direccion = direccion;
    this.ciudad = ciudad;
    this.telefono = telefono;
  }

  /**
   * @return the nit
   */
  public long getNit() {
    return this.nit;
  }

  /**
   * @param nit the nit to set
   */
  public void setNit(long nit) {
    this.nit = nit;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return this.direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * @return the ciudad
   */
  public String getCiudad() {
    return this.ciudad;
  }

  /**
   * @param ciudad the ciudad to set
   */
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  /**
   * @return the telefono
   */
  public String getTelefono() {
    return this.telefono;
  }

  /**
   * @param telefono the telefono to set
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
