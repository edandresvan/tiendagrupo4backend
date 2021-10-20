/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import co.edu.unbosque.tiendavirtualcuatro.backend.dto.TotalVentaPorClienteDTO;

/**
 * @author Administrator
 *
 */
@Repository
public class ReporteDAO {
  @PersistenceContext
  EntityManager entityManager;

  public List<TotalVentaPorClienteDTO> getTotalVentaPorClienteDTO() {
    
    javax.persistence.Query consulta = entityManager
      .createNativeQuery(
        "select v.cedula_cliente cedulaCliente, c.nombre_cliente nombreCliente, "
            + "sum(v.valor_venta) totalVentaCliente "
            + "from clientes c "
            + "  inner join ventas v on c.cedula_cliente = v.cedula_cliente "
            + "group by (v.valor_venta) ");
   
    
    List<Object[]> filas = consulta.getResultList();
    List<TotalVentaPorClienteDTO> ventasClientes= new ArrayList<>();
    for (Object[] fila : filas) {
      TotalVentaPorClienteDTO ventaCliente = new TotalVentaPorClienteDTO(
       Long.parseLong(fila[0].toString()), // cedula
       fila[1].toString(), // nombre
       Double.parseDouble(fila[2].toString())); // total
      
      ventasClientes.add(ventaCliente);
    }
   
    return ventasClientes;
  }
}
