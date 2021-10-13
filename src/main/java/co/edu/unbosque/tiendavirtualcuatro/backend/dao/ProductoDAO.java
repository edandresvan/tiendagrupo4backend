/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;

/**
 * Representa el objeto de acceso a datos (DAO) para los productos.
 * 
 * @author
 */
public interface ProductoDAO extends JpaRepository<Producto, Long> {
  List<Producto> findAllByCodigo(long codigo);
}
