package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.model.Proveedor;
import co.edu.unbosque.tiendavirtualcuatro.backend.servicios.ProveedorServicio;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/proveedores")
public class ProveedorControlador {

  private ProveedorServicio proveedorServicio;

  public ProveedorControlador(ProveedorServicio proveedorServicio) {
    this.proveedorServicio = proveedorServicio;

  }

  @GetMapping
  public ResponseEntity<List<Proveedor>> getProveedores() {
    return ResponseEntity.ok(this.proveedorServicio.getProveedores());
  }

  @GetMapping("/{nit}")
  public ResponseEntity<List<Proveedor>> getProveedoresPorNit(@PathVariable Long nit) {
    List<Proveedor> resultados = this.proveedorServicio.getProveedoresPorNit(nit);
    if (resultados.isEmpty()) {
      return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
  }

  @PostMapping
  public ResponseEntity<List<Proveedor>> postProveedor(@Valid @RequestBody Proveedor proveedor) {

    Proveedor proveedorCreado = this.proveedorServicio.agregarProveedor(proveedor);
    List<Proveedor> resultados = new ArrayList<>();
    resultados.add(proveedorCreado);

    return new ResponseEntity<>(resultados, HttpStatus.CREATED);
  }

  @PutMapping("/{nit}")
  public ResponseEntity<List<Proveedor>> putProveedor(@PathVariable String nit, @RequestBody Proveedor proveedor) {
    List<Proveedor> resultados = this.proveedorServicio.getProveedoresPorNit(Long.parseLong(nit));

    if (resultados.isEmpty()) {
      return new ResponseEntity<>(resultados, HttpStatus.NOT_FOUND);
    } else {
      this.proveedorServicio.editarProveedor(proveedor);
      resultados = this.proveedorServicio.getProveedoresPorNit(Long.parseLong(nit));
      return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
  }

  @DeleteMapping("/{nit}")
  public void deleteProveedor(@PathVariable String nit) {
    this.proveedorServicio.eliminarProveedorPorNit(Long.parseLong(nit));
  }
}
