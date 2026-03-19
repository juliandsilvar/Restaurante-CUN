/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ProyectoRestaurante;


import javax.swing.JOptionPane;

// Clase principal.
// Aquí inicia y se controla todo el programa.
public class Main {

    public static void main(String[] args) {
        try {
            // Se crea el restaurante principal con el nombre solicitado.
            Restaurante restaurante = new Restaurante("Mi Restaurante");

            // ==================================================
            // CREACIÓN DE PRODUCTOS DEL MENÚ
            // Aquí se crean todos los objetos que el usuario podrá elegir.
            // ==================================================

            // Entradas
            Entrada entrada1 = new Entrada("Ensalada fresca", 12000,
                    new String[]{"Lechuga", "Tomate", "Pepino"});

            Entrada entrada2 = new Entrada("Sopa de pollo", 10000,
                    new String[]{"Pollo", "Papa", "Cilantro"});

            Entrada entrada3 = new Entrada("Pan de ajo", 8000,
                    new String[]{"Pan", "Ajo", "Mantequilla"});

            // Platos fuertes
            PlatoFuerte plato1 = new PlatoFuerte("Bandeja paisa", 25000, "Res");
            PlatoFuerte plato2 = new PlatoFuerte("Pechuga a la plancha", 22000, "Pollo");
            PlatoFuerte plato3 = new PlatoFuerte("Carne asada", 28000, "Res");
            PlatoFuerte plato4 = new PlatoFuerte("Chuleta de cerdo", 24000, "Cerdo");
            PlatoFuerte plato5 = new PlatoFuerte("Pescado frito", 30000, "Pescado");

            // Bebidas
            Bebida bebida1 = new Bebida("Jugo natural", 7000, "Grande");
            Bebida bebida2 = new Bebida("Gaseosa", 5000, "Mediana");
            Bebida bebida3 = new Bebida("Limonada", 6500, "Grande");
            Bebida bebida4 = new Bebida("Té frío", 6000, "Mediano");
            Bebida bebida5 = new Bebida("Agua mineral", 4000, "Pequeña");

            // Postres
            Postre postre1 = new Postre("Helado", 8000, true);
            Postre postre2 = new Postre("Torta de chocolate", 9000, false);
            Postre postre3 = new Postre("Flan", 7000, false);
            Postre postre4 = new Postre("Cheesecake", 10000, true);
            Postre postre5 = new Postre("Brownie con helado", 11000, true);

            // ==================================================
            // CARGA DEL MENÚ
            // Todos los productos creados se agregan a la lista del restaurante.
            // ==================================================
            restaurante.agregarProductoMenu(entrada1);
            restaurante.agregarProductoMenu(entrada2);
            restaurante.agregarProductoMenu(entrada3);

            restaurante.agregarProductoMenu(plato1);
            restaurante.agregarProductoMenu(plato2);
            restaurante.agregarProductoMenu(plato3);
            restaurante.agregarProductoMenu(plato4);
            restaurante.agregarProductoMenu(plato5);

            restaurante.agregarProductoMenu(bebida1);
            restaurante.agregarProductoMenu(bebida2);
            restaurante.agregarProductoMenu(bebida3);
            restaurante.agregarProductoMenu(bebida4);
            restaurante.agregarProductoMenu(bebida5);

            restaurante.agregarProductoMenu(postre1);
            restaurante.agregarProductoMenu(postre2);
            restaurante.agregarProductoMenu(postre3);
            restaurante.agregarProductoMenu(postre4);
            restaurante.agregarProductoMenu(postre5);

            // Mensaje de bienvenida del sistema.
            JOptionPane.showMessageDialog(null,
                      "=====================================\n"
                    + " BIENVENIDO A " + restaurante.getNombre().toUpperCase() + "\n"
                    + "=====================================\n"
                    + "Sistema de pedidos"
            );

            // Esta variable controla si el sistema sigue recibiendo pedidos.
            boolean continuar = true;

            // Ciclo principal del programa.
            // Permite hacer varios pedidos sin cerrar la aplicación.
            while (continuar) {
                try {
                    // Se solicita el nombre del cliente.
                    String nombreCliente = JOptionPane.showInputDialog(
                            null,
                            "¿A nombre de quién se hará el pedido?"
                    );

                    // Si el usuario cancela, se sale del ciclo principal.
                    if (nombreCliente == null) {
                        break;
                    }

                    // Validación: no se permite un nombre vacío.
                    if (nombreCliente.trim().isEmpty()) {
                        throw new IllegalArgumentException("Debe ingresar el nombre del cliente.");
                    }

                    // Se crea un nuevo pedido con número automático.
                    Pedido pedido = new Pedido(restaurante.generarNumeroOrden(), nombreCliente);

                    // Opciones reutilizables para preguntas de Sí o No.
                    String[] opcionesSiNo = {"Sí", "No"};

                    // ==================================================
                    // ENTRADA OPCIONAL
                    // Si el cliente acepta, se le muestra una lista desplegable.
                    // ==================================================
                    int deseaEntrada = JOptionPane.showOptionDialog(
                            null,
                            "¿Desea agregar una entrada?",
                            "Entrada opcional",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesSiNo,
                            opcionesSiNo[0]
                    );

                    if (deseaEntrada == 0) {
                        Entrada[] opcionesEntrada = {entrada1, entrada2, entrada3};

                        Entrada entradaSeleccionada = (Entrada) JOptionPane.showInputDialog(
                                null,
                                "Seleccione una entrada:",
                                "Menú de entradas",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesEntrada,
                                opcionesEntrada[0]
                        );

                        // Si el usuario selecciona una entrada, se agrega al pedido.
                        if (entradaSeleccionada != null) {
                            pedido.agregarProducto(entradaSeleccionada);
                        }
                    }

                    // ==================================================
                    // PLATO FUERTE OBLIGATORIO
                    // Si el usuario cancela aquí, se genera error porque este dato sí es obligatorio.
                    // ==================================================
                    PlatoFuerte[] opcionesPlato = {plato1, plato2, plato3, plato4, plato5};

                    PlatoFuerte platoSeleccionado = (PlatoFuerte) JOptionPane.showInputDialog(
                            null,
                            "Seleccione un plato fuerte:",
                            "Menú de platos fuertes",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesPlato,
                            opcionesPlato[0]
                    );

                    if (platoSeleccionado == null) {
                        throw new IllegalArgumentException("Debe seleccionar un plato fuerte.");
                    }

                    pedido.agregarProducto(platoSeleccionado);

                    // ==================================================
                    // BEBIDA OBLIGATORIA
                    // Igual que el plato fuerte, es obligatoria en este proyecto.
                    // ==================================================
                    Bebida[] opcionesBebida = {bebida1, bebida2, bebida3, bebida4, bebida5};

                    Bebida bebidaSeleccionada = (Bebida) JOptionPane.showInputDialog(
                            null,
                            "Seleccione una bebida:",
                            "Menú de bebidas",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesBebida,
                            opcionesBebida[0]
                    );

                    if (bebidaSeleccionada == null) {
                        throw new IllegalArgumentException("Debe seleccionar una bebida.");
                    }

                    pedido.agregarProducto(bebidaSeleccionada);

                    // ==================================================
                    // POSTRE OPCIONAL
                    // Si el cliente desea postre, se despliegan las opciones.
                    // ==================================================
                    int deseaPostre = JOptionPane.showOptionDialog(
                            null,
                            "¿Desea agregar un postre?",
                            "Postre opcional",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesSiNo,
                            opcionesSiNo[0]
                    );

                    if (deseaPostre == 0) {
                        Postre[] opcionesPostre = {postre1, postre2, postre3, postre4, postre5};

                        Postre postreSeleccionado = (Postre) JOptionPane.showInputDialog(
                                null,
                                "Seleccione un postre:",
                                "Menú de postres",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesPostre,
                                opcionesPostre[0]
                        );

                        // Si elige uno, se agrega al pedido.
                        if (postreSeleccionado != null) {
                            pedido.agregarProducto(postreSeleccionado);
                        }
                    }

			// ==================================================
			// PROPINA OPCIONAL
			// Si el cliente desea dejar propina, se selecciona de una lista
			// entre 1% y 10% para evitar errores al escribir.
			// ==================================================
			double porcentajePropina = 0;
			
			int deseaPropina = JOptionPane.showOptionDialog(
					null,
					"¿Desea dar propina voluntaria?",
					"Propina",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcionesSiNo,
					opcionesSiNo[0]
			);
			
			if (deseaPropina == 0) {
			
				// Lista de porcentajes disponibles
				String[] opcionesPropina = {"1 %","2 %","3 %","4 %","5 %","6 %","7 %","8 %","9 %","10 %"};
			
				// Se muestra un desplegable con las opciones
				String propinaSeleccionada = (String) JOptionPane.showInputDialog(
						null,
						"Seleccione el porcentaje de propina:",
						"Propina voluntaria",
						JOptionPane.QUESTION_MESSAGE,
						null,
						opcionesPropina,
						opcionesPropina[0]
				);
			
				// Si el usuario selecciona un valor, se guarda
				if (propinaSeleccionada != null) {
					porcentajePropina = Double.parseDouble(propinaSeleccionada.replace(" %",""));
				}
			}

                    // Se calculan subtotal, propina y total.
                    double total=pedido.calcularTotal(porcentajePropina);
                    
                    // Se llama al metodo que guarda la informacion del pedido en archivo
                    pedido.guardarPedido();

                    // El pedido se registra en el restaurante.
                    restaurante.registrarPedido(pedido);

                    // Se muestra el resumen final del pedido.
                    JOptionPane.showMessageDialog(
                            null,
                              "====================================\n"
                            + "        PEDIDO REGISTRADO\n"
                            + "====================================\n\n"
                            + pedido.mostrarResumen()
                            + "\n\nGracias por su pedido.\n"
                            + "Su número de orden es: " + pedido.getNumeroOrden()
                    );

                } catch (IllegalArgumentException e) {
                    // Captura errores de validación más comunes.
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                } catch (Exception e) {
                    // Captura errores inesperados.
                    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage());
                }

                // ==================================================
                // DECISIÓN FINAL
                // Permite hacer otro pedido o cerrar el programa.
                // ==================================================
                String[] opcionesFinales = {"Nuevo pedido", "Cerrar programa"};

                int opcionFinal = JOptionPane.showOptionDialog(
                        null,
                        "¿Qué desea hacer ahora?",
                        "Continuar o salir",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesFinales,
                        opcionesFinales[0]
                );

                if (opcionFinal != 0) {
                    continuar = false;
                }
            }

            // Resumen final del sistema al cerrar.
            JOptionPane.showMessageDialog(
                    null,
                    "=================================\n"
                    + "     CIERRE DEL PROGRAMA\n"
                    + "=================================\n"
                    + "Pedidos realizados: " + restaurante.getPedidos().size() + "\n"
                    + "Ganancias totales: $" + restaurante.getGananciasTotales()
            );
            
            // Apertura del archivo de pedidos
            Pedido.abrirArchivoPedidos();

        } catch (Exception e) {
            // Captura un error general del sistema en caso de que ocurra algo fuera de lo esperado.
            JOptionPane.showMessageDialog(null, "Error general del sistema: " + e.getMessage());
        }
    }
}