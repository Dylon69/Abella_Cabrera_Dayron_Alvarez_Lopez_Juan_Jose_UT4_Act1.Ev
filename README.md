# Abella_Cabrera_Dayron_Alvarez_Lopez_Juan_Jose_UT4_Act1.Ev
## Sistema de Gestión de Biblioteca – MVC en Java
## Descripción

Este proyecto consiste en el desarrollo de un Sistema de Gestión de Biblioteca en Java, aplicando el patrón de arquitectura MVC (Modelo – Vista – Controlador).

### El sistema permite:

Registrar libros y usuarios
Gestionar préstamos y devoluciones
Aplicar restricciones de préstamo
Buscar libros por diferentes criterios
Mostrar resúmenes del estado del sistema

--------------------------------------------------------------------------------------------------------------------------------------------------

## Reparto de tareas
### Dayron – Modelo y Lógica Base

Responsable de:

Creación de estructura MVC

Implementación de:

Libro
Usuario
Prestamo
Genero
EstadoLibro

Implementación de restricciones:

Máximo 3 préstamos
30 días de duración
Bloqueo de 7 días
Métodos de búsqueda en GestorBiblioteca

### Juajo – Controlador y Vista

Responsable de:

Implementación completa de GestorBiblioteca

Métodos:
prestarLibro()
devolverLibro()
reservarLibro()
Resúmenes del sistema
Clase Consola
Menú interactivo
Clase Main
Pruebas del sistema
