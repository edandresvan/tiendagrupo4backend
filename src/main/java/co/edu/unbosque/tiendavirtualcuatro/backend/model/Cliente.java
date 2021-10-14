package co.edu.unbosque.tiendavirtualcuatro.backend.model;

public class Cliente {

  private long cedula;
  private String direccion;
  private String email;
  private String nombre;
  private String telefono;

  public Cliente() {
    super();
  }

  public Cliente(long cedula, String direccion, String email,
      String nombre, String telefono) {
    super();
    this.cedula = cedula;
    this.direccion = direccion;
    this.email = email;
    this.nombre = nombre;
    this.telefono = telefono;
  }

  public long getCedula() {
    return cedula;
  }

  public void setCedula(long cedula) {
    this.cedula = cedula;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  @Override
  public String toString() {
    return "Cliente [cedula_cliente=" + cedula + ", direccion_cliente="
        + direccion
        + ", email_cliente=" + email + ", nombre_cliente=" + nombre
        + ", telefono_cliente="
        + telefono + "]";
  }

}
