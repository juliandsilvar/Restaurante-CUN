/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProyectoRestaurante;

// Clase hija de Producto.
// Representa los postres del restaurante.
public class Postre extends Producto {

    // Indica si el postre es frío.
    private boolean frio;

    // Constructor del postre.
    public Postre(String nombre, double precio, boolean frio) {
        super(nombre, precio, "Postre");
        this.frio = frio;
    }

    // Getter booleano.
    // En variables true/false es común usar "is".
    public boolean isFrio() {
        return frio;
    }

    // Setter del atributo frio.
    public void setFrio(boolean frio) {
        this.frio = frio;
    }

    // Sobrescribe mostrarInfo para indicar si el postre es frío o no.
    @Override
    public String mostrarInfo() {
        return getNombre() + " - $" + getPrecio() + (frio ? " (Frío)" : " (No frío)");
    }
}