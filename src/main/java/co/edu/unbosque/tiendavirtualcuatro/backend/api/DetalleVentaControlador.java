/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.DetalleVenta;
import co.edu.unbosque.tiendavirtualcuatro.backend.servicios.DetalleVentaServicio;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/detallesventas")
public class DetalleVentaControlador {
  private DetalleVentaServicio detalleVentaServicio;

  /**
   * @param detalleVentaServicio
   */
  public DetalleVentaControlador(DetalleVentaServicio detalleVentaServicio) {
    super();
    this.detalleVentaServicio = detalleVentaServicio;
  }

  @GetMapping
  public ResponseEntity<List<DetalleVenta>> getDetallesVentas() {
    return ResponseEntity.ok(this.detalleVentaServicio.getDetallesVentas());
  }

  @PostMapping("/calcularvalores")
  public ResponseEntity<DetalleVenta> calcularValores(
      @RequestBody DetalleVenta detalleVenta) {
    return ResponseEntity
      .ok(this.detalleVentaServicio.calcularValores(detalleVenta));
  }
}
