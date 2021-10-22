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
	
	public List<Venta> getVentasPorCodigo(long codigo) {
	  return this.ventaDAO.findAllByCodigo(codigo);
	}

	public Venta guardarVenta(Venta venta) {
		int sumaCantidad = 0;
		for (DetalleVenta detalleVenta : venta.getDetalleVentas()) {
			sumaCantidad += detalleVenta.getCantidadProducto();
		}
		if (sumaCantidad < 1) {
			return venta;
		}
		else {
			Set<DetalleVenta> detalles = venta.getDetalleVentas();
			venta.setDetalleVentas(new HashSet<DetalleVenta>());

			Venta ventaCreada = this.ventaDAO.save(venta);

			double sumaTotalVenta = 0.0;
			double sumaValorIva = 0.0;
			double sumaValorVenta = 0.0;

			for (DetalleVenta detalleVenta : detalles) {
				if (detalleVenta.getCantidadProducto() > 0) {
					detalleVenta.setCodigoVenta(ventaCreada.getCodigo());
					detalleVenta = this.detalleVentaServicio.calcularValores(detalleVenta);
					this.detalleVentaDAO.save(detalleVenta);
					sumaTotalVenta += detalleVenta.getTotalVenta();
					sumaValorIva += detalleVenta.getValorIva();
					sumaValorVenta += detalleVenta.getValorVenta();
				}
			}
			ventaCreada.setTotalVenta(sumaTotalVenta);
			ventaCreada.setIvaVenta(sumaValorIva);
			ventaCreada.setValorVenta(sumaValorVenta);

			ventaCreada = this.ventaDAO.save(ventaCreada);

			return this.ventaDAO.getById(ventaCreada.getCodigo());
		}
	}
}
