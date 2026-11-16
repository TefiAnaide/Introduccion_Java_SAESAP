/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase3;

/**
 *
 * @author estefaniamazariegos
 */
import java.util.Scanner;

public class Clase3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //--- ciclo for
        /*System.out.println("¿que tabla desea ver? ");
        int tabla = sc.nextInt();
        for (int i = 1; i <= 12; i++) {
            System.out.println(tabla + " x " + i + " = " + (tabla * i));
        }*/
        
        //--- ciclo while
        /*int contador = 0; 
        double suma = 0;
        System.out.println("Ingrese 0 para terminar: ");
        double precio = sc.nextDouble();
        while (precio != 0) {
            contador++;
            //suma = suma + precio;
            suma += precio;
            System.out.println("precio: (ingresar 0 para terminar) ");
            precio = sc.nextDouble();
        }
        System.out.println("contador: " + contador);
        System.out.printf("Total: %.2f%n", suma);*/
        
        //---- do while
        /*int edad;
        do {
            System.out.println("Ingrese una edad entre 18 y 50:");
            edad = sc.nextInt();
            System.out.println("edad ingresada: " + edad);
        } while (edad < 18 || edad > 50);*/
        
        // ejemplos de break y continue
        /*for (int n = 1; n <= 10; n++) {
            if (n % 3 == 0) {
                continue;
            }
            System.out.println(n);
        }
        
        for (int n = 51; n <= 100; n++) {
            if (n % 7 == 0) {
                System.out.println("Primer múltiplo de 7 después de 50: " + n);
                break;
            }
        }*/
        
        /*int k = 10;
        while (k > 5) {
            System.out.println(k);
            k--; // k = k - 1;
        }*/
        
        //---- ejemplos de menús
        ///------ versión 1: while
        /*int opcion = 0;
        while (opcion!= 3) {
            System.out.println("--- MENÚ ---");
            System.out.println("1. Saludar");
            System.out.println("2. Despedirse");
            System.out.println("3. salir");
            System.out.println("Ingrese una opción: ");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1: 
                    System.out.println("!HOLA CLASE!");
                    break;
                case 2:
                    System.out.println("!Adiós clase!");
                    break;
                case 3:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        
        // ejemplo versión 2: do-while
        int opcion2;
        do {
            System.out.println("--- MENÚ 2---");
            System.out.println("1. Saludar");
            System.out.println("2. Despedirse");
            System.out.println("3. salir");
            System.out.println("Ingrese una opción: ");
            
            opcion2 = sc.nextInt();
            
            switch (opcion2) {
                case 1: 
                    System.out.println("!HOLA CLASE!");
                    break;
                case 2:
                    System.out.println("!Adiós clase!");
                    break;
                case 3:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion2 != 3);*/
        
        // ejemplos utilizando Math
        System.out.println("Math.pow(2, 10) -> potencia = " + Math.pow(2, 10));
        System.out.println("Math.sqrt(81) -> raiz cuadrada = " + Math.sqrt(81));
        System.out.println("Math.abs(-15) -> valor absoluto = " + Math.abs(-15));
        System.out.println("Math.max(8, 3) -> máximos = " + Math.max(8, 3));
        System.out.println("Math.min(8, 3) -> mínimos = " + Math.min(8, 3));
        System.out.println("Math.round(4.6) -> redondear aproximar = " + Math.round(4.6));
        System.out.println("Math.PI -> para el valor de pi " + Math.PI);
        
        // POTENCIA con ciclo for
        double base = 2;
        int exponente = 10;
        double resultado = 1;            // empieza en 1, no en 0
        for (int i = 1; i <= exponente; i++) {
            resultado *= base;           // resultado = resultado * base
        }
        System.out.println("2^10 con un for   = " + resultado);
    }
}
