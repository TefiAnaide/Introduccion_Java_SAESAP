/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo4;

import java.util.Scanner;
/**
 *
 * @author estefaniamazariegos
 */
public class Ejemplo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String NOMBRE_TIENDA = "Tienda Doña Mary";
        final double IVA = 0.12;
        final int STOCK_MINIMO = 5;
        final int CAPACIDAD = 10;

        // ---------- Inventario en vectores paralelos ----------
        String[] nombres = new String[CAPACIDAD];
        double[] precios = new double[CAPACIDAD];
        int[] stock = new int[CAPACIDAD];
        int totalProductos = 0;   // cuántas posiciones están ocupadas

        // Productos iniciales
        nombres[0] = "Agua pura 600ml"; precios[0] = 8.00;  stock[0] = 30;
        nombres[1] = "Pan dulce";       precios[1] = 1.50;  stock[1] = 40;
        nombres[2] = "Frijoles 400g";   precios[2] = 12.75; stock[2] = 5;
        totalProductos = 3;

        // ---------- Contadores y acumuladores ----------
        int ventasRealizadas = 0;
        int unidadesVendidas = 0;
        double totalVendido = 0;

        int opcionMenu;

        do {
            System.out.println();
            System.out.println("=================================");
            System.out.println("     " + NOMBRE_TIENDA);
            System.out.println("=================================");
            System.out.println("1. Vender");
            System.out.println("2. Ver inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Agregar producto");
            System.out.println("5. Resumen del día");
            System.out.println("6. Cerrar caja y salir");
            System.out.print("Elige una opción: ");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {

                // ----------------------- VENDER -----------------------
                case 1:
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.printf("%d. %-18s Q%6.2f (stock: %d)%n",
                                i + 1, nombres[i], precios[i], stock[i]);
                    }

                    int opcionProducto;
                    do {
                        System.out.print("Producto (1-" + totalProductos + "): ");
                        opcionProducto = sc.nextInt();
                    } while (opcionProducto < 1 || opcionProducto > totalProductos);

                    int p = opcionProducto - 1;   // la posición en el vector empieza en 0

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
                        System.out.printf("%-18s Q%6.2f %5d unidades%n", nombres[i], precios[i], stock[i]);
                        valorInventario += precios[i] * stock[i];
                    }
                    System.out.printf("Valor del inventario: Q%.2f%n", valorInventario);
                    break;

                // ----------------------- BUSCAR -----------------------
                case 3:
                    sc.nextLine();   // limpia el Enter que dejó nextInt()
                    System.out.print("Nombre del producto: ");
                    String buscado = sc.nextLine();

                    int posicion = -1;
                    for (int i = 0; i < totalProductos; i++) {
                        if (nombres[i].equalsIgnoreCase(buscado)) {   // ignora mayúsculas
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

                    // ¿Ya existe? Reutilizamos la búsqueda lineal
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

                    // Se guarda en la primera posición libre: totalProductos
                    nombres[totalProductos] = nuevoNombre;
                    precios[totalProductos] = nuevoPrecio;
                    stock[totalProductos] = nuevoStock;
                    totalProductos++;
                    System.out.println("Producto agregado en la posición " + (totalProductos - 1) + ".");
                    break;

                // ----------------------- RESUMEN -----------------------
                case 5:
                    System.out.println("--- Resumen del día ---");
                    System.out.println("Ventas realizadas: " + ventasRealizadas);
                    System.out.println("Unidades vendidas: " + unidadesVendidas);
                    System.out.printf("Total vendido:     Q%.2f%n", totalVendido);
                    if (ventasRealizadas > 0) {
                        System.out.printf("Venta promedio:    Q%.2f%n", totalVendido / ventasRealizadas);
                    }
                    // Producto con menos stock (algoritmo del menor)
                    int menor = 0;
                    for (int i = 1; i < totalProductos; i++) {
                        if (stock[i] < stock[menor]) {
                            menor = i;
                        }
                    }
                    System.out.println("Producto con menos stock: " + nombres[menor] + " (" + stock[menor] + ")");
                    break;

                // ----------------------- SALIR -----------------------
                case 6:
                    System.out.printf("Cerrando caja. Hoy se vendieron Q%.2f en %d ventas.%n",
                            totalVendido, ventasRealizadas);
                    System.out.println("¡Hasta mañana!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcionMenu != 6);

        sc.close();
    }
}
