package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;
import co.edu.unbosque.tiendavirtualcuatro.backend.servicios.ProveedorServicio;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * Representa un controlador tipo API REST para los proveedores.
 * 
 * @author
 */
@RestController
@RequestMapping("/proveedores")
public class ProveedorControlador {

  /**
   * Objeto servicio que hace la intermediación con las capas de modelo y de DAO
   * para los provedores.
   */
  private ProveedorServicio proveedorServicio;

  /**
   * Crea un controlador para gestionar los proveedores.
   * 
   * @param proveedorServicio Servicio que hace la intermediación con las capas
   *                          de modelo y de DAO para los provedores.
   */
  public ProveedorControlador(ProveedorServicio proveedorServicio) {
    this.proveedorServicio = proveedorServicio;

  }

  /**
   * Obtiene la lista de proveedores con o sin el NIT especificado.
   * 
   * @param nit Opcional. NIT del proveedor que se quiere buscar.
   * @return Lista de proveedores con o sin el NIT especificado.
   */
  @GetMapping
  public ResponseEntity<List<Proveedor>> getProveedores(
      @RequestParam Optional<String> nit) {
    // Primero, determinar si se especificó el NIT
    if (nit.isPresent()) {
      // Si se especificó el NIT, realizar la búsqueda con ese NIT
      List<Proveedor> resultados = this.proveedorServicio
        .getProveedoresPorNit(Long.parseLong(nit.get()));
      // Si se obtuvieron resultados, devolver OK.
      if (resultados.isEmpty()) {
        return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
      } else {
        return new ResponseEntity<>(resultados, HttpStatus.OK);
      }
    } else {
      // No se especificó el NIT, devolver todos los proveedores
      return ResponseEntity.ok(this.proveedorServicio.getProveedores());
    }
  }

  /**
   * Obtiene los proveedores con el NIT especificado.
   * 
   * @param nit NIT del proveedor que se quiere obtener.
   * @return Lista de los proveedores con el NIT especificado.
   */
  @GetMapping("/{nit}")
  public ResponseEntity<List<Proveedor>> getProveedoresPorNit(
      @PathVariable String nit) {
    // Realizar la búsqueda con el NIT
    List<Proveedor> resultados = this.proveedorServicio
      .getProveedoresPorNit(Long.parseLong(nit));
    // Si se obtuvieron resultados devolver OK
    if (resultados.isEmpty()) {
      return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
  }

  /**
   * Guarda el nuevo proveedor especificado.
   * 
   * @param proveedor Nuevo proveedor que se quiere guardar.
   * @return Lista con el objeto proveedor que se guardó.
   */
  @PostMapping
  public ResponseEntity<List<Proveedor>> postProveedor(
      @Valid @RequestBody Proveedor proveedor) {
    // Crear el proveedor
    Proveedor proveedorCreado = this.proveedorServicio
      .agregarProveedor(proveedor);
    // Inicializar una lista con el proveedor recién creado
    List<Proveedor> resultados = new ArrayList<>();
    resultados.add(proveedorCreado);
    // Devolver CREATED
    return new ResponseEntity<>(resultados, HttpStatus.CREATED);
  }

  /**
   * Guarda y modifica el proveedor especificado con NIT existente con sus
   * nuevos datos.
   * 
   * @param nit       NIT del proveedor que se quiere modificar.
   * @param proveedor Proveedor que se quiere modificar.
   * @return Lista con el objeto proveedor que se modificó.
   */
  @PutMapping("/{nit}")
  public ResponseEntity<List<Proveedor>> putProveedor(@PathVariable String nit,
      @Valid @RequestBody Proveedor proveedor) {
    // Primero, buscar los proveedores con ese NIT
    List<Proveedor> resultados = this.proveedorServicio
      .getProveedoresPorNit(Long.parseLong(nit));

    // Si no hay resutlados, devolver NOT FOUND
    if (resultados.isEmpty()) {
      return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
    } else {
      // SI hay resultados, modificar el proveedor
      this.proveedorServicio.editarProveedor(proveedor);
      // Obtener nuevamente la lista de proveedores con ese NIT
      resultados = this.proveedorServicio
        .getProveedoresPorNit(Long.parseLong(nit));
      // Devolver OK
      return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
  }

  /**
   * Elimina el proveedor con el NIT especificado.
   * @param nit NIT del proveedor que quiere eliminar.
   */
  @DeleteMapping("/{nit}")
  public void deleteProveedor(@PathVariable String nit) {
    // Eliminar el proveedor
    this.proveedorServicio.eliminarProveedorPorNit(Long.parseLong(nit));
  }
}
