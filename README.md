# 📝 Task API

API REST desarrollada con Spring Boot para gestionar tareas.  
Permite crear, modificar, eliminar y cambiar el estado de tareas a través de endpoints HTTP.  
Los datos se almacenan en una base de datos MySQL utilizando Spring Data JPA.

---

## 🚀 Tecnologías

- Java 21
- Spring Boot
- Maven
- Lombok
- Spring Validation
- Spring Data JPA
- MySQL
- OpenAPI / Swagger

---

## 📌 Funcionalidades

- Crear tareas
- Modificar tareas
- Eliminar tareas
- Obtener todas las tareas
- Obtener una tarea específica
- Cambiar el estado de una tarea
- Validación de datos
- Manejo global de excepciones
- Documentación automática con Swagger

---

## 📡 Endpoints

| Método | Endpoint | Descripción |
|------|------|------|
| GET | `/tasks` | Obtener todas las tareas |
| GET | `/tasks/{id}` | Obtener una tarea por ID |
| POST | `/tasks` | Crear una nueva tarea |
| PUT | `/tasks/{id}` | Modificar una tarea |
| DELETE | `/tasks/{id}` | Eliminar una tarea |
| PATCH | `/tasks/{id}/start` | Iniciar una tarea |
| PATCH | `/tasks/{id}/complete` | Completar una tarea |
| PATCH | `/tasks/{id}/cancel` | Cancelar una tarea |

---

## 📄 Ejemplo de request

### Crear tarea

POST `/tasks`

```json
{
  "title": "Estudiar Spring Boot",
  "description": "Practicar APIs REST"
}
```

#### Response

```json
{
  "id": 1,
  "title": "Estudiar Spring Boot",
  "description": "Practicar APIs REST",
  "status": "PENDING"
}
```

---

## 📚 Documentación de la API

La documentación interactiva está disponible en Swagger:

http://localhost:8080/swagger-ui/index.html

Desde allí se pueden probar todos los endpoints.

---

## 🗄️ Configuración de base de datos

La aplicación utiliza **MySQL** para persistir los datos.

1. Crear la base de datos

    Ejecutar en MySQL:

    ```sql
    CREATE DATABASE IF NOT EXISTS taskdb;
    ```

2. Configurar variables de entorno

    La aplicación utiliza las siguientes variables:
    | Variable    | Descripción                        |
    | ----------- | ---------------------------------- |
    | DB_URL      | URL de conexión a la base de datos |
    | DB_USERNAME | Usuario de la base de datos        |
    | DB_PASSWORD | Contraseña de la base de datos     |

    Ejemplo:
    ```bash
    DB_URL=jdbc:mysql://localhost:3306/taskdb
    DB_USERNAME=root
    DB_PASSWORD=tu_password
    ```
  
3. Configuración en el IDE

    **Spring Tool Suite**

    Configurar las variables en Run → Run Configurations → Proyecto task-api.

    **VS Code**

    Crear un archivo .env en la raíz del proyecto con:

    ```bash
    DB_URL=jdbc:mysql://localhost:3306/taskdb
    DB_USERNAME=tu_username
    DB_PASSWORD=tu_password
    ```

Al iniciar la aplicación por primera vez, Hibernate creará automáticamente la tabla `tasks` en la base de datos.

---

## ⚙️ Ejecutar el proyecto

Clonar el repositorio:

```bash
git clone https://github.com/tu-usuario/task-api.git
```

Entrar al proyecto:

```bash
cd task-api
```

Ejecutar la aplicación:

```bash
./mvnw spring-boot:run
```

La API estará disponible en:

http://localhost:8080

---

## 🏗️ Arquitectura del proyecto

El proyecto sigue una arquitectura en capas:

Controller → Service → Repository → Database

- **Controller:** expone los endpoints REST
- **Service:** contiene la lógica de negocio
- **Repository:** acceso a datos mediante Spring Data JPA
- **DTOs y Mappers:** separación entre modelo interno y API

---

## 📂 Estructura del proyecto

```bash
src
 ├── controllers
 ├── services
 ├── repositories
 ├── dtos
 ├── mappers
 ├── models
 └── exceptions
```