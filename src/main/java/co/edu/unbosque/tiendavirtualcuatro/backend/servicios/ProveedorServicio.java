package co.edu.unbosque.tiendavirtualcuatro.backend.servicios;

import java.util.List;



import org.springframework.stereotype.Service;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ProveedorDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;

@Service
public class ProveedorServicio {

  private ProveedorDAO proveedorDAO;

  public ProveedorServicio(ProveedorDAO proveedorDAO) {
    this.proveedorDAO = proveedorDAO;
  }

  public List<Proveedor> getProveedores() {
    return this.proveedorDAO.findAll();
  }

  public List<Proveedor> getProveedoresPorNit(long nit) {
    return this.proveedorDAO.findAllByNit(nit);
  }

  public Proveedor agregarProveedor(Proveedor proveedor) {
    return this.proveedorDAO.save(proveedor);
  }
  
  public Proveedor editarProveedor(Proveedor proveedor) {
    return this.proveedorDAO.save(proveedor);
  }
  
  public void eliminarProveedorPorNit(long nit) {
    this.proveedorDAO.removeByNit(nit);
  }
}
