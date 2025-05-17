# Product & Order Management System – Java

Este proyecto corresponde a la **Preentrega de la Clase 8** del curso de Java. Su objetivo es implementar una aplicación de consola que permita gestionar productos y crear pedidos, aplicando los principales pilares de la Programación Orientada a Objetos (POO).

---

## 🎯 Objetivo

Crear un sistema básico para:

- Registrar productos (nombre, precio, stock)
- Listar, buscar, actualizar y eliminar productos
- Iniciar y confirmar pedidos con múltiples productos
- Validar stock disponible y calcular totales
- Organizar el código en clases, paquetes y módulos

---

## 📦 Estructura del proyecto
src/
├── org.example
│   └── Main.java
├── org.example.products
│   └── Product.java
├── org.example.orders
│   ├── Order.java
│   └── OrderItem.java
├── org.example.services
│   ├── ProductService.java
│   └── OrderService.java
├── org.example.exceptions
│   └── InsufficientStockException.java

## 🧪 Funcionalidades disponibles

Menú interactivo con opciones:

1. Agregar producto  
2. Listar productos  
3. Actualizar producto  
4. Eliminar producto  
5. Iniciar nuevo pedido  
6. Agregar ítem al pedido actual  
7. Confirmar pedido  
8. Listar pedidos confirmados  
9. Salir del sistema  

---

## 🧠 Conceptos aplicados

- Encapsulamiento con getters/setters
- Clases y objetos para modelar dominio
- Manejo de excepciones (personalizadas)
- Uso de colecciones dinámicas (`ArrayList`)
- Separación de responsabilidades por clase
- Menú interactivo con `Scanner`

---

## ▶️ Cómo ejecutar

1. Clonar o copiar el proyecto.
2. Abrirlo en un IDE como IntelliJ o Eclipse.
3. Ejecutar `Main.java`.
4. Seguir las instrucciones del menú.

