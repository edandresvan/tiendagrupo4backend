/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
	
	public Usuario consultarUsuario(int cedulausr) {
		Conexion conn =  new Conexion();
		Usuario usuarioEnc = null;
		PreparedStatement ps = null;
		Usuario usuarioRet = null;
		
		String sql = "SELECT * FROM tiendavirtualgrupo4.usuarios uc WHERE uc.cedula_usuario = ?";
		
		try {
			ps =  conn.getConnection().prepareStatement(sql);
			ps.setInt(1, cedulausr);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				Integer cedula_usuario = rs.getInt(1);
				String email_usuario =  rs.getString(2);
				String nombre_usuario =  rs.getString(3);
				String password =  rs.getString(4);
				String usuario = rs.getString(5);
				String rol = rs.getString(6);
				usuarioEnc =  new Usuario(cedula_usuario, email_usuario, nombre_usuario, password, usuario, rol);
			}
			
			if(usuarioEnc.getCedula() == cedulausr) {
				usuarioRet = usuarioEnc;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioRet;
	}
	
	public Usuario actualizarUsuarios(Usuario usuario) 
	 {
	  Conexion conex= new Conexion();
	  try { 
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("Update usuarios VALUES ('"+usuario.getCedula());
	   estatuto.executeUpdate(null);
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
		  usuario = null;
	            System.out.println(e.getMessage());
	  }
	  return usuario;
	 }	
}
