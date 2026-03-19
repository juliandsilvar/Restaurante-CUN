/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProyectoRestaurante;

// Clase hija que hereda de Producto.
// Representa las entradas del restaurante.
public class Entrada extends Producto {

    // Arreglo de ingredientes.
    // Se usa también para cumplir el requisito de arrays.
    private String[] ingredientes;

    // Constructor de Entrada.
    // super(...) llama al constructor de la clase padre Producto.
    public Entrada(String nombre, double precio, String[] ingredientes) {
        super(nombre, precio, "Entrada");
        setIngredientes(ingredientes);
    }

    // Getter:
    // Devuelve el arreglo de ingredientes.
    public String[] getIngredientes() {
        return ingredientes;
    }

    // Setter:
    // Permite asignar los ingredientes validando que existan.
    public void setIngredientes(String[] ingredientes) {
        if (ingredientes == null || ingredientes.length == 0) {
            throw new IllegalArgumentException("La entrada debe tener al menos un ingrediente.");
        }
        this.ingredientes = ingredientes;
    }

    // @Override significa sobrescribir un método heredado.
    // En este caso se reemplaza mostrarInfo() de Producto
    // para que la entrada tenga su propia forma de mostrarse.
    @Override
    public String mostrarInfo() {
        return getNombre() + " - $" + getPrecio();
    }
}