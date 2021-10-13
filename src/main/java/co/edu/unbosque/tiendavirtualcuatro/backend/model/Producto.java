package co.edu.unbosque.tiendavirtualcuatro.backend.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ProductoDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ProveedorDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "productos")
public class Producto {

  /**
   * Código del producto.
   */
  @Id
  @Column(name = "codigo_producto", nullable = false, unique = true)
  @DecimalMin(value = "0", inclusive = false, message = "El código de producto debe ser mayor a cero.")
  private long codigo;

  /**
   * Nombre del producto.
   */
  @Column(name = "nombre_producto", nullable = false, unique = true)
  @NotBlank(message = "Nombre del producto no puede ser vacío.")
  private String nombre;

  /**
   * Precio de compra del producto.
   */
  @Column(name = "precio_compra", nullable = false)
  @DecimalMin(value = "0.0", inclusive = false, message = "El precio de compra debe ser mayor a cero.")
  private double precioCompra;

  /**
   * Porcentaje de IVA de compra del producto.
   */
  @Column(name = "iva_compra", nullable = false)
  @DecimalMin(value = "0.0", inclusive = true, message = "El IVA de compra debe ser mayor o igual a cero.")
  private double ivaCompra;

  /**
   * Precio de venta del producto.
   */
  @Column(name = "precio_venta", nullable = false)
  @DecimalMin(value = "0.0", inclusive = false, message = "El precio de venta debe ser mayor a cero.")
  private double precioVenta;

  /**
   * NIT del proveedor de este producto.
   */
  @Column(name = "nit_proveedor", nullable = false)
  @DecimalMin(value = "0", inclusive = false, message = "El NIT del proveedoor debe ser mayor a cero.")
  private long nitProveedor;

  

  /**
   * Crea un nuevo objeto Producto.
   */
  public Producto() {
    super();
  }

  /**
   * Crea un nuevo objeto Producto con los valores especificados.
   * 
   * @param codigo       Código del producto.
   * @param nombre       Nombre del producto.
   * @param precioCompra Precio de compra del producto.
   * @param precioVenta  Precio de venta del producto.
   * @param ivaCompra    Porcentaje de IVA de compra del producto.
   * @param nitProveedor NIT del proveedor del producto.
   */
  public Producto(
      @DecimalMin(value = "0", inclusive = false, message = "El código de producto debe ser mayor a cero.") long codigo,
      @NotBlank(message = "Nombre del producto no puede ser vacío.") String nombre,
      @DecimalMin(value = "0.0", inclusive = false, message = "El precio de compra debe ser mayor a cero.") double precioCompra,
      @DecimalMin(value = "0.0", inclusive = true, message = "El IVA de compra debe ser mayor o igual a cero.") double ivaCompra,
      @DecimalMin(value = "0.0", inclusive = false, message = "El precio de venta debe ser mayor a cero.") double precioVenta,
      @DecimalMin(value = "0", inclusive = false, message = "El NIT del proveedoor debe ser mayor a cero.") long nitProveedor) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.precioCompra = precioCompra;
    this.ivaCompra = ivaCompra;
    this.precioVenta = precioVenta;
    this.nitProveedor = nitProveedor;
  }

  /**
   * Obtiene el código del producto.
   * 
   * @return Código del producto.
   */
  public long getCodigo() {
    return this.codigo;
  }

  /**
   * Establece el código del producto.
   * 
   * @param codigo Código del producto.
   */
  public void setCodigo(long codigo) {
    this.codigo = codigo;
  }

  /**
   * Obtiene el nombre del producto.
   * 
   * @return Nombre del producto.
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Establece el nombre del producto.
   * 
   * @param nombre Nombre del producto.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Obtiene el precio de compra del producto.
   * 
   * @return precioCompra Precio de compra del producto.
   */
  public double getPrecioCompra() {
    return this.precioCompra;
  }

  /**
   * Establece el precio de compra del producto.
   * 
   * @param precioCompra Precio de compra del producto.
   */
  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  /**
   * Obtiene el porcentaje de IVA de compra del producto.
   * 
   * @return ivaCompra Porcentaje de IVA de compra del producto.
   */
  public double getIvaCompra() {
    return this.ivaCompra;
  }

  /**
   * Establece el porcentaje de IVA de compra del producto.
   * 
   * @param ivaCompra Porcentaje de IVA de compra del producto.
   */
  public void setIvaCompra(double ivaCompra) {
    this.ivaCompra = ivaCompra;
  }

  /**
   * Obtiene el precio de venta del producto.
   * 
   * @return precioVenta Precio de venta del producto.
   */
  public double getPrecioVenta() {
    return this.precioVenta;
  }

  /**
   * Establece el precio de venta del producto.
   * 
   * @param precioVenta Precio de venta del producto.
   */
  public void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  /**
   * Obtiene el NIT del proveedor del producto.
   * 
   * @return nitProveedor NIT del proveedor del producto.
   */
  public long getNitProveedor() {
    return this.nitProveedor;
  }

  /**
   * Establece el NIT del proveedor del producto.
   * 
   * @param nitProveedor NIT del proveedor del producto.
   */
  public void setNitProveedor(long nitProveedor) {
    this.nitProveedor = nitProveedor;
  }

}
