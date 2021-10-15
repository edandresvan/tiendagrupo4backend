package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Usuario;


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

	      ps.setString(1, String.valueOf(persona.getCedula()));
	      ps.setString(2, persona.getDireccion());
	      ps.setString(3, persona.getEmail());
	      ps.setString(4, persona.getNombre());
	      ps.setString(5, persona.getTelefono());

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
	   * Consultar Cliente por Cedula
	   * 
	   * @return
	   */
	  
		public ArrayList<Cliente> listaDeClientes() {
			  ArrayList<Cliente> misClientes = new ArrayList<Cliente>();
			  Conexion conex= new Conexion();
			    
			  try {
			   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
			   ResultSet res = consulta.executeQuery();
			   while(res.next()){
			    
			    int cedula_cliente = Integer.parseInt(res.getString("cedula_cliente"));
			    String nombre= res.getString("nombre_cliente");
			    String direccion = res.getString("direccion_cliente");
			    String email = res.getString("email_cliente");
			    String telefono = res.getString("telefono_cliente");
			    Cliente persona= new Cliente(cedula_cliente, nombre, direccion, email, telefono);
			    misClientes.add(persona);
			          }
			          res.close();
			          consulta.close();
			          conex.desconectar();
			   
			  } catch (Exception e) {
			   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
				  System.out.println("No se pudo consultar la persona\n"+e);	
			  }
			  return misClientes; 
			 }	  
	  
	  
	  public Cliente consultarCliente(int cedulausr) {
			Conexion conn =  new Conexion();
			Cliente clienteEnc = null;
			PreparedStatement ps = null;
			Cliente clienteRet = null;
			
			String sql = "SELECT * FROM clientes WHERE cedula_cliente = ?";
			
			try {
				ps =  conn.getConnection().prepareStatement(sql);
				ps.setInt(1, cedulausr);
				ResultSet rs =  ps.executeQuery();
				while(rs.next()) {
				  long cedula_cliente= rs.getLong("cedula_cliente");
				  String nombre_cliente= rs.getString("nombre_cliente");
		      String direccion_cliente = rs.getString("direccion_cliente");
		      String telefono_cliente = rs.getString("telefono_cliente");

					clienteEnc = new Cliente(cedula_cliente, nombre_cliente, direccion_cliente, telefono_cliente, telefono_cliente);
				}
				
				if(clienteEnc.getCedula() == cedulausr) {
					clienteRet = clienteEnc;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clienteRet;
	  }	
	  /**
	   * Actualizar Cliente
	   * 
	   * @return
	   */
	  public Cliente actualizarCliente(Cliente cliente) 
		 {
		  Conexion conex= new Conexion();
		  try { 
		   //Statement estatuto = conex.getConnection().createStatement();
		   String sql = "UPDATE `clientes` SET `nombre_cliente` = ?, `direccion_cliente` = ?, `email_cliente` = ?, `telefono_cliente` = ? WHERE (`cedula_cliente` = ?);"
		   		+ "";		  
		      PreparedStatement ps = conex.getConnection()
	                  .prepareStatement(sql);	
		      ps.setString(5, String.valueOf(cliente.getCedula()));
		      ps.setString(1, cliente.getNombre());
		      ps.setString(2, cliente.getDireccion());
		      ps.setString(3, cliente.getEmail());
		      ps.setString(4, cliente.getTelefono());	      
		   //estatuto.executeUpdate("Update clientes VALUES ('"+usuario.get);
		   //estatuto.executeUpdate(null);
		   //estatuto.close();
		      ps.executeUpdate();
		      ps.close(); 
		   conex.desconectar();
		   
		  } catch (SQLException e) {
			  cliente = null;
		            System.out.println(e.getMessage());
		  }
		  return cliente;
		 }
	  /**
	   * Borrar Cliente
	   * 
	   * @return
	   */
	  public void borrarCliente(int cedulausr) {
			Conexion conn =  new Conexion();
			
			PreparedStatement ps = null;		
			
			String sql = "DELETE FROM clientes WHERE cedula_cliente = ?";
			
			try {
				ps =  conn.getConnection().prepareStatement(sql);
				ps.setInt(1, cedulausr);
				int rs = ps.executeUpdate();	

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
}
