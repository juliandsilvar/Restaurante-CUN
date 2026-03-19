/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProyectoRestaurante;

// Clase hija de Producto.
// Representa una bebida del menú.
public class Bebida extends Producto {

    // Tamaño de la bebida.
    private String tamanio;

    // Constructor de la bebida.
    public Bebida(String nombre, double precio, String tamanio) {
        super(nombre, precio, "Bebida");
        setTamanio(tamanio);
    }

    // Getter del tamaño.
    public String getTamanio() {
        return tamanio;
    }

    // Setter del tamaño con validación.
    public void setTamanio(String tamanio) {
        if (tamanio == null || tamanio.trim().isEmpty()) {
            throw new IllegalArgumentException("El tamaño no puede estar vacío.");
        }
        this.tamanio = tamanio;
    }

    // Se sobrescribe mostrarInfo para enseñar el tamaño.
    @Override
    public String mostrarInfo() {
        return getNombre() + " - $" + getPrecio() + " - " + tamanio;
    }
}