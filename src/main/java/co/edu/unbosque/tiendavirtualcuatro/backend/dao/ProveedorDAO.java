package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;

/**
 * Representa el objeto de acceso a datos (DAO) para los proveedores.
 * 
 * @author
 */
public interface ProveedorDAO extends JpaRepository<Proveedor, Long> {

  /**
   * Encuentra todos los proveedores que tengan el NIT especificado.
   * 
   * @param nit NIT del proveedor que se quiere buscar.
   * @return Lista de todos los proveedores que tenga el NIT especificado.
   */
  List<Proveedor> findAllByNit(long nit);

  /**
   * Elimnina el proveedor que tenga el NIT especificado.
   * 
   * @param nit NIT del proveedor que se quiere eliminar.
   */
  @Transactional
  void removeByNit(long nit);
}
