/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase4;

/**
 *
 * @author estefaniamazariegos
 */
import java.util.Scanner;

public class Clase4 {

    public static void main(String[] args) {
       /* int[] notas = {85, 23, 45, 88, 15};
        
        double[] precios = new double[3];
        precios[0] = 8.40;
        precios[1] = 1.50;
        precios[2] = 3.75;
        
        String[] dias = {"lunes", "martes", "miercoles"};
    
        System.out.println("primera nota: " + notas[0]);
        System.out.println("ultima nota: " + notas[4]);
        System.out.println("Ultima nota: " + notas[notas.length - 1]);
        System.out.println("tamaño del vector: " + notas.length);
        
        //---- recorrer con for-each
        for (double precio : precios) {
            System.out.printf("Q%.2f%n", precio);
        }
        
        //---- recorrer con un for
        for (int i = 0; i < dias.length; i++) {
            System.out.println("dia en la posición: " + i + "es: " + dias[i]);
        }
        
        //---- suma, promedio, mayor, menor
        int suma = 0;
        int mayor = notas[0];
        int menor = notas[0];
        
        for (int nota : notas) {
            // el total de todas las notas
            suma += nota;
            
            //para obtener la nota mayor y menor
            if (nota > mayor) {
                mayor = nota;
            }
            if (nota < menor) {
                menor = nota;
            }
        }
        
        //promedio
        double promedio = (double) suma / notas.length;
        
        System.out.println("suma: " + suma);
        System.out.println("promedio: " + promedio);
        System.out.println("nota mayor: " + mayor);
        System.out.println("nota menor: " + menor);
        
        //// buscar un elemento
        String buscar = "viernes";
        int posicion = -1;
        for (int i = 0; i < dias.length; i++) {
            if (dias[i].equals(buscar)) {
                posicion = i;
                break; //terminar el ciclo porque ya encontró la variable
            }
        }
        if (posicion != -1) {
            System.out.println("que el valor: " + buscar + " si existe en la posición: " + posicion);
        } else {
            System.out.println("que el valor: " + buscar + "no existe");
        }
        
        //modificar todos los datos de un vector
        for (int i = 0; i < notas.length; i++) {
            notas[i] = notas[i] * 2;
        }
        for (int i = 0; i < notas.length; i++) {
            System.out.println("nuevas notas: " + notas[i]);
        } */
        
        //agregar un elemento a un vector
        final int CAPACIDAD = 5;
        String[] nombres = new String[CAPACIDAD];
        String[] telefonos = new String[CAPACIDAD];
        int total = 0;
        
        //[0] [1] [2]
        //[Ana] [Luis]
        nombres[0] = "Ana"; telefonos[0] = "5555-1111";
        nombres[1] = "Luis"; telefonos[1] = "4444-1111";
        total = 2;
        
        System.out.println("Antes de agregar");
        for (int i = 0; i < total; i++) {
            System.out.println(" " + i + ". " + nombres[i] + " telefono: " + telefonos[i]);
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un nombre: ");
        String buscado = sc.nextLine();
        System.out.println("Ingrese un número de teléfono: ");
        String numero = sc.nextLine();
        
        //-----agregar
        int posicion = -1;
        for (int i = 0; i < total; i++) {
            if (nombres[i].equalsIgnoreCase(buscado)) { 
            //equalsIgnoreCase ignora mayusculas y minusculas al comparar cadenas
                posicion = i;
                break;
            }
        }
        
        boolean encontrado = false;
        if (posicion != -1) {
            encontrado = true;
        } else {
            System.out.println("No se encontró el nombre ingresado");
        }
        
        if (encontrado) {
            System.out.println("el nombre ya existe");
            
        } else if (total < CAPACIDAD) {
            nombres[total] = buscado;
            telefonos[total] = numero;
            total++;
            System.out.println("Agregado: " + buscado + "ahora hay: " + total);
        
        } else {
            System.out.println("ya no hay espacio");
        }
        
        //-----eliminar
        // buscar
        /*int posicion = -1;
        for (int i = 0; i < total; i++) {
            if (nombres[i].equalsIgnoreCase(buscado)) { 
            //equalsIgnoreCase ignora mayusculas y minusculas al comparar cadenas
                posicion = i;
                break;
            }
        }
        
        boolean encontrado = false;
        if (posicion != -1) {
            encontrado = true;
        } else {
            System.out.println("No se encontró el nombre ingresado");
        }*/
        
        
        //este es el proceso para eliminar un valor
        /*if (encontrado) {
            //[Ana] [Luis] [null]
            //[Ana] [null] [null]
            for (int i = posicion; i < total - 1; i++) {
                nombres[i] = nombres[i + 1];
                telefonos[i] = telefonos[i + 1];
            }
            
            nombres[total - 1] = null;
            telefonos[total - 1] = null;
            total--; 
        }
        
        System.out.println("Después de la eliminación");
        for (int i = 0; i < total; i++) {
            System.out.println(" " + i + ". " + nombres[i] + " telefono: " + telefonos[i]);
        }*/
    }
}
