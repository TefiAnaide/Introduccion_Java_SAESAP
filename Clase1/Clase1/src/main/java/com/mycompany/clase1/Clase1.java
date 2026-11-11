/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase1;

/**
 *
 * @author estefaniamazariegos
 */
public class Clase1 {

    public static void main(String[] args) {
        int edad;
        edad = 20;
        
        System.out.println("nuestra primera variable: " + edad); // System empieza con mayuscula
        
        int cantidad = 50; // declaración de una variable entera 
        double precio = 12.5; // declaración de un número decimal
        char letra = '?'; //declaración de un solo caracter
        String nombre = "Estefania Mazarigos - clase 1"; //declaración de una cadena de texto
        boolean aprobado = true;

        /*System.out.println("impresion de variables: nombre:" + nombre + " cantidad: " + cantidad + " precio: " + precio);
        System.out.println("letra: " + letra + "" + aprobado);
        System.out.println(aprobado);*/
        
        /*
        Operaciones aritméticas
        Ejemplos: 
        */
        
        int a = 17;
        int b = 5;
        double c = 3;
        
        System.out.println("división: " + ((double) a / b));
        System.out.println("división: " + ( a / b));
        System.out.println("división: " + (a / c));
        
        System.out.println("suma: " + ( a + b));
        System.out.println("resta: " + ( a - b));
        System.out.println("multiplicación: " + ( a * b));
        System.out.println("residuo: " + ( a % b));
        
        /*constante*/
        
        final double DESCUENTO = 0.15; // <- es un valor fijo
        
        double total = cantidad * precio * (1 - DESCUENTO);
        
        System.out.printf("total: %.2f%n", total); //printf -> formatos al momento de imprimir
    }
}
