package co.edu.unbosque.tiendavirtualcuatro.backend;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.Conexion;

@SpringBootApplication
public class TiendavirtualcuatrobackendApplication {

  /**
   * Ayuda a cargar los datos del archivo application.properties y otras mas.
   */
  @Autowired
  private Environment env;

  /**
   * Ejecuta acciones posteriores a la inicialización de la aplicación.
   */
  @PostConstruct
  public void init() {
    // Configurar los datos necesarios para la clase que maneja la conexión con
    // la base de datos
    Conexion.url = env.getProperty("spring.datasource.url");
    Conexion.login = env.getProperty("spring.datasource.username");
    Conexion.password = env.getProperty("spring.datasource.password");
  }

  public static void main(String[] args) {
    SpringApplication.run(TiendavirtualcuatrobackendApplication.class, args);
  }

}
