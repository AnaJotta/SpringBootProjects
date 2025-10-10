# 🧩 API REST de Productos — Esquema del Proyecto <br>
<br>
## 📋 Descripción general <br>
- Proyecto Spring Boot que implementa una API REST para la gestión de productos. <br>
- Permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre productos almacenados en una base de datos MySQL. <br>
<br>

--- 

## ⚙️ Tecnologías principales <br>
- Java 21 <br>
- Spring Boot 3.5.6 <br>
- Spring Data JPA <br>
- MySQL <br>
- Maven <br>
<br>

---

## 📁 Estructura del proyecto <br>
ApirestProductos/ <br>
│ <br>
├── src/main/java/com/anajotta/Productos/ <br>
│   ├── controller/ → Controladores REST (manejan las peticiones HTTP) <br>
│   │   └── ProductoController.java <br>
│   │ <br>
│   ├── entity/ → Entidades JPA que representan tablas en la BD <br>
│   │   └── Producto.java <br>
│   │ <br>
│   ├── repository/ → Interfaces que extienden JpaRepository <br>
│   │   └── ProductoRepository.java <br>
│   │ <br>
│   ├── service/ → Lógica de negocio y capa de servicios <br>
│   │   ├── IProducto.java <br>
│   │   └── ProductoServiceImplementar.java <br>
│   │ <br>
│   └── ApirestProductosApplication.java → Clase principal (main) <br>
│ <br>
└── src/main/resources/ <br>
    ├── application.properties → Configuración (credenciales BD, puerto, etc.) <br>
    └── static / templates → Recursos opcionales <br>
<br>

---

## 🔧 Configuración de la base de datos (MySQL) <br>
Archivo: src/main/resources/application.properties <br>
spring.datasource.url=jdbc:mysql://localhost:3306/productos_db <br>
spring.datasource.username=tu_usuario <br>
spring.datasource.password=tu_contraseña <br>
spring.jpa.hibernate.ddl-auto=update <br>
spring.jpa.show-sql=true <br>
<br>

---

## ▶️ Endpoints principales <br>
POST /productos → Crear un producto <br>
POST /productos/lista → Crear múltiples productos <br>
GET /productos → Obtener todos los productos <br>
GET /productos/{id} → Buscar producto por ID <br>
PUT /productos → Actualizar producto existente <br>
DELETE /productos/{id} → Eliminar producto <br>
<br>

---

## 🧱 Ejemplo JSON de producto <br>
{ <br>
  "nombre": "Teclado mecánico RGB", <br>
  "detalle": "Teclado con switches rojos retroiluminado", <br>
  "precio": 79.99 <br>
} <br>
<br>

---

## 🧩 Ejemplo JSON de lista de productos <br>
[
  {
    "nombre": "Monitor Full HD",
    "detalle": "Monitor 24 pulgadas 1080p",
    "precio": 149.99
  },
  {
    "nombre": "Ratón inalámbrico",
    "detalle": "Mouse óptico con receptor USB",
    "precio": 29.99
  }
]


---

## 🧪 Ejecución <br>
1. Clonar el repositorio: `git clone https://github.com/AnaJotta/SpringBootProjects.git` <br>
2. Abrir el proyecto ApirestProductos en IntelliJ o Spring Tool Suite. <br>
3. Configurar las credenciales de MySQL en application.properties. <br>
4. Ejecutar la clase ApirestProductosApplication. <br>
5. Acceder a la API en: `http://localhost:8080/productos` <br>

---

###  ✅ Pruebas con Postman

- Haz peticiones POST, GET, PUT, DELETE a las rutas indicadas.
- Para POST /productos/lista, asegúrate de enviar un array JSON, tal como en el ejemplo anterior.

---

### 📋 Futuras mejoras (ideas)

- Validaciones de datos (precios no negativos, nombre obligatorio).

- Manejo de errores con respuestas personalizadas (404, 400, etc.).

- Paginación y filtros en el endpoint GET /productos.

- Autenticación y autorización (JWT, Spring Security).

- Separación entre entity y DTO para no exponer directamente la entidad de la base de datos.

---

### 👏 Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar la aplicación, por favor sigue estos pasos:

Realiza un fork de este repositorio.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz commit de ellos (git commit -am 'Añadir nueva característica').
Sube tus cambios a tu fork (git push origin feature/nueva-caracteristica).
Abre un pull request describiendo tus cambios.

---

📄 Licencia

Este proyecto está bajo la licencia MIT






