/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ReporteDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dto.TotalVentaPorClienteDTO;

/**
 * Representa un controlador para la generación de consultas.
 * @author 
 *
 */
@RestController
@RequestMapping("/reportes")
public class ReporteControlador {
  
  /**
   * DAO para manejar los reportes.
   */
  private ReporteDAO reporteDAO;
  
  /**
   * Crea un nuevo controlador para los reportes.
   * @param reporteDAO DAO para manejar los reportes.
   */
  public ReporteControlador(ReporteDAO reporteDAO) {
    this.reporteDAO = reporteDAO;
  }

  /**
   * Obtiene el total de ventas por cliente.
   * @return Lista con el total de ventas por cliente.
   */
  @GetMapping("/ventasporcliente")
  public ResponseEntity<List<TotalVentaPorClienteDTO>> getTotalVentaPorClienteDTO() {
    return ResponseEntity.ok(this.reporteDAO.getTotalVentaPorClienteDTO());
  }
  
  /**
   * Obtiene el total de todas las ventas realizadas en la tienda.
   * @return Un objeto Map (diccionario) que contiene el total de todas las 
   * ventas realizadas en la tienda.
   */
  @GetMapping("/totalglobalventas")
  public ResponseEntity<Map<String, Double>> getTotalGlobalVentas() {
    // Se devuelve un objeto Map (diccionario) para cumplir la recomendación de una 
    // API REST de devolver respuestas en formato de objetos JSON clave-valor.
    Map<String, Double> resultado = new HashMap<>();
    resultado.put("totalGlobalVentas", Double.valueOf(this.reporteDAO.getTotalGlobalVentas()));
    return ResponseEntity.ok(resultado);
  }
}
