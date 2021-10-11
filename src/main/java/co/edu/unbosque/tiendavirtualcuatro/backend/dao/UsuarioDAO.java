/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
  /**
	 * Consultar la lista de Usuarios
	 * @return
	 */
	public ArrayList<Usuario> listaDeUsuarios() {
	  ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    
	    int cedula_usuario = Integer.parseInt(res.getString("cedula_usuario"));
	    String usuario= res.getString("usuario");
	    String nombre_usuario = res.getString("nombre_usuario");
	    String email_usuario = res.getString("email_usuario");
	    String usuario_password = res.getString("usuario_password");
	    String rol= res.getString("rol");
	    Usuario persona= new Usuario(cedula_usuario, usuario, nombre_usuario, email_usuario, usuario_password, rol);
	    misUsuarios.add(persona);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		  System.out.println("No se pudo consultar la persona\n"+e);	
	  }
	  return misUsuarios; 
	 }
}
