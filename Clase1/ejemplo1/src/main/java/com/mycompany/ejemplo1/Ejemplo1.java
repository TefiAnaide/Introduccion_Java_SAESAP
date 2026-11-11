/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/*
 * PROYECTO DEL CURSO: TiendaApp — Sistema de ventas para una tienda de barrio
 * Versión 0.1 (Día 1): variables, tipos de datos y operaciones
 *
 * Hoja de ruta del proyecto:
 *   v0.1  Variables        -> ficha de productos y ticket de una venta
 *   v0.2  if / switch      -> descuentos, menú de opciones, validar stock
 *   v0.3  Ciclos           -> menú que se repite, vender varios productos
 *   v0.4  Vectores         -> inventario completo, buscar productos
 *   v0.5  POO              -> clases Producto, Venta, Tienda
 *   v0.6  Excepciones      -> entradas inválidas sin que el programa explote
 *   v0.7  Archivos         -> guardar y cargar el inventario y las ventas
 */

package com.mycompany.ejemplo1;

/**
 *
 * @author estefaniamazariegos
 */
public class Ejemplo1 {

    public static void main(String[] args) {
        // ---------- Datos de la tienda (constantes) ----------
        final String NOMBRE_TIENDA = "Tienda Doña Mary";
        final double IVA = 0.12;
 
        // ---------- Producto 1 ----------
        String producto1 = "Agua pura 600ml";
        double precio1 = 8.00;
        int cantidad1 = 2;
 
        // ---------- Producto 2 ----------
        String producto2 = "Pan dulce";
        double precio2 = 1.50;
        int cantidad2 = 6;
 
        // ---------- Producto 3 ----------
        String producto3 = "Frijoles 400g";
        double precio3 = 12.75;
        int cantidad3 = 1;
 
        // ---------- Cálculos ----------
        double subtotal1 = precio1 * cantidad1;
        double subtotal2 = precio2 * cantidad2;
        double subtotal3 = precio3 * cantidad3;
 
        // En Guatemala los precios ya incluyen IVA, así que lo "desglosamos"
        double total = subtotal1 + subtotal2 + subtotal3;
        double subtotal = total / (1 + IVA);   // precio sin IVA
        double impuesto = total - subtotal;    // IVA incluido en el total
        int articulos = cantidad1 + cantidad2 + cantidad3;
 
        // ---------- Ticket ----------
        System.out.println("=================================");
        System.out.println("     " + NOMBRE_TIENDA);
        System.out.println("=================================");
        System.out.printf("%-18s %3d x Q%6.2f%n", producto1, cantidad1, precio1);
        System.out.printf("%-18s %3d x Q%6.2f%n", producto2, cantidad2, precio2);
        System.out.printf("%-18s %3d x Q%6.2f%n", producto3, cantidad3, precio3);
        System.out.println("---------------------------------");
        System.out.printf("Artículos:            %d%n", articulos);
        System.out.printf("Sin IVA:           Q%8.2f%n", subtotal);
        System.out.printf("IVA incluido (12%%):Q%8.2f%n", impuesto);
        System.out.printf("TOTAL:             Q%8.2f%n", total);
        System.out.println("=================================");
        System.out.println("     ¡Gracias por su compra!");
    }
}
