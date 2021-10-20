package co.edu.unbosque.tiendavirtualcuatro.backend.servicios;

import java.util.List;



import org.springframework.stereotype.Service;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ProveedorDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;

/**
 * Representa un servicio para interactuar con las capas de modelo y de DAO de 
 * los proveedores.
 * @author 
 */
/**
 * @author Administrator
 *
 */
@Service
public class ProveedorServicio {

  /**
   * Objeto DAO para manejar provedores en la base de datos.
   */
  private ProveedorDAO proveedorDAO;

  /**
   * Crea un servicio para gestionar los proveedores.
   * @param proveedorDAO Objeto DAO para manejar provedores en la base de datos.
   */
  public ProveedorServicio(ProveedorDAO proveedorDAO) {
    this.proveedorDAO = proveedorDAO;
  }

  
  /**
   * Obtiene la lista de proveedores.
   * @return Lista de proveedores.
   */
  public List<Proveedor> getProveedores() {
    return this.proveedorDAO.findAll();
  }

  /**
   * Obtiene la lista de proveedores que tenga el NIT especificado.
   * @param nit NIT del proveedor que se quiere buscar.
   * @return Lista de proveedores que tenga el NIT especificado.
   */
  public List<Proveedor> getProveedoresPorNit(long nit) {
    return this.proveedorDAO.findAllByNit(nit);
  }

  /**
   * Agrega el proveedor especificado a la base de datos.
   * @param proveedor Proveedor que quiere agregar a la base de datos.
   * @return Un objeto proveedor si la inserción fue existosa.
   */
  public Proveedor agregarProveedor(Proveedor proveedor) {
    return this.proveedorDAO.save(proveedor);
  }

  
  /**
   * Edita el proveedor especificado a la base de datos.
   * @param proveedor Proveedor que se quiere editar en la base de datos.
   * @return Un objeto proveedor si la edición fue existosa. 
   */
  public Proveedor editarProveedor(Proveedor proveedor) {
    return this.proveedorDAO.save(proveedor);
  }

  /**
   * Elimina el proveedor especificado en la base de datos.
   * @param nit NIT del proveedor que se quiere eliminar en la base de datos.
   */
  public void eliminarProveedorPorNit(long nit) {
    this.proveedorDAO.removeByNit(nit);
  }
}
