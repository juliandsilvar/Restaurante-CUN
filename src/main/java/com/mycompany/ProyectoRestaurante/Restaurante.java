/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProyectoRestaurante;

import java.util.ArrayList;

// Esta clase administra la información general del restaurante.
public class Restaurante {

    // Atributos principales del restaurante.
    private String nombre;
    private ArrayList<Producto> menu;
    private ArrayList<Pedido> pedidos;
    private int contadorOrden;
    private double gananciasTotales;

    // Constructor del restaurante.
    public Restaurante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del restaurante no puede estar vacío.");
        }

        this.nombre = nombre;
        this.menu = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.contadorOrden = 1;
        this.gananciasTotales = 0;
    }

    // Getter del nombre del restaurante.
    public String getNombre() {
        return nombre;
    }

    // Getter del menú.
    public ArrayList<Producto> getMenu() {
        return menu;
    }

    // Getter de la lista de pedidos.
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    // Getter de las ganancias acumuladas.
    public double getGananciasTotales() {
        return gananciasTotales;
    }

    // Genera un número de orden automático.
    // Primero devuelve el valor actual y después lo incrementa en 1.
    public int generarNumeroOrden() {
        return contadorOrden++;
    }

    // Agrega un producto al menú del restaurante.
    public void agregarProductoMenu(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto inválido.");
        }
        menu.add(producto);
    }

    // Registra un pedido ya finalizado.
    // También suma su valor al total de ganancias.
    public void registrarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido inválido.");
        }

        pedidos.add(pedido);
        gananciasTotales += pedido.getTotalPagar();
    }
}