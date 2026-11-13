/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo2;

/*
* importar librerias: 
* librería para obtener un dato del usuario
*/
import java.util.Scanner;

/**
 *
 * @author estefaniamazariegos
 */
public class Ejemplo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
         // ---------- Datos de la tienda (constantes) ----------
        final String NOMBRE_TIENDA = "Tienda Doña Mary";
        final double IVA = 0.12;
 
        // ---------- Inventario (por ahora, en variables) ----------
        String producto1 = "Agua pura 600ml";
        double precio1 = 8.00;
        int stock1 = 30;

        String producto2 = "Pan dulce";
        double precio2 = 1.50;
        int stock2 = 40;

        String producto3 = "Frijoles 400g";
        double precio3 = 12.75;
        int stock3 = 5;
        
        // ---------- Menú ----------
        System.out.println("=================================");
        System.out.println("     " + NOMBRE_TIENDA);
        System.out.println("=================================");
        System.out.printf("1. %-18s Q%6.2f (stock: %d)%n", producto1, precio1, stock1);
        System.out.printf("2. %-18s Q%6.2f (stock: %d)%n", producto2, precio2, stock2);
        System.out.printf("3. %-18s Q%6.2f (stock: %d)%n", producto3, precio3, stock3);
        System.out.print("Elige un producto (1-3): "); //print en lugar de println no hace el salto de línea
        int opcion = sc.nextInt();
        
        // ---------- switch: según la opción, tomamos los datos del producto ----------
        String producto;
        double precio;
        int stock;

        switch (opcion) {
            case 1:
                producto = producto1;
                precio = precio1;
                stock = stock1;
                break;
            case 2:
                producto = producto2;
                precio = precio2;
                stock = stock2;
                break;
            case 3:
                producto = producto3;
                precio = precio3;
                stock = stock3;
                break;
            default:
                System.out.println("Opción inválida. Venta cancelada.");
                return;   // termina el programa
        }

        System.out.print("¿Cuántas unidades de " + producto + "? ");
        int cantidad = sc.nextInt();
        
        // ---------- if: validaciones, para verificar si hay en stock ----------
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0. Venta cancelada.");
            return;
        }
        if (cantidad > stock) {
            System.out.println("Solo hay " + stock + " unidades. Venta cancelada.");
            return;
        }
        
        double total = precio * cantidad;
        
        // ---------- else if: descuento según el monto ----------
        double porcentajeDescuento;
        if (total >= 200) {
            porcentajeDescuento = 0.10;
        } else if (total >= 100) {
            porcentajeDescuento = 0.05;
        } else {
            porcentajeDescuento = 0;
        }
        double descuento = total * porcentajeDescuento;
        double totalPagar = total - descuento;
        double sinIva = totalPagar / (1 + IVA);
        double impuesto = totalPagar - sinIva;
        
        // ---------- Ticket ----------
        System.out.println("---------------------------------");
        System.out.printf("%-18s %3d x Q%6.2f%n", producto, cantidad, precio);
        System.out.printf("Subtotal:          Q%8.2f%n", total);
        if (descuento > 0) {
            String etiqueta = "Descuento (" + (int) (porcentajeDescuento * 100) + "%):";
            System.out.printf("%-18s-Q%8.2f%n", etiqueta, descuento);
        }
        System.out.printf("Sin IVA:           Q%8.2f%n", sinIva);
        System.out.printf("IVA incluido (12%%):Q%8.2f%n", impuesto);
        System.out.printf("TOTAL:             Q%8.2f%n", totalPagar);
        System.out.println("---------------------------------");
        
        // ---------- switch: forma de pago ----------
        System.out.print("Forma de pago (E = efectivo, T = tarjeta): ");
        char formaPago = sc.next().toUpperCase().charAt(0);

        switch (formaPago) {
            case 'E':
                System.out.print("¿Con cuánto paga? Q");
                double pago = sc.nextDouble();
                //para verificar el efectivo recibido
                if (pago >= totalPagar) {
                    System.out.printf("Vuelto: Q%.2f%n", pago - totalPagar);
                } else {
                    System.out.printf("Faltan Q%.2f. Venta cancelada.%n", totalPagar - pago);
                    return;
                }
                break;
            case 'T':
                System.out.println("Pago con tarjeta aprobado.");
                break;
            default:
                System.out.println("Forma de pago no válida. Venta cancelada.");
                return;
        }

        stock = stock - cantidad;
        System.out.println("Quedan " + stock + " unidades de " + producto + ".");
        System.out.println("=================================");
        System.out.println("     ¡Gracias por su compra!");
    }
}
