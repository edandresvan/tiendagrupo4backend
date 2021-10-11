package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;


public class ClienteDAO {
	
	/**
	   * Registrar Usuarios
	   * 
	   * @return
	   */
	  public Cliente registrarCliente(Cliente persona) {
	    Conexion conex = new Conexion();
	    try {
	      String sql = "INSERT INTO clientes (cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente) VALUES (?, ?, ?, ?, ?)";
	      PreparedStatement ps = conex.getConnection()
	                                  .prepareStatement(sql);

	      ps.setString(1, String.valueOf(persona.getCedula_cliente()));
	      ps.setString(2, persona.getDireccion_cliente());
	      ps.setString(3, persona.getEmail_cliente());
	      ps.setString(4, persona.getNombre_cliente());
	      ps.setLong(5, persona.getTelefono_cliente());

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
