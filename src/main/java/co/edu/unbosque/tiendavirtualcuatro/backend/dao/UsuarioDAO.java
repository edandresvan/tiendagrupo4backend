/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Usuario;

/**
 * @author
 *
 */
public class UsuarioDAO {

  /**
   * Registrar Usuarios
   * 
   * @return
   */
  public Usuario registrarUsuario(Usuario persona) {
    Conexion conex = new Conexion();
    try {
      String sql = "INSERT INTO usuarios (cedula_usuario, usuario, nombre_usuario, email_usuario, usuario_password, rol) VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement ps = conex.getConnection()
                                  .prepareStatement(sql);

      ps.setString(1, String.valueOf(persona.getCedula()));
      ps.setString(2, persona.getUsuario());
      ps.setString(3, persona.getNombre());
      ps.setString(4, persona.getEmail());
      ps.setString(5, persona.getPassword());
      ps.setString(6, persona.getRol());

      ps.executeUpdate();

      ps.close();
      conex.desconectar();

    } catch (SQLException e) {
      persona = null;
      System.out.println(e.getMessage());
    }
    return persona;
  }
}
