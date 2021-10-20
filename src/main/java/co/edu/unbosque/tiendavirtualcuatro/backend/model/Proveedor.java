/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Representa un proveedor que abastece productos a la tienda.
 * @author
 */

@Entity
@Table(name = "proveedores")
public class Proveedor {

  /**
   * Número de Identificación Tributaria del proveedor.
   */
  @Id
  @Column(name = "nit_proveedor", nullable = false, unique = true)
  private long nit;

  /**
   * Nombre del proveedor.
   */
  @NotBlank(message = "Nombre del proveedor no puede ser vacío.")
  @Column(name = "nombre_proveedor", nullable = false, unique = true)
  private String nombre;

  /**
   * Dirección del proveedor.
   */
  @NotBlank(message = "Dirección del proveedor no puede ser vacío.")
  @Column(name = "direccion_proveedor", nullable = false)
  private String direccion;

  /**
   * Ciudad del proveedor.
   */
  @NotBlank(message = "Ciudad del proveedor no puede ser vacío.")
  @Column(name = "ciudad_proveedor", nullable = false)
  private String ciudad;

  /**
   * Número de teléfono del proveedor.
   */
  @NotBlank(message = "Teléfono del proveedor no puede ser vacío.")
  @Column(name = "telefono_proveedor", nullable = false)
  private String telefono;

  /**
   * Crea un nuevo proveedor.
   */
  public Proveedor() {
    super();

  }

  /**
   * Crea un nuevo proveedor con los datos especificados.
   * @param nit Número de Identificación Tributaria del proveedor.
   * @param nombre Nombre del proveedor.
   * @param direccion Dirección del proveedor.
   * @param ciudad Ciudad del proveedor.
   * @param telefono Número de teléfono del proveedor.
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
   * Obtiene el número de Identificación Tributaria del proveedor.
   * @return Número de Identificación Tributaria del proveedor.
   */
  public long getNit() {
    return this.nit;
  }

  /**
   * Establece el número de Identificación Tributaria del proveedor.
   * @param nit Número de Identificación Tributaria del proveedor.
   */
  public void setNit(long nit) {
    this.nit = nit;
  }

  /**
   * Obtiene el nombre del proveedor.
   * @return Nombre del proveedor.
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Establece el nombre del proveedor.
   * @param nombre Nombre del proveedor.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Obtiene la dirección del proveedor.
   * @return Dirección del proveedor.
   */
  public String getDireccion() {
    return this.direccion;
  }

  /**
   * Establece la dirección del proveedor.
   * @param direccion Dirección del proveedor.
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * Obtiene la ciudad del proveedor.
   * @return Ciudad del proveedor.
   */
  public String getCiudad() {
    return this.ciudad;
  }

  /**
   * Establece la ciudad del proveedor
   * @param ciudad Ciudad del proveedor
   */
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  /**
   * Obtiene el número de teléfono del proveedor.
   * @return Número de teléfono del proveedor.
   */
  public String getTelefono() {
    return this.telefono;
  }

  /**
   * Establece el número de teléfono del proveedor.
   * @param telefono Número de teléfono del proveedor.
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
