# Gestionador de Mascotas
Aplicación de consola desarrollada en Java como parte del curso SOFT-04 (Programación Orientada a Objetos). Permite registrar mascotas, asociar dispositivos de localización y gestionar registros de ubicación.

## Funcionalidades

- Registrar nueva mascota
- Listar mascotas
- Ver detalle de mascota
- Crear y asociar dispositivo
- Registrar ubicación
- Consultar ubicaciones

## Modelo del dominio

El sistema está compuesto por las siguientes clases:

- Mascota (id, nombre, especie, estado, dispositivo)
- Dispositivo (id, estado, lista de registros)
- RegistroUbicacion (id, fechaHora, latitud, longitud)

Relaciones:
- Una Mascota tiene un Dispositivo (1:1)
- Un Dispositivo tiene 0..* Registros de ubicación

## Cómo ejecutar

1. Clonar el repositorio
2. Abrir en IntelliJ IDEA
3. Ejecutar la clase Main

## Autor

Daniel Ortega Ochoa
Curso SOFT-04
Universidad CENFOTEC
