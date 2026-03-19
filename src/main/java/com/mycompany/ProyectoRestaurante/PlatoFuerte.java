/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProyectoRestaurante;

// Clase hija de Producto.
// Representa los platos fuertes del menú.
public class PlatoFuerte extends Producto {

    // Atributo propio de esta clase.
    private String tipo;

    // Constructor del plato fuerte.
    public PlatoFuerte(String nombre, double precio, String tipo) {
        super(nombre, precio, "Plato Fuerte");
        setTipo(tipo);
    }

    // Getter del tipo.
    public String getTipo() {
        return tipo;
    }

    // Setter del tipo con validación.
    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo del plato no puede estar vacío.");
        }
        this.tipo = tipo;
    }

    // Se sobrescribe el método para mostrar también el tipo del plato.
    @Override
    public String mostrarInfo() {
        return getNombre() + " - $" + getPrecio() + " (" + tipo + ")";
    }
}