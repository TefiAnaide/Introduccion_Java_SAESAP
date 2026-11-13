/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase2;

/*
* importar librerias: 
* librería para obtener un dato del usuario
*/
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author estefaniamazariegos
 */
public class Clase2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /*System.out.println("ingrese un número entero: ");
        int numero = sc.nextInt();
        System.out.println("numero ingresado: " + numero);
        
        System.out.println("ingrese un número con decimales: ");
        sc.useLocale(Locale.US); // para que acepte el punto en lugar de una coma
        double decimal = sc.nextDouble();
        System.out.println("número ingresado: " + decimal);
        
        System.out.println("ingrese una cadena de texto: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        System.out.println("nombre ingresado: " + nombre);
    
        System.out.println("ingrese una letra: ");
        char letra = sc.next().charAt(0);
        System.out.println("letra ingresada: " + letra);
    
        System.out.println("Ingrese true o false: ");
        boolean esVerdad = sc.nextBoolean();
        System.out.println("respuesta: " + esVerdad);*/
        
        // ----- decisores -----
        /*System.out.println("ingrese edad1: ");
        int edad = sc.nextInt();
        System.out.println("edad1: " + edad);
        System.out.println("ingrese edad2: ");
        int edad2 = sc.nextInt();
        System.out.println("edad2: " + edad2);
        
        if (edad >= 18) {
            System.out.println("Es mayor de edad");
        } 
  
        if (edad2 >= 18) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
        
        if (edad != edad2) {
            System.out.println("edades no iguales");
        } else {
            System.out.println("edades iguales");
        }
        
        String dia = "sabado";
        String dia2 = "sabado";
        if (dia.equals(dia2)) {
            System.out.println("es el mismo día");
        } else {
            System.out.println("dias diferentes");
        }
        
        // y (and) -> &&
        // o (or) -> ||
        // no (not) -> !
        if (dia.equals(dia2) && (edad > 18)) {
            System.out.println("mismo día y mayor de edad");
        }
        
        int cantidad1 = 200;
        int cantidad2 = 150;
        int cantidad3 = 85;
        
        if (cantidad2 >= 200) {
            System.out.println("descuento de 0.10");
        } else if (cantidad2 >= 100) {
            System.out.println("descuento = 0.5");
        } else {
            System.out.println("descuento = 0");
        }*/
        
        //----- switch ------
        System.out.println("Elige una opción: ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Opción 1");
                break;
            case 2:
                System.out.println("opción 2");
                break;
            case 3:
                System.out.println("opción 3");
                break;
            default:
                System.out.println("la opción no existe");
        }
        
        // .toLowerCase es para transformar en minusculas
        String opcion2 = "Guardar";
        switch (opcion2.toLowerCase()) {
            case "guardar":
                System.out.println("guardado");
                break;
            case "no guardar":
                System.out.println("no guardado");
                break;
            default:
                System.out.println("opción no válida");
        }
        
        // .toUpperCase
        String opcion3 = "guardar";
        switch (opcion2.toUpperCase()) {
            case "GUARDAR":
                System.out.println("guardado");
                break;
            case "no guardar":
                System.out.println("no guardado");
                break;
            default:
                System.out.println("opción no válida");
        }
    }
}
