/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.model;

/**
 * Representa un usuario que realiza operaciones en el sistema.
 * @author 
 *
 */
public class Usuario {
  /**
   * cedula del usuario.
   */
  private long cedula;
  
  /**
   * Nombre de cuenta del usuario.
   */
  private String usuario;
  /**
   * Nombre completo del usuario.
   */
  private String nombre;
  /**
   * Correo electronico del usuario.
   */
  private String email;
  /**
   * Constrasena del usuario.
   */
  private String password;
  
  /**
   * Rol del usuario.
   */
  private String rol;

  /**
   * 
   */
  public Usuario() {
    super();
  }

  /**
   * @param cedula
   * @param usuario
   * @param nombre
   * @param email
   * @param password
   * @param rol
   */
  public Usuario(long cedula, String usuario, String nombre, String email,
      String password, String rol) {
    super();
    this.cedula = cedula;
    this.usuario = usuario;
    this.nombre = nombre;
    this.email = email;
    this.password = password;
    this.rol = rol;
  }

  /**
   * @return the cedula
   */
  public long getCedula() {
    return this.cedula;
  }

  /**
   * @param cedula the cedula to set
   */
  public void setCedula(long cedula) {
    this.cedula = cedula;
  }

  /**
   * @return the usuario
   */
  public String getUsuario() {
    return this.usuario;
  }

  /**
   * @param usuario the usuario to set
   */
  public void setUsuario(String usuario) {
    this.usuario = usuario;
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
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the rol
   */
  public String getRol() {
    return this.rol;
  }

  /**
   * @param rol the rol to set
   */
  public void setRol(String rol) {
    this.rol = rol;
  }
  
  @Override
  public String toString() {
    return "Usuarios [cedula_usuario=" + cedula + ", email_usuario=" + email + ", nombre_usuario="
        + nombre + ", password=" + password + ", usuario=" + usuario +", rol=" + rol + "]";
  }
  
}
