/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.DetalleVentaDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ProductoDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.DetalleVenta;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;

/**
 * @author Administrator
 *
 */
@Service
public class DetalleVentaServicio {
  private ProductoDAO productoDAO;
  private DetalleVentaDAO detalleVentaDAO;

  public DetalleVentaServicio(DetalleVentaDAO detalleVentaDAO,
      ProductoDAO productoDAO) {
    this.detalleVentaDAO = detalleVentaDAO;
    this.productoDAO = productoDAO;
  }

  public List<DetalleVenta> getDetallesVentas() {
    return this.detalleVentaDAO.findAll();
  }

  public DetalleVenta calcularValores(DetalleVenta detalleVenta) {
    // valor_total = precio_unitario * cantidad
    Producto producto = this.productoDAO
      .findById(detalleVenta.getCodigoProducto())
      .get();

    double totalVenta = producto.getPrecioVenta()
        * detalleVenta.getCantidadProducto();
    detalleVenta.setTotalVenta(totalVenta);

    // valor_iva = precio_unitario * (iva/100) * cantidad

    double valorIva = producto.getPrecioVenta()
        * ( producto.getIvaCompra() / 100 )
        * detalleVenta.getCantidadProducto();
    detalleVenta.setValorIva(valorIva);
    
    // valor_venta = valor_total + valor_iva
    double valorVenta = totalVenta + valorIva;
    detalleVenta.setValorVenta(valorVenta);
    
    return detalleVenta;
  }
  
}
