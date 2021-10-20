/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import org.springframework.stereotype.Repository;

import co.edu.unbosque.tiendavirtualcuatro.backend.dto.TotalVentaPorClienteDTO;

/**
 * Representa un objeto de acceso a datos (DAO) para obtener reportes.
 * 
 * @author Administrator
 *
 */
@Repository
public class ReporteDAO {

  /**
   * Gestor de persistencia que crea una conexión con la base de datos y mapea
   * resultados.
   */
  @PersistenceContext
  EntityManager entityManager;

  /**
   * Obtiene el total de ventas que cada cliente ha realizado en la tienda.
   * 
   * @return Lista con objetos
   * @see co.edu.unbosque.tiendavirtualcuatro.backend.dto.TotalVentaPorClienteDTO
   *      que contienen los resultados de la consulta de total de ventas por
   *      cliente.
   */
  public List<TotalVentaPorClienteDTO> getTotalVentaPorClienteDTO() {
    // Crear una consulta
    javax.persistence.Query consulta = entityManager
      .createNativeQuery(
        "select v.cedula_cliente cedulaCliente, c.nombre_cliente nombreCliente, "
            + " sum(v.valor_venta) totalVentaCliente "
            + " from clientes c "
            + " inner join ventas v on c.cedula_cliente = v.cedula_cliente "
            + " group by (v.cedula_cliente) ",
        Tuple.class);

    // Ejecutar la consulta y obtener las filas resultantes
    List<Tuple> filas = consulta.getResultList();
    // Inicializar la lista de resultados DTO
    List<TotalVentaPorClienteDTO> ventasClientes = new ArrayList<>();
    // Convertir cada tupla resultante en el objeto DTO respectivo
    for (Tuple fila : filas) {
      // Crear el objeto DTO usando:
      // - el mismo nombre de las columnas o alias de la consulta SQL
      // - la conversión de datos apropiada
      TotalVentaPorClienteDTO ventaCliente = new TotalVentaPorClienteDTO(
        (fila.get("cedulaCliente", BigInteger.class)
          .longValue()),
        fila.get("nombreCliente", String.class),
        fila.get("totalVentaCliente", Double.class));

      ventasClientes.add(ventaCliente);
    }
    // Devolver la lista de DTOS resultante
    return ventasClientes;
  }

  /**
   * Obtiene el total de todas las ventas realizadas en la tienda.
   * 
   * @return Total de todas las ventas realizadas en la tienda.
   */
  public double getTotalGlobalVentas() {
    // Crear una consulta
    javax.persistence.Query consulta = entityManager
      .createNativeQuery(
        "select sum(v.valor_venta) totalGlobalVentas "
            + "from ventas v",
        Tuple.class);
    // Ejecutar la consulta y obtener las filas resultantes

    List<Tuple> filas = consulta.getResultList();
    // Ya que la consulta SQL devuelve un solo dato (un escalar), se procesa
    // solo la primera columna de la primera fila
    double total = filas.get(0)
      .get("totalGlobalVentas", Double.class);

    return total;
  }
}
