# tiendagrupo4backend
Backend (API REST) elaborado con Spring Boot para la tienda virtual del equipo 4 del grupo 3 ciclo 3.

## Requisitos Técnicos
- Java JDK 11, Apache Maven 3, Apache Tomcat 9, MySQL 8.
- En eclipse IDE, se puede importar como proyecto de Maven.
- Crear una base de datos MySQL en blanco. El proyecto crea la estructura de la base de de datos e inserta datos de ejemplo.
- En el archivo *application.properties* se especifican la URL, el usuario y la contraseña para la conexión con la base de datos.
- También, en el archivo *application.properties* se especifica el puerto donde se ejecuta la aplicación.

```Java Properties
spring.datasource.url = jdbc:mysql://${HOST:localhost}:3306/tiendavirtualgrupo4
spring.datasource.username = root
spring.datasource.password = rootroot

server.port = 5000
```