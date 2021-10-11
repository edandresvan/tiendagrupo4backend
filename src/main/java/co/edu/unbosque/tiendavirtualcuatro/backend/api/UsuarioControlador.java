/**
 * 
 */
package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.UsuarioDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Usuario;

/**
 * @author 
 *
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
  
  @PostMapping("/registrarUsuario")
  public Usuario registrarUsuario(@RequestBody Usuario persona) {
    UsuarioDAO dao= new UsuarioDAO(); 
    return dao.registrarUsuario(persona);
  }
  
  /**
	 * Consultar la lista de Usuarios
	 * @return
	 */
	//@RequestMapping("/listaDeUsuarios")
	@GetMapping("/listaDeUsuarios")
	public ArrayList<Usuario> listaDeUsuarios() {
		UsuarioDAO objDAO=new UsuarioDAO(); 
			return objDAO.listaDeUsuarios();
}
}