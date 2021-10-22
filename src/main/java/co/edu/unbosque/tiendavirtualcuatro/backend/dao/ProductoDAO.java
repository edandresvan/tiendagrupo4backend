/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import co.edu.unbosque.tiendavirtualcuatro.backend.dto.TotalVentaPorClienteDTO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;

/**
 * Representa el objeto de acceso a datos (DAO) para los productos.
 * 
 * @author
 */
public interface ProductoDAO extends JpaRepository<Producto, Long> {

  /**
   * Encuentra todos los productos que tengan el código especificado.
   * 
   * @param codigo Código del producto que se desea buscar.
   * @return Lista de todos los productos que tengan el código especificado.
   */
  List<Producto> findAllByCodigo(long codigo);
  
  
  
  @Modifying
  @Query("delete from Producto where codigo_producto not between 450 and 499")
  @Transactional
  void borrarTodosPreservarPruebas();
  
}
