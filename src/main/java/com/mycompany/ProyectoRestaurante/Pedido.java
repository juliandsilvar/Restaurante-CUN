/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProyectoRestaurante;

import java.util.ArrayList;

// Esta clase representa un pedido hecho por un cliente.
public class Pedido implements Calculable {

    // Datos principales del pedido.
    private int numeroOrden;
    private String nombreCliente;
    private ArrayList<Producto> productos;
    private double subtotal;
    private double propina;
    private double totalPagar;

    // Constructor del pedido.
    // Recibe el número de orden y el nombre del cliente.
    public Pedido(int numeroOrden, String nombreCliente) {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }

        this.numeroOrden = numeroOrden;
        this.nombreCliente = nombreCliente;
        this.productos = new ArrayList<>();
        this.subtotal = 0;
        this.propina = 0;
        this.totalPagar = 0;
    }

    // Getter del número de orden.
    public int getNumeroOrden() {
        return numeroOrden;
    }

    // Getter del nombre del cliente.
    public String getNombreCliente() {
        return nombreCliente;
    }

    // Getter de la lista de productos.
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // Getter del subtotal.
    public double getSubtotal() {
        return subtotal;
    }

    // Getter de la propina.
    public double getPropina() {
        return propina;
    }

    // Getter del total a pagar.
    public double getTotalPagar() {
        return totalPagar;
    }

    // Este método agrega un producto al pedido.
    // Además, suma su precio al subtotal.
    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("No se puede agregar un producto nulo.");
        }

        productos.add(producto);
        subtotal += producto.getPrecio();
    }

    // Calcula la propina y el total final.
    // El porcentaje permitido va de 0 a 10.
    @Override
public double calcularTotal(double porcentajePropina) {

    if (porcentajePropina < 0 || porcentajePropina > 10) {
        throw new IllegalArgumentException("La propina debe estar entre 0% y 10%.");
    }

    propina = subtotal * (porcentajePropina / 100.0);
    totalPagar = subtotal + propina;

    return totalPagar;
}

public void guardarPedido() {
    //Guarda resumen del pedido en archivo txt antes de mostrarlo
    try {
        java.io.FileWriter writer = new java.io.FileWriter("pedidos.txt", true);
        
        writer.write("Pedido #" + numeroOrden + "\n");
        writer.write("Cliente: " + nombreCliente + "\n");
        writer.write("Productos:\n");

        for (Producto p : productos) {
            writer.write("- " + p.getNombre() + " : $" + p.getPrecio() + "\n");
        }
        writer.write("Subtotal: $" + subtotal + "\n");
        writer.write("Propina: $" + propina + "\n");
        writer.write("Total: $" + totalPagar + "\n");
        writer.write("----------------------------------\n");

        writer.close();

    } catch (java.io.IOException e) {

        System.out.println("Error al guardar el pedido: " + e.getMessage());
    }
}

public static void abrirArchivoPedidos() {
    // Abre el archivo guardado con los pedidos
    if (!java.awt.Desktop.isDesktopSupported()) {
    System.out.println("El sistema no permite abrir archivos automáticamente.");
    return;
}
    try {
        java.io.File archivo = new java.io.File("pedidos.txt");
        if (archivo.exists()) {
            java.awt.Desktop.getDesktop().open(archivo);
        } else {
            System.out.println("El archivo de pedidos aún no existe.");
        }
    } catch (java.io.IOException e) {
        System.out.println("No se pudo abrir el archivo: " + e.getMessage());
    }
}

    // Crea un resumen del pedido en forma de texto.
    // StringBuilder ayuda a construir textos largos de forma ordenada.
    public String mostrarResumen() {
        StringBuilder sb = new StringBuilder();

        sb.append("Número de orden: ").append(numeroOrden).append("\n");
        sb.append("Cliente: ").append(nombreCliente).append("\n\n");
        sb.append("Detalle del pedido:\n");

        // Recorre la lista de productos agregados al pedido.
        for (Producto p : productos) {
            sb.append("- ").append(p.getCategoria()).append(": ").append(p.mostrarInfo()).append("\n");
        }

        sb.append("\nSubtotal: $").append(subtotal);
        sb.append("\nPropina: $").append(propina);
        sb.append("\nTotal a pagar: $").append(totalPagar);

        return sb.toString();
    }
}

