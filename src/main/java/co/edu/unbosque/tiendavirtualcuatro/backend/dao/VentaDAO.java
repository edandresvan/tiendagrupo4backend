package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Venta;

public interface VentaDAO extends JpaRepository<Venta, Long> {	
	
} 
