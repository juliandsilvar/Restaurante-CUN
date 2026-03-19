/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProyectoRestaurante;

// Clase base del proyecto.
// Se declara como abstract porque sirve como modelo general de producto,
// pero no se usará directamente para crear objetos.
public abstract class Producto {

    // Atributos privados: esto es encapsulamiento.
    // Solo se accede a ellos por medio de métodos.
    private String nombre;
    private double precio;
    private String categoria;

    // Constructor de la clase Producto.
    // Se ejecuta cuando una clase hija crea un producto.
    public Producto(String nombre, double precio, String categoria) {
        setNombre(nombre);
        setPrecio(precio);
        setCategoria(categoria);
    }

    // Getter:
    // Sirve para obtener o leer el valor del nombre.
    public String getNombre() {
        return nombre;
    }

    // Setter:
    // Sirve para modificar el nombre y validar que no quede vacío.
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    // Getter del precio.
    public double getPrecio() {
        return precio;
    }

    // Setter del precio con validación.
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        this.precio = precio;
    }

    // Getter de la categoría.
    public String getCategoria() {
        return categoria;
    }

    // Setter de la categoría con validación.
    public void setCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
        this.categoria = categoria;
    }

    // Método general para mostrar información del producto.
    // Las clases hijas lo pueden sobrescribir para mostrar datos más específicos.
    public String mostrarInfo() {
        return nombre + " - $" + precio;
    }

    // toString():
    // Java usa este método cuando muestra objetos en listas desplegables.
    // Aquí se redefine para que aparezca información clara del producto.
    @Override
    public String toString() {
        return mostrarInfo();
    }
}