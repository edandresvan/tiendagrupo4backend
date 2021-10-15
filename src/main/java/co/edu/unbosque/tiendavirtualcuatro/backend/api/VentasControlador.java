package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ClienteDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.UsuarioDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Usuario;

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
	 	
	  @GetMapping("/buscaru")
	  @ResponseBody
	  public Usuario consultaru(@RequestParam int cedulau) {
	    if (cedulau <= 1) {
	      System.out.println("mensaje: cedula no puede ser menor que 1");
	      return null;
	    }
	    UsuarioDAO dao = new UsuarioDAO(); 
	    return dao.consultarUsuario(cedulau);
	  }	
	
}
