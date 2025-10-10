# 👥 ListaUsuarios

**Descripción**
ListaUsuarios es una aplicación desarrollada con Spring Boot que permite gestionar una lista de usuarios.

**Proporciona funcionalidades básicas como:**

- Crear un nuevo usuario.
- Leer la lista de usuarios existentes.
- Actualizar la información de un usuario.
- Eliminar un usuario de la lista.

Este proyecto demuestra la implementación de operaciones **CRUD (Crear, Leer, Actualizar, Eliminar)** utilizando Spring Boot y una base de datos en memoria.

---

## 🛠 Tecnologías utilizadas

- Spring Boot: Framework principal para aplicaciones Java basadas en Spring.
- Spring Data JPA: Para la interacción con la base de datos.
- H2 Database: Base de datos en memoria para almacenar usuarios.

---

## ✅ Requisitos previos

Antes de ejecutar la aplicación, asegúrate de tener:

- Java 11 o superior
- Maven

---

## ⚙️ Instalación

- Clona el repositorio:
git clone https://github.com/AnaJotta/SpringBootProjects.git
cd SpringBootProjects/ListaUsuarios

- Compila y ejecuta la aplicación:
mvn clean install
mvn spring-boot:run

O usando el wrapper de Maven:
./mvnw clean install
./mvnw spring-boot:run (en el proyecto, este es el que usaba)

- La aplicación estará disponible en: http://localhost:8080

---

## 📲 Uso

- Ver usuarios: Accede a la lista de usuarios registrados.
- Agregar usuario: Completa el formulario para añadir un nuevo usuario.
- Editar usuario: Modifica la información de un usuario existente.
- Eliminar usuario: Elimina un usuario de la lista.

---

## 📂 Estructura del proyecto

ListaUsuarios/<br>
├── src/<br>
│   ├── main/<br>
│   │   ├── java/<br>
│   │   │   └── com/<br>
│   │   │       └── ejemplo/<br>
│   │   │           └── listausuarios/<br>
│   │   │               ├── ListaUsuariosApplication.java<br>
│   │   │               ├── controller/<br>
│   │   │               │   └── UsuarioController.java<br>
│   │   │               ├── model/<br>
│   │   │               │   └── Usuario.java<br>
│   │   │               └── repository/<br>
│   │   │                   └── UsuarioRepository.java<br>
│   │   └── resources/<br>
│   │       ├── application.properties<br>
│   │       └── templates/<br>
│   │           ├── index.html<br>
│   │           ├── add.html<br>
│   │           └── edit.html<br>
└── pom.xml<br>

---

## 👏 Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar la aplicación, por favor sigue estos pasos:
- Realiza un fork de este repositorio.
- Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
- Realiza tus cambios y haz commit de ellos (git commit -am 'Añadir nueva característica').
- Sube tus cambios a tu fork (git push origin feature/nueva-caracteristica).
- Abre un pull request describiendo tus cambios.
