# **Sistema de Gestión de Capacitaciones**

Plataforma web empresarial desarrollada con **Java Spring Boot** para la administración integral de cursos, instructores y procesos de inscripción de empleados. El sistema implementa una arquitectura segura basada en roles para garantizar la integridad de los datos y el acceso controlado.

## **Stack Tecnológico**

* **Backend:** Java 17, Spring Boot 3 (Web, Data JPA, Security).  
* **Frontend:** Thymeleaf (Motor de plantillas), Bootstrap 5\.  
* **Base de Datos:** H2 Database (En memoria), compatible con MySQL/PostgreSQL.  
* **Seguridad:** Spring Security 6 con autenticación basada en sesiones y control de acceso por roles (RBAC).  
* **Gestión de Dependencias:** Apache Maven.

## **Funcionalidades Principales**

### **Módulo de Administración (Rol ADMIN)**

* **Gestión de Cursos:** Creación, edición y visualización de cursos disponibles.  
* **Supervisión:** Asignación de instructores y control de cupos.  
* **Seguridad:** Acceso exclusivo a rutas administrativas (/admin/\*\*).

### **Módulo de Empleado (Rol EMPLEADO)**

* **Catálogo:** Exploración de cursos disponibles con visualización de estado.  
* **Inscripción:** Registro en cursos mediante un flujo simplificado.  
* **Historial:** Visualización personal de inscripciones realizadas ("Mis Cursos").

### **API REST**

El sistema expone endpoints para la integración con sistemas externos:

* GET /api/cursos: Listado de cursos disponibles (JSON).  
* POST /api/inscripciones: Registro de inscripciones vía API.

## **Instrucciones de Despliegue**

### **Prerrequisitos**

* JDK 17 o superior instalado.  
* Maven instalado (o utilizar el wrapper mvnw incluido).

### **Ejecución Local**

1. Clonar el repositorio:  
   git clone \[https://github.com/Totobal5/bootcamp-sistema-capacitacion.git\](https://github.com/Totobal5/bootcamp-sistema-capacitacion.git)

2. Navegar a la carpeta del proyecto:  
   cd bootcamp-sistema-capacitacion

3. Ejecutar el comando de arranque:  
   mvn spring-boot:run

4. Acceder a la aplicación en el navegador: http://localhost:8090

## **Credenciales de Acceso**

El sistema utiliza un DataInitializer para precargar datos de prueba al iniciar la aplicación.

| Rol | Usuario | Contraseña | Permisos |
| :---- | :---- | :---- | :---- |
| **Administrador** | admin | 1234 | Gestión total de cursos e instructores. |
| **Empleado** | juan | 1234 | Consulta de catálogo e inscripción. |

## **Arquitectura del Proyecto**

El proyecto sigue una arquitectura en capas clásica de Spring Boot:

src/main/java/com/empresa/capacitacion  
├── config       \# Configuración de Seguridad (SecurityConfig) y Carga de Datos  
├── controller   \# Controladores Web (MVC) y API REST  
├── entity       \# Modelos de Base de Datos (JPA)  
├── repository   \# Interfaces de acceso a datos (JpaRepository)  
└── service      \# Lógica de negocio