# Hexagonal Auth Tasks

Una aplicación Spring Boot construida con arquitectura hexagonal para la gestión de tareas de usuarios con autenticación JWT segura.

## Descripción

Sistema de gestión de tareas que permite a los usuarios registrarse, autenticarse y administrar sus tareas personales. Implementa seguridad mediante tokens JWT y sigue el patrón arquitectónico hexagonal para una separación clara de responsabilidades.

**Tecnologías principales:**
- Java 17
- Spring Boot 3.3.0
- Spring Security + JWT
- JPA/Hibernate
- H2 Database
- MapStruct
- Swagger/OpenAPI
- Maven

## Estructura del Proyecto

```
hexagonal-auth-tasks/
├── src/
│   ├── main/
│   │   ├── java/com/docencia/hexagonal_auth_tasks/
│   │   │   ├── HexagonalAuthTasksApplication.java          # Punto de entrada
│   │   │   │
│   │   │   ├── domain/                                      # Capa de Dominio
│   │   │   │   └── model/
│   │   │   │       ├── User.java                            # Entidad de usuario
│   │   │   │       ├── Task.java                            # Entidad de tarea
│   │   │   │       └── Role.java                            # Entidad de rol
│   │   │   │
│   │   │   ├── application/                                 # Capa de Aplicación
│   │   │   │   ├── ports/
│   │   │   │   │   ├── in/                                  # Puertos de entrada
│   │   │   │   │   │   ├── UserServicePort.java
│   │   │   │   │   │   ├── TaskServicePort.java
│   │   │   │   │   │   └── RoleServicePort.java
│   │   │   │   │   └── out/                                 # Puertos de salida
│   │   │   │   │       ├── UserRepositoryPort.java
│   │   │   │   │       ├── TaskRepositoryPort.java
│   │   │   │   │       └── RoleRepositoryPort.java
│   │   │   │   └── service/
│   │   │   │       ├── UserService.java                     # Lógica de usuarios
│   │   │   │       ├── TaskService.java                     # Lógica de tareas
│   │   │   │       └── RoleService.java                     # Lógica de roles
│   │   │   │
│   │   │   └── infrastructure/                              # Capa de Infraestructura
│   │   │       ├── config/
│   │   │       │   └── ApplicationConfig.java               # Configuración de beans
│   │   │       │
│   │   │       ├── security/
│   │   │       │   ├── SecurityConfig.java                  # Configuración de seguridad
│   │   │       │   ├── JwtService.java                      # Servicio JWT
│   │   │       │   ├── JwtAuthenticationFilter.java         # Filtro JWT
│   │   │       │   └── OpenApiConfig.java                   # Configuración Swagger
│   │   │       │
│   │   │       └── adapter/
│   │   │           └── out/
│   │   │               └── persistence/
│   │   │                   ├── UserRepositoryAdapter.java   # Adaptador de usuario
│   │   │                   ├── TaskRepositoryAdapter.java   # Adaptador de tarea
│   │   │                   ├── RoleRepositoryAdapter.java   # Adaptador de rol
│   │   │                   │
│   │   │                   ├── entity/
│   │   │                   │   ├── UserEntity.java          # Entidad JPA usuario
│   │   │                   │   ├── TaskEntity.java          # Entidad JPA tarea
│   │   │                   │   └── RoleEntity.java          # Entidad JPA rol
│   │   │                   │
│   │   │                   ├── mapper/
│   │   │                   │   ├── UserMapper.java          # Mapeador usuario
│   │   │                   │   ├── TaskMapper.java          # Mapeador tarea
│   │   │                   │   └── RoleMapper.java          # Mapeador rol
│   │   │                   │
│   │   │                   ├── repository/
│   │   │                   │   ├── JpaUserRepository.java   # Repo JPA usuario
│   │   │                   │   ├── JpaTaskRepository.java   # Repo JPA tarea
│   │   │                   │   └── JpaRoleRepository.java   # Repo JPA rol
│   │   │                   │
│   │   │                   └── in/web/
│   │   │                       ├── AuthController.java      # Endpoints de autenticación
│   │   │                       ├── TaskController.java      # Endpoints de tareas
│   │   │                       └── dto/
│   │   │                           ├── LoginRequest.java
│   │   │                           ├── RegisterRequest.java
│   │   │                           ├── AuthResponse.java
│   │   │                           └── CreateTaskRequest.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties                        # Propiedades de configuración
│   │       └── data.sql                                      # Script SQL inicial
│   │
│   └── test/
│       └── java/
│           └── HexagonalAuthTasksApplicationTests.java
│
├── pom.xml                                                   # Configuración Maven
├── mvnw / mvnw.cmd                                          # Maven Wrapper
└── README.md                                                 # Este archivo
```

## Requisitos Previos

- **Java 17** o superior
- **Maven 3.6** o superior
- **Git** (opcional)

## Instalación y Arranque

### 1. Clonar o descargar el proyecto

```bash
cd /ruta/del/proyecto
```

### 2. Compilar el proyecto

```bash
mvn clean compile
```

### 3. Ejecutar la aplicación

**Opción A: Con Maven**
```bash
mvn spring-boot:run
```

**Opción B: Con el JAR compilado**
```bash
mvn clean package
java -jar target/hexagonal-auth-tasks-0.0.1-SNAPSHOT.jar
```

### 4. Verificar que está funcionando

Una vez que la aplicación esté corriendo, verás un mensaje como:
```
Started HexagonalAuthTasksApplication in X seconds
```

La aplicación estará disponible en: `http://localhost:8080`

## Endpoints Disponibles

### Autenticación

**Registro de nuevo usuario**
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "usuario",
  "password": "contraseña123"
}
```

**Inicio de sesión**
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "usuario",
  "password": "contraseña123"
}
```

Respuesta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Tareas (requieren autenticación con Bearer Token)

**Crear tarea**
```http
POST /api/tasks
Authorization: Bearer {token}
Content-Type: application/json

{
  "title": "Mi primera tarea",
  "description": "Descripción de la tarea"
}
```

**Obtener mis tareas**
```http
GET /api/tasks
Authorization: Bearer {token}
```

**Eliminar tarea**
```http
DELETE /api/tasks/{id}
Authorization: Bearer {token}
```

## Documentación API

La documentación interactiva de Swagger está disponible en:
```
http://localhost:8080/swagger-ui.html
```

## Configuración

Editar `src/main/resources/application.properties` para personalizar:

```properties
# Puerto de la aplicación
server.port=8080

# Base de datos H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true

# JWT
app.jwt.secret=tu_clave_secreta_aqui
app.jwt.expiration-minutes=60
```

## Base de Datos

El proyecto utiliza **H2 Database** en memoria. Los datos iniciales se cargan desde `data.sql` al iniciar la aplicación.

Acceder a la consola H2:
```
http://localhost:8080/h2-console
```

## Arquitectura Hexagonal

Este proyecto implementa el patrón arquitectónico hexagonal (puertos y adaptadores):

- **Dominio**: Modelos de negocio sin dependencias externas
- **Aplicación**: Puertos (interfaces) que definen los casos de uso
- **Infraestructura**: Adaptadores concretos (JPA, REST, seguridad)

Esta arquitectura permite:
- ✅ Fácil testabilidad
- ✅ Independencia de frameworks
- ✅ Cambio fácil de implementaciones
- ✅ Código limpio y mantenible

## Características de Seguridad

- 🔐 Autenticación con tokens JWT
- 🔐 Codificación segura de contraseñas (BCrypt)
- 🔐 CORS configurado
- 🔐 Validación de solicitudes
- 🔐 Protección de endpoints

## Desarrollo

### Compilar solo (sin tests)
```bash
mvn clean compile -DskipTests
```

### Ejecutar tests
```bash
mvn test
```

### Generar documentación JavaDoc
```bash
mvn javadoc:javadoc
```

## Notas

- La contraseña de usuarios se codifica automáticamente al registrarse
- El token JWT tiene una duración configurada (por defecto 60 minutos)
- Cada usuario solo puede ver sus propias tareas
- Las tareas se eliminan en cascada cuando se elimina el usuario

## Autor

Proyecto desarrollado como ejemplo de arquitectura hexagonal en Spring Boot.

## Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.
