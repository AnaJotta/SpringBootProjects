# ApirestProductos

Esta es una API REST construida con **Spring Boot** para gestionar productos de informática.  
Permite operaciones básicas de **CRUD** (Crear, Leer, Actualizar, Eliminar) sobre entidades `Producto`.

---

## 📁 Estructura del proyecto

- **controller** — Controladores REST para manejar peticiones HTTP
- **service** — Lógica de negocio (servicios e interfaces)
- **repository** — Repositorios JPA para acceso a la base de datos
- **entity** — Clase `Producto` que mapea la tabla de productos
- **ApirestProductosApplication.java** — Clase principal de Spring Boot

---




Asegúrate de que tu base de datos esté creada previamente (por ejemplo tu_base_de_datos) para que la API pueda conectarse.

🛠️ Endpoints disponibles
Método	URL	Descripción
POST /productos	Crear un nuevo producto	Recibe un objeto Producto en JSON
POST /productos/lista	Crear múltiples productos	Recibe un array JSON de productos
GET /productos	Obtener todos los productos	Retorna lista de productos
GET /productos/{id}	Obtener un producto por ID	Retorna el producto con ese ID
PUT /productos	Actualizar un producto	Recibe objeto Producto con ID existente
DELETE /productos/{id}	Eliminar un producto	Elimina el producto con ese ID

Ejemplo de JSON para crear varios productos:

[
{
"nombre": "Monitor LG 24\"",
"detalle": "Full HD IPS",
"precio": 149.99
},
{
"nombre": "Teclado Mecánico",
"detalle": "RGB retroiluminado",
"precio": 89.50
}
]

🚀 Cómo ejecutar el proyecto

Clona el repositorio:

git clone https://github.com/AnaJotta/SpringBootProjects.git
cd SpringBootProjects/ApirestProductos


Configura tu base de datos MySQL y actualiza application.properties.

Compila y ejecuta con Maven:

mvn clean install
mvn spring-boot:run


O directamente desde tu IDE (IntelliJ, Eclipse, etc.) ejecutando la clase ApirestProductosApplication.

La API se iniciará en http://localhost:8080.

🧪 Pruebas con Postman

Haz peticiones POST, GET, PUT, DELETE a las rutas indicadas.

Para POST /productos/lista, asegúrate de enviar un array JSON, tal como en el ejemplo anterior.

📋 Futuras mejoras (ideas)

Validaciones de datos (precios no negativos, nombre obligatorio).

Manejo de errores con respuestas personalizadas (404, 400, etc.).

Paginación y filtros en el endpoint GET /productos.

Autenticación y autorización (JWT, Spring Security).

Separación entre entity y DTO para no exponer directamente la entidad de la base de datos.

📄 Licencia

Este proyecto está bajo la licencia MIT

## ⚙️ Configuración de la base de datos

En `src/main/resources/application.properties`, define tus credenciales para MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect




