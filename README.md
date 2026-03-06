# 📝 Task API

API REST desarrollada con Spring Boot para gestionar tareas.  
Permite crear, modificar, eliminar y cambiar el estado de tareas a través de endpoints HTTP.

La API actualmente utiliza almacenamiento **en memoria**, pero está diseñada para integrarse fácilmente con una base de datos.

---

## 🚀 Tecnologías

- Java 21
- Spring Boot
- Maven
- Lombok
- Spring Validation
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