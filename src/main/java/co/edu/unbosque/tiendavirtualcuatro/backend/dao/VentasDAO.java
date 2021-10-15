package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Ventas;

public class VentasDAO {
	
	public ArrayList<Ventas> listaDeVentas() {
		  ArrayList<Ventas> misVentas = new ArrayList<Ventas>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    
		    long codigo_venta = Long.parseLong(res.getString("codigo_venta"));
		    int cedula_cliente= Integer.parseInt(res.getString("cedula_cliente"));
		    int cedula_usuario = Integer.parseInt(res.getString("cedula_usuario"));
		    double total_venta = Double.parseDouble(res.getString("total_venta"));
		    double iva_venta = Double.parseDouble(res.getString("iva_venta"));
		    double valor_venta = Double.parseDouble(res.getString("valor_venta"));
		    
		    
		    Ventas venta= new Ventas(codigo_venta, cedula_cliente, cedula_usuario, total_venta, iva_venta,valor_venta);
		    misVentas.add(venta);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
			  System.out.println("No se pudo consultar la persona\n"+e);	
		  }
		  return misVentas; 
		 }
	
	  public Producto consultarProducto(int codigo) {
			Conexion conn =  new Conexion();
			Producto productoEnc = null;
			PreparedStatement ps = null;
			Producto productoRet = null;
			
			String sql = "SELECT * FROM productos WHERE codigo_producto = ?";
			
			try {
				ps =  conn.getConnection().prepareStatement(sql);
				ps.setInt(1, codigo);
				ResultSet rs =  ps.executeQuery();
				while(rs.next()) {
				  long codigo_producto= rs.getLong("codigo_producto");
			      String nombre_producto = rs.getString("nombre_producto");				  
				    double precio_compra = Double.parseDouble(rs.getString("precio_compra"));
				    double precio_venta = Double.parseDouble(rs.getString("iva_venta"));
				    double iva_compra = Double.parseDouble(rs.getString("valor_venta"));
					  long nit_proveedor= rs.getLong("nit_proveedor");
					  
					productoEnc = new Producto(codigo_producto, nombre_producto, precio_compra, precio_venta, iva_compra, nit_proveedor);
				}
				
				if(productoEnc.getCodigo() == codigo) {
					productoRet = productoEnc;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return productoRet;
	  }		
	
} 
