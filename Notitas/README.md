# 📝 Notitas API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![GitHub last commit](https://img.shields.io/github/last-commit/AnaJotta/SpringBootProjects)

Una API RESTful para la gestión de notas, construida con Spring Boot y MySQL.

---

## 📌 Descripción
Este proyecto es el backend de una aplicación CRUD (Crear, Leer, Modificar, Eliminar) para gestionar notas personales.
Sirve como ejemplo educativo de cómo construir una API REST robusta usando Spring Boot, persistiendo datos en una base de datos relacional (MySQL) mediante Spring Data JPA y documentando los endpoints.

---

## 🚀 Características

- Endpoints REST para operaciones CRUD.
- Conexión persistente a base de datos MySQL.
- Uso de DTOs (Data Transfer Objects) para la transferencia de datos.
- Pruebas unitarias e integración (Spring REST Docs).
- Gestión de dependencias con Maven.

---

## 🛠 Tecnologías usadas

- **Backend:** Spring Boot (Starter Web)
- **Acceso a Datos:** Spring Data JPA
- **Base de Datos:** MySQL (Requiere servidor en ejecución)
- **Lenguaje:** Java 21
- **Gestión de Dependencias:** Maven
- **Herramientas:** Lombok (para reducir código boilerplate)

---

## 🎯 Uso y Ejecución

### Requisitos previos
1. Tener Java 21 instalado.
2. Tener un servidor MySQL corriendo.
3. Crear una base de datos llamada `notitas_db` (o el nombre que tengas en application.properties).

### Pasos
1. Clona este repositorio.
2. Configura tu usuario y contraseña de MySQL en `src/main/resources/application.properties`.
3. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
4. La API estará disponible en http://localhost:8080

***Probar los Endpoints (usando Postman)***
GET /notas : Obtener todas las notas.

POST /notas : Crear una nota (enviar JSON en el body).

PUT /notas/{id} : Editar una nota.

DELETE /notas/{id} : Eliminar una nota.

---

## 📁 Estructura del proyecto

Notitas/<br>
│
├── src/<br>
│   ├── main/<br>
│   │   ├── java/com/notitas/<br>
│   │   │   ├── controller/    ← Controladores REST (@RestController)<br>
│   │   │   ├── model/         ← Entidades JPA (Note)<br>
│   │   │   ├── repository/    ← Interfaces (NoteRepository)<br>
│   │   │   └── NotitasApplication.java<br>
│   │   └── resources/<br>
│   │       └── application.properties ← Configuración MySQL<br>
│   └── test/                  ← Pruebas unitarias y REST Docs<br>
└── pom.xml                    ← Dependencias<br>

---


## 👏 Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar la aplicación, por favor sigue estos pasos:

- Realiza un fork de este repositorio
- Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
- Realiza tus cambios y haz commit de ellos (git commit -am 'Añadir nueva característica').
- Sube tus cambios a tu fork (git push origin feature/nueva-caracteristica).
- Abre un pull request describiendo tus cambios.

---

## 📜 Licencia
Este proyecto está bajo la licencia MIT.

---

## 📬 Contacto
Autor: [Ana Jessica](https://github.com/AnaJotta)<br>
Repositorio principal: [Java](https://github.com/AnaJotta/SpringBootProjects)<br>
Correo / redes: <br> [<img src="https://img.icons8.com/color/48/000000/gmail.png" width="24" />](mailto:anajessicamarinmorales@gmail.com)[<img src="https://img.icons8.com/color/48/000000/linkedin.png" width="24" />](https://www.linkedin.com/in/ana-j-marin-morales/)

