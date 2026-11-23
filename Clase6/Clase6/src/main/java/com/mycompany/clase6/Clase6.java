/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase6;
import java.util.Scanner;

/**
 *
 * @author estefaniamazariegos
 */
public class Clase6 {
    static void linea() {
        System.out.println("______________________________________");
    }
    
    static void saludar(String nombre, int veces) {
        for (int i = 0; i < veces; i++) {
            System.out.println("¡HOla, " + nombre + "!");
        }
    }
    
    static double calcular(double total) {
        double sinIva = total / 1.12;
        return total - sinIva;
    }
    
    static double descuento(double precio, double porcentaje) {
        return precio - precio + porcentaje;
    }
    
    static boolean esPar(int n) {
        return n % 2 == 0;
    }
    
    static int sumar(int[] numeros) {
            int suma = 0;
            for (int n : numeros) {
                suma += n;
            }
            return suma;
        }
    
    static double promedio(int[] numeros) {
        return (double) sumar(numeros) / numeros.length;
    }
    
    static int buscar(int[] numeros, int buscado) {
        for(int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                return i;
            }
        }
        
        return -1;
    }
    
    static void imprimir(int[] v) {
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    
    static void duplicarVector(int[] v){
        for (int i = 0; i < v.length; i++) {
            v[i] = v[i] * 2;
        }
    }
    
    public static void main(String[] args) {
        linea();
        saludar("Ana", 3);
        linea();
        String n = "Sofia";
        int v = 2;
        saludar(n, v);
        linea();
        System.out.println("Calcular IVA");
        double i = calcular(75.5);
        System.out.println("resultado: " + i);
        linea();
        System.out.println("Calcular descuento");
        double d = descuento(500, 50);
        System.out.println("resultado: " + d);
        linea();
        int numero = 52;
        System.out.println("El numero: " + numero);
        if (esPar(numero)){
            System.out.println("es par");
        } else {
            System.out.println("no es par");
        }
        linea();
        int[] notas = {85, 92, 78, 95, 88};
        System.out.println("total de las notas: " + sumar(notas));
        System.out.println("Promedio de las notas: " + promedio(notas));
        linea();
        System.out.println("esta en la posición: " + buscar(notas, 92));
        linea();
        duplicarVector(notas);
        System.out.println("valores después: ");
        imprimir(notas);
    }
}
