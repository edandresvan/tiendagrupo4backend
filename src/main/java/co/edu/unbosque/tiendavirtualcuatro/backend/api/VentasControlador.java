package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ClienteDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.UsuarioDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.VentasDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Usuario;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Ventas;

@RestController
@RequestMapping("/ventas")
public class VentasControlador {

	@GetMapping("/buscarc")
	  @ResponseBody
	  public Cliente consultarc(@RequestParam int cedulausr) {
	    if (cedulausr <= 1) {
	      System.out.println("mensaje: cedula no puede ser menor que 1");
	      return null;
	    }
	    ClienteDAO dao = new ClienteDAO();
	    return dao.consultarCliente(cedulausr);
	  }
	 	
	  @GetMapping("/buscarcodigo")
	  @ResponseBody
	  public Producto consultarproducto(@RequestParam int codigo) {
	    if (codigo <= 1) {
	      System.out.println("mensaje: codigo de producto no puede ser menor que 1");
	      return null;
	    }
	    VentasDAO dao = new VentasDAO(); 
	    return dao.consultarProducto(codigo);
	  }
	  
	  @GetMapping("/listaDeVentas")
	  public ArrayList<Ventas> listaDeVentas() {
	    VentasDAO objDAO = new VentasDAO();
	    return objDAO.listaDeVentas();
	  }		  
	
}
