/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ProductoDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;

/**
 * Representa el controlador para manejar productos.
 * 
 * @author
 */
@RestController
@RequestMapping("/productos")
public class ProductoControlador {

  /**
   * DAO para manejar los productos.
   */
  private ProductoDAO productoDAO;

  /**
   * Crea un objeto ProductoControlador
   * 
   * @param productoDAO DAO para manejar los productos.
   */
  public ProductoControlador(ProductoDAO productoDAO) {
    super();
    this.productoDAO = productoDAO;
  }
  
  @GetMapping
  public ResponseEntity<List<Producto>> getProveedores(@RequestParam Optional<String> codigo) {
    if (codigo.isPresent()) {
      List<Producto> resultados = this.productoDAO.findAllByCodigo(Long.parseLong(codigo.get()));
      if (resultados.isEmpty()) {
        return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
      } else {
        return new ResponseEntity<>(resultados, HttpStatus.OK);
      }
    } else {
      return ResponseEntity.ok(this.productoDAO.findAll());
    }
  }
  
  @GetMapping("/{codigo}")
  public ResponseEntity<List<Producto>> getProveedoresPorNit(@PathVariable String codigo) {
    List<Producto> resultados = this.productoDAO.findAllByCodigo(Long.parseLong(codigo));
    if (resultados.isEmpty()) {
      return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
  }

  @PostMapping
  public ResponseEntity<List<Producto>> postProducto(@Valid @RequestBody Producto producto) {
    Producto productoCreado = this.productoDAO.save(producto);
    List<Producto> resultados = new ArrayList<>(List.of(productoCreado));
    return new ResponseEntity<>(resultados, HttpStatus.CREATED);
  }
  
  @DeleteMapping
  public void deleteProductos() {
    this.productoDAO.deleteAll();
  }
}
