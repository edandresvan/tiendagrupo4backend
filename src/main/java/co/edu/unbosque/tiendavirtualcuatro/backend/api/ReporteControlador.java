/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ReporteDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dto.TotalVentaPorClienteDTO;

/**
 * @author 
 *
 */
@RestController
@RequestMapping("/reportes")
public class ReporteControlador {
  
  private ReporteDAO reporteDAO;
  
  public ReporteControlador(ReporteDAO reporteDAO) {
    this.reporteDAO = reporteDAO;
  }

  @GetMapping("/ventasporcliente")
  public ResponseEntity<List<TotalVentaPorClienteDTO>> getTotalVentaPorClienteDTO() {
    return ResponseEntity.ok(this.reporteDAO.getTotalVentaPorClienteDTO());
  }
}
