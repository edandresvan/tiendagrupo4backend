package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ClienteDAO;
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
}