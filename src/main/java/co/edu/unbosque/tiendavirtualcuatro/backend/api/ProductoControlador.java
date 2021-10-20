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
  
  /**
   * Obtiene los productos con o sin el código especificado.
   * @param codigo Opcional. Cód del producto que se desea buscar.
   * @return Lista de productos con o sin el código especificado.
   */
  @GetMapping
  public ResponseEntity<List<Producto>> getProveedores(@RequestParam Optional<String> codigo) {
    // Primero, determinar si se especificó el código
    if (codigo.isPresent()) {
      // Buscar los productos que tenga ese código
      List<Producto> resultados = this.productoDAO.findAllByCodigo(Long.parseLong(codigo.get()));
      // Si hubo resultados, devolver OK
      if (resultados.isEmpty()) {
        return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
      } else {
        return new ResponseEntity<>(resultados, HttpStatus.OK);
      }
    } else {
      // No se especificó el código, devolver todos los productos
      return ResponseEntity.ok(this.productoDAO.findAll());
    }
  }
  
  /**
   * Obtiene los productos con el código especificado.
   * @param codigo código de l producto que se desea buscar
   * @return Lista de los productos con el código especificado
   */
  @GetMapping("/{codigo}")
  public ResponseEntity<List<Producto>> getProveedoresPorNit(@PathVariable String codigo) {
    // Buscar los productos que tengan ese código
    List<Producto> resultados = this.productoDAO.findAllByCodigo(Long.parseLong(codigo));
    // Si hubo resultados, devolver OK
    if (resultados.isEmpty()) {
      return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
  }

  /**
   * Guarda el nuevo producto especificado.
   * @param producto Nuevo producto que se desea guardar.
   * @return Lista con el objeto producto que se guardó.
   */
  @PostMapping
  public ResponseEntity<List<Producto>> postProducto(@Valid @RequestBody Producto producto) {
    // Guardar el producto
    Producto productoCreado = this.productoDAO.save(producto);
    // Inicializar una lista con el producto recién creado
    List<Producto> resultados = new ArrayList<>(List.of(productoCreado));
    // Devolver CREATED
    return new ResponseEntity<>(resultados, HttpStatus.CREATED);
  }
  
  /**
   * Elimina todos los productos de la base de datos.
   */
  @DeleteMapping
  public void deleteProductos() {
    
    //this.productoDAO.deleteAll();
    // Comentar la siguiente línea si se quiere eliminar también los productos 
    // de prueba para ventas
    this.productoDAO.borrarTodosPreservarPruebas();
  }
}
