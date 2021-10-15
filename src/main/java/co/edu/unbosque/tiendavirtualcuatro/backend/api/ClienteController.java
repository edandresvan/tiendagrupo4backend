package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ClienteDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.UsuarioDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Usuario;

/**
 * @author 
 *
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PostMapping("/registrarCliente")
	  public Cliente registrarCliente(@RequestBody Cliente persona) {
	    ClienteDAO dao= new ClienteDAO(); 
	    return dao.registrarCliente(persona);
	  }
	
	  @GetMapping("/listaDeClientes")
	  public ArrayList<Cliente> listaDeClientes() {
	    ClienteDAO objDAO = new ClienteDAO();
	    return objDAO.listaDeClientes();
	  }	
	 
	@GetMapping("/buscar")
	  @ResponseBody
	  public Cliente consultar(@RequestParam int cedulausr) {
	    if (cedulausr <= 1) {
	      System.out.println("mensaje: cedula no puede ser menor que 1");
	      return null;
	    }
	    ClienteDAO dao = new ClienteDAO();
	    return dao.consultarCliente(cedulausr);
	  }
	 
	 @PutMapping("/actualizarCliente")
	  public Cliente actualizarCliente(@RequestBody Cliente cliente) {
	    ClienteDAO dao = new ClienteDAO();
	    return dao.actualizarCliente(cliente);
	  }
	 
	 @DeleteMapping("/borrar/{cedulausr}")
	  @ResponseBody
	  public void borrar(@PathVariable String cedulausr) {
	    int cedula = Integer.parseInt(cedulausr);
	    if (cedula < 1) {
	      System.out.println("mensaje: cedula no puede ser menor que 1");
	     
	    }
	    ClienteDAO dao = new ClienteDAO();
	    dao.borrarCliente(cedula);
	  }
}