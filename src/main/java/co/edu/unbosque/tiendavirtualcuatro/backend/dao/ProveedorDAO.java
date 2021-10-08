package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;

public interface ProveedorDAO extends JpaRepository<Proveedor, Long> {
  List<Proveedor> findAllByNit(long nit);
  
  @Transactional
  void removeByNit(long nit);
}
