/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo3;

/**
 *
 * @author estefaniamazariegos
 */
import java.util.Scanner;

public class Ejemplo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String NOMBRE_TIENDA = "Tienda Doña Mary";
        final double IVA = 0.12;
        final int STOCK_MINIMO = 5;

        // ---------- Inventario ----------
        String producto1 = "Agua pura 600ml";
        double precio1 = 8.00;
        int stock1 = 30;

        String producto2 = "Pan dulce";
        double precio2 = 1.50;
        int stock2 = 40;

        String producto3 = "Frijoles 400g";
        double precio3 = 12.75;
        int stock3 = 5;

        // ---------- Contadores y acumuladores----------
        int ventasRealizadas = 0;      // contador
        int unidadesVendidas = 0;      // acumulador
        double totalVendido = 0;       // acumulador
        double totalDescuentos = 0;    // acumulador

        int opcionMenu;

        // ================= MENÚ PRINCIPAL =================
        do {
            System.out.println();
            System.out.println("=================================");
            System.out.println("     " + NOMBRE_TIENDA);
            System.out.println("=================================");
            System.out.println("1. Vender");
            System.out.println("2. Ver inventario");
            System.out.println("3. Resumen del día");
            System.out.println("4. Cerrar caja y salir");
            System.out.print("Elige una opción: ");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {

                // ----------------------- VENDER -----------------------
                case 1:
                    System.out.printf("1. %-18s Q%6.2f (stock: %d)%n", producto1, precio1, stock1);
                    System.out.printf("2. %-18s Q%6.2f (stock: %d)%n", producto2, precio2, stock2);
                    System.out.printf("3. %-18s Q%6.2f (stock: %d)%n", producto3, precio3, stock3);
                    // Pedir el producto HASTA que sea válido
                    int opcionProducto;
                    do {
                        System.out.print("Producto (1-3): ");
                        opcionProducto = sc.nextInt();
                    } while (opcionProducto < 1 || opcionProducto > 3);

                    String producto = "";
                    double precio = 0;
                    int stock = 0;
                    switch (opcionProducto) {
                        case 1:
                            producto = producto1; precio = precio1; stock = stock1;
                            break;
                        case 2:
                            producto = producto2; precio = precio2; stock = stock2;
                            break;
                        case 3:
                            producto = producto3; precio = precio3; stock = stock3;
                            break;
                    }

                    if (stock == 0) {
                        System.out.println(producto + " está agotado.");
                        break;
                    }

                    // Pedir la cantidad HASTA que sea válida
                    int cantidad;
                    do {
                        System.out.print("Cantidad (1 a " + stock + "): ");
                        cantidad = sc.nextInt();
                        if (cantidad < 1 || cantidad > stock) {
                            System.out.println("Cantidad no válida.");
                        }
                    } while (cantidad < 1 || cantidad > stock);

                    double subtotal = precio * cantidad;

                    // Descuento por monto (else if)
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
                    System.out.printf("%-18s %3d x Q%6.2f%n", producto, cantidad, precio);
                    System.out.printf("Subtotal:          Q%8.2f%n", subtotal);
                    if (descuento > 0) {
                        String etiqueta = "Descuento (" + Math.round(porcentaje * 100) + "%):";
                        System.out.printf("%-18s-Q%8.2f%n", etiqueta, descuento);
                    }
                    System.out.printf("Sin IVA:           Q%8.2f%n", sinIva);
                    System.out.printf("IVA incluido (12%%):Q%8.2f%n", total - sinIva);
                    System.out.printf("TOTAL:             Q%8.2f%n", total);
                    System.out.println("---------------------------------");

                    // Forma de pago: se repite hasta que sea E o T
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

                    // Descontar el stock del producto vendido
                    switch (opcionProducto) {
                        case 1: stock1 -= cantidad; stock = stock1; break;
                        case 2: stock2 -= cantidad; stock = stock2; break;
                        case 3: stock3 -= cantidad; stock = stock3; break;
                    }

                    // alerta de stock bajo
                    if (stock < STOCK_MINIMO) {
                        System.out.println("ALERTA: quedan " + stock + " de " + producto + ". Pedir más producto.");
                    }

                    // Actualizar contadores y acumuladores
                    ventasRealizadas++;
                    unidadesVendidas += cantidad;
                    totalVendido += total;
                    totalDescuentos += descuento;

                    System.out.println("¡Venta registrada!");
                    break;

                // ----------------------- INVENTARIO -----------------------
                case 2:
                    System.out.println("--- Inventario ---");
                    System.out.printf("%-18s %5d unidades%n", producto1, stock1);
                    System.out.printf("%-18s %5d unidades%n", producto2, stock2);
                    System.out.printf("%-18s %5d unidades%n", producto3, stock3);
                    break;

                // ----------------------- RESUMEN -----------------------
                case 3:
                    System.out.println("--- Resumen del día ---");
                    System.out.println("Ventas realizadas: " + ventasRealizadas);
                    System.out.println("Unidades vendidas: " + unidadesVendidas);
                    System.out.printf("Descuentos dados:  Q%.2f%n", totalDescuentos);
                    System.out.printf("Total vendido:     Q%.2f%n", totalVendido);
                    if (ventasRealizadas > 0) {
                        System.out.printf("Venta promedio:    Q%.2f%n", totalVendido / ventasRealizadas);
                    }
                    break;

                // ----------------------- SALIR -----------------------
                case 4:
                    System.out.println("Cerrando caja...");
                    System.out.printf("Hoy se vendieron Q%.2f en %d ventas.%n", totalVendido, ventasRealizadas);
                    System.out.println("¡Hasta mañana!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcionMenu != 4);
    }
}
