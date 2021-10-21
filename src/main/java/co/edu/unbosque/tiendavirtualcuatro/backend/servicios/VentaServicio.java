/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.servicios;

import java.util.HashSet;
import java.util.List;

import java.util.Set;
import org.springframework.stereotype.Service;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.DetalleVentaDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.VentaDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.DetalleVenta;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Venta;

/**
 * @author Administrator
 *
 */
@Service
public class VentaServicio {

  private VentaDAO ventaDAO;

  private DetalleVentaDAO detalleVentaDAO;

  private DetalleVentaServicio detalleVentaServicio;

  /**
   * @param ventaDAO
   * @param detalleVentaDAO
   * @param detalleVentaServicio
   */
  public VentaServicio(VentaDAO ventaDAO, DetalleVentaDAO detalleVentaDAO,
      DetalleVentaServicio detalleVentaServicio) {
    super();
    this.ventaDAO = ventaDAO;
    this.detalleVentaDAO = detalleVentaDAO;
    this.detalleVentaServicio = detalleVentaServicio;
  }

  public List<Venta> getVentas() {
    return this.ventaDAO.findAll();
  }

  public Venta guardarVenta(Venta venta) {

    Set<DetalleVenta> detalles = venta.getDetalleVentas();
    venta.setDetalleVentas(new HashSet<DetalleVenta>());

    Venta ventaCreada = this.ventaDAO.save(venta);

    for (DetalleVenta detalleVenta : detalles) {
      detalleVenta.setCodigoVenta(ventaCreada.getCodigo());
      detalleVenta = this.detalleVentaServicio.calcularValores(detalleVenta);
      this.detalleVentaDAO.save(detalleVenta);
    }

    return this.ventaDAO.getById(ventaCreada.getCodigo());
  }
}
