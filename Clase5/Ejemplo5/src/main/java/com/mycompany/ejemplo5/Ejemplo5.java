/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo5;

/**
 *
 * @author estefaniamazariegos
 */

import java.util.Scanner;
public class Ejemplo5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String NOMBRE_TIENDA = "Tienda Doña Mary";
        final double IVA = 0.12;
        final int STOCK_MINIMO = 5;
        final int CAPACIDAD = 10;
        final String[] DIAS = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};

        // ---------- Inventario en vectores paralelos ----------
        String[] nombres = new String[CAPACIDAD];
        double[] precios = new double[CAPACIDAD];
        int[] stock = new int[CAPACIDAD];
        int totalProductos;

        nombres[0] = "Agua pura 600ml"; precios[0] = 8.00;  stock[0] = 30;
        nombres[1] = "Pan dulce";       precios[1] = 1.50;  stock[1] = 40;
        nombres[2] = "Frijoles 400g";   precios[2] = 12.75; stock[2] = 8;
        totalProductos = 3;

        // ---------- Matriz: unidades vendidas [producto][día] ----------
        int[][] ventasSemana = new int[CAPACIDAD][7];
        // Ventas de lunes y martes (para que el reporte tenga datos)
        ventasSemana[0][0] = 6;  ventasSemana[0][1] = 4;
        ventasSemana[1][0] = 20; ventasSemana[1][1] = 15;
        ventasSemana[2][0] = 2;  ventasSemana[2][1] = 3;
        int diaActual = 2;   // hoy es miércoles

        // ---------- Contadores y acumuladores del día ----------
        int ventasRealizadas = 0;
        int unidadesVendidas = 0;
        double totalVendido = 0;

        int opcionMenu;

        do {
            System.out.println();
            System.out.println("=================================");
            System.out.println("     " + NOMBRE_TIENDA + " · " + DIAS[diaActual]);
            System.out.println("=================================");
            System.out.println("1. Vender");
            System.out.println("2. Ver inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Agregar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Ordenar inventario por precio");
            System.out.println("7. Reporte semanal");
            System.out.println("8. Cerrar día");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {

                // ----------------------- VENDER -----------------------
                case 1:
                    if (totalProductos == 0) {
                        System.out.println("No hay productos en el inventario.");
                        break;
                    }
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.printf("%d. %-18s Q%6.2f (stock: %d)%n",
                                i + 1, nombres[i], precios[i], stock[i]);
                    }
                    int opcionProducto;
                    do {
                        System.out.print("Producto (1-" + totalProductos + "): ");
                        opcionProducto = sc.nextInt();
                    } while (opcionProducto < 1 || opcionProducto > totalProductos);
                    int p = opcionProducto - 1;

                    if (stock[p] == 0) {
                        System.out.println(nombres[p] + " está agotado.");
                        break;
                    }

                    int cantidad;
                    do {
                        System.out.print("Cantidad (1 a " + stock[p] + "): ");
                        cantidad = sc.nextInt();
                    } while (cantidad < 1 || cantidad > stock[p]);

                    double subtotal = precios[p] * cantidad;
                    double porcentaje;
                    if (subtotal >= 200) {
                        porcentaje = 0.10;
                    } else if (subtotal >= 100) {
                        porcentaje = 0.05;
                    } else {
                        porcentaje = 0;
                    }
                    System.out.print("¿Tiene tarjeta de cliente frecuente? (S/N): ");
                    char frecuente = sc.next().toUpperCase().charAt(0);
                    if (frecuente == 'S') {
                        porcentaje += 0.05;
                    }

                    double descuento = subtotal * porcentaje;
                    double total = subtotal - descuento;
                    double sinIva = total / (1 + IVA);

                    System.out.println("---------------------------------");
                    System.out.printf("%-18s %3d x Q%6.2f%n", nombres[p], cantidad, precios[p]);
                    System.out.printf("Subtotal:          Q%8.2f%n", subtotal);
                    if (descuento > 0) {
                        String etiqueta = "Descuento (" + Math.round(porcentaje * 100) + "%):";
                        System.out.printf("%-18s-Q%8.2f%n", etiqueta, descuento);
                    }
                    System.out.printf("Sin IVA:           Q%8.2f%n", sinIva);
                    System.out.printf("IVA incluido (12%%):Q%8.2f%n", total - sinIva);
                    System.out.printf("TOTAL:             Q%8.2f%n", total);
                    System.out.println("---------------------------------");

                    char formaPago;
                    do {
                        System.out.print("Forma de pago (E = efectivo, T = tarjeta): ");
                        formaPago = sc.next().toUpperCase().charAt(0);
                    } while (formaPago != 'E' && formaPago != 'T');

                    if (formaPago == 'E') {
                        double pago;
                        do {
                            System.out.print("¿Con cuánto paga? Q");
                            pago = sc.nextDouble();
                            if (pago < total) {
                                System.out.printf("Faltan Q%.2f.%n", total - pago);
                            }
                        } while (pago < total);
                        System.out.printf("Vuelto: Q%.2f%n", pago - total);
                    } else {
                        System.out.println("Pago con tarjeta aprobado.");
                    }

                    stock[p] -= cantidad;
                    ventasSemana[p][diaActual] += cantidad;   // NUEVO: se anota en la matriz

                    if (stock[p] < STOCK_MINIMO) {
                        System.out.println("ALERTA: quedan " + stock[p] + " de " + nombres[p] + ". Pedir más producto.");
                    }
                    ventasRealizadas++;
                    unidadesVendidas += cantidad;
                    totalVendido += total;
                    System.out.println("¡Venta registrada!");
                    break;

                // ----------------------- INVENTARIO -----------------------
                case 2:
                    System.out.println("--- Inventario (" + totalProductos + " de " + CAPACIDAD + " espacios) ---");
                    double valorInventario = 0;
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.printf("%d. %-18s Q%6.2f %5d unidades%n", i + 1, nombres[i], precios[i], stock[i]);
                        valorInventario += precios[i] * stock[i];
                    }
                    System.out.printf("Valor del inventario: Q%.2f%n", valorInventario);
                    break;

                // ----------------------- BUSCAR -----------------------
                case 3:
                    sc.nextLine();
                    System.out.print("Nombre del producto: ");
                    String buscado = sc.nextLine();
                    int posicion = -1;
                    for (int i = 0; i < totalProductos; i++) {
                        if (nombres[i].equalsIgnoreCase(buscado)) {
                            posicion = i;
                            break;
                        }
                    }
                    if (posicion != -1) {
                        System.out.printf("Encontrado: %s | Q%.2f | stock: %d%n",
                                nombres[posicion], precios[posicion], stock[posicion]);
                    } else {
                        System.out.println("No existe un producto llamado \"" + buscado + "\".");
                    }
                    break;

                // ----------------------- AGREGAR -----------------------
                case 4:
                    if (totalProductos == CAPACIDAD) {
                        System.out.println("El inventario está lleno (" + CAPACIDAD + " productos).");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Nombre del nuevo producto: ");
                    String nuevoNombre = sc.nextLine();
                    boolean existe = false;
                    for (int i = 0; i < totalProductos; i++) {
                        if (nombres[i].equalsIgnoreCase(nuevoNombre)) {
                            existe = true;
                            break;
                        }
                    }
                    if (existe) {
                        System.out.println("Ese producto ya está en el inventario.");
                        break;
                    }
                    double nuevoPrecio;
                    do {
                        System.out.print("Precio: Q");
                        nuevoPrecio = sc.nextDouble();
                    } while (nuevoPrecio <= 0);
                    int nuevoStock;
                    do {
                        System.out.print("Stock inicial: ");
                        nuevoStock = sc.nextInt();
                    } while (nuevoStock < 0);

                    nombres[totalProductos] = nuevoNombre;
                    precios[totalProductos] = nuevoPrecio;
                    stock[totalProductos] = nuevoStock;
                    // su fila de ventasSemana ya está en ceros
                    totalProductos++;
                    System.out.println("Producto agregado.");
                    break;

                // ----------------------- ELIMINAR -----------------------
                case 5:
                    if (totalProductos == 0) {
                        System.out.println("No hay productos para eliminar.");
                        break;
                    }
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.println((i + 1) + ". " + nombres[i]);
                    }
                    int opcionEliminar;
                    do {
                        System.out.print("Producto a eliminar (1-" + totalProductos + "): ");
                        opcionEliminar = sc.nextInt();
                    } while (opcionEliminar < 1 || opcionEliminar > totalProductos);
                    int e = opcionEliminar - 1;

                    System.out.print("¿Seguro que quieres eliminar " + nombres[e] + "? (S/N): ");
                    char confirmar = sc.next().toUpperCase().charAt(0);
                    if (confirmar != 'S') {
                        System.out.println("No se eliminó nada.");
                        break;
                    }
                    String eliminado = nombres[e];

                    // Correr a la izquierda todo lo que está después de e
                    for (int i = e; i < totalProductos - 1; i++) {
                        nombres[i] = nombres[i + 1];
                        precios[i] = precios[i + 1];
                        stock[i] = stock[i + 1];
                        ventasSemana[i] = ventasSemana[i + 1];   // la FILA completa
                    }
                    // Limpiar la última posición
                    nombres[totalProductos - 1] = null;
                    precios[totalProductos - 1] = 0;
                    stock[totalProductos - 1] = 0;
                    ventasSemana[totalProductos - 1] = new int[7];
                    totalProductos--;
                    System.out.println(eliminado + " fue eliminado.");
                    break;

                // ----------------------- ORDENAR (burbuja) -----------------------
                case 6:
                    for (int pasada = 0; pasada < totalProductos - 1; pasada++) {
                        for (int j = 0; j < totalProductos - 1 - pasada; j++) {
                            if (precios[j] > precios[j + 1]) {
                                // Se mueve TODO lo del producto, no solo el precio
                                double tPrecio = precios[j];
                                precios[j] = precios[j + 1];
                                precios[j + 1] = tPrecio;

                                String tNombre = nombres[j];
                                nombres[j] = nombres[j + 1];
                                nombres[j + 1] = tNombre;

                                int tStock = stock[j];
                                stock[j] = stock[j + 1];
                                stock[j + 1] = tStock;

                                int[] tFila = ventasSemana[j];
                                ventasSemana[j] = ventasSemana[j + 1];
                                ventasSemana[j + 1] = tFila;
                            }
                        }
                    }
                    System.out.println("Inventario ordenado de menor a mayor precio:");
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.printf("%d. %-18s Q%6.2f%n", i + 1, nombres[i], precios[i]);
                    }
                    break;

                // ----------------------- REPORTE SEMANAL (matriz) -----------------------
                case 7:
                    System.out.println("--- Unidades vendidas en la semana ---");
                    System.out.printf("%-18s", "Producto");
                    for (int d = 0; d < 7; d++) {
                        System.out.printf("%5s", DIAS[d]);
                    }
                    System.out.printf("%7s%n", "Total");

                    int masVendido = -1;
                    int maxUnidades = -1;
                    for (int i = 0; i < totalProductos; i++) {           // filas
                        System.out.printf("%-18s", nombres[i]);
                        int totalProducto = 0;
                        for (int d = 0; d < 7; d++) {                    // columnas
                            System.out.printf("%5d", ventasSemana[i][d]);
                            totalProducto += ventasSemana[i][d];
                        }
                        System.out.printf("%7d%n", totalProducto);
                        if (totalProducto > maxUnidades) {
                            maxUnidades = totalProducto;
                            masVendido = i;
                        }
                    }

                    System.out.printf("%-18s", "Total del día");
                    int totalSemana = 0;
                    for (int d = 0; d < 7; d++) {                        // columnas primero
                        int totalDia = 0;
                        for (int i = 0; i < totalProductos; i++) {
                            totalDia += ventasSemana[i][d];
                        }
                        System.out.printf("%5d", totalDia);
                        totalSemana += totalDia;
                    }
                    System.out.printf("%7d%n", totalSemana);

                    if (masVendido != -1) {
                        System.out.println("Producto más vendido: " + nombres[masVendido]
                                + " (" + maxUnidades + " unidades)");
                    }
                    break;

                // ----------------------- CERRAR DÍA -----------------------
                case 8:
                    System.out.println("--- Resumen del " + DIAS[diaActual] + " ---");
                    System.out.println("Ventas realizadas: " + ventasRealizadas);
                    System.out.println("Unidades vendidas: " + unidadesVendidas);
                    System.out.printf("Total vendido:     Q%.2f%n", totalVendido);
                    if (totalProductos > 0) {
                        int menor = 0;
                        for (int i = 1; i < totalProductos; i++) {
                            if (stock[i] < stock[menor]) {
                                menor = i;
                            }
                        }
                        System.out.println("Producto con menos stock: " + nombres[menor] + " (" + stock[menor] + ")");
                    }
                    // Reiniciar contadores del día y pasar al siguiente
                    ventasRealizadas = 0;
                    unidadesVendidas = 0;
                    totalVendido = 0;
                    if (diaActual < 6) {
                        diaActual++;
                    } else {
                        System.out.println("Terminó la semana. El reporte empieza de nuevo.");
                        diaActual = 0;
                        ventasSemana = new int[CAPACIDAD][7];
                    }
                    System.out.println("Abriendo el " + DIAS[diaActual] + "...");
                    break;

                // ----------------------- SALIR -----------------------
                case 9:
                    System.out.println("¡Hasta mañana!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcionMenu != 9);
    }
}
