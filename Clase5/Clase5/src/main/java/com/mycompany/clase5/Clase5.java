/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase5;

/**
 *
 * @author estefaniamazariegos
 */
public class Clase5 {

    public static void main(String[] args) {
        //Intercambiar dos valores
        /*int a = 5, b = 9;
        System.out.println("a: " + a + " b: " + b);
        
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("a: " + a + " b: " + b);
        */
        // ordenamiento burbuja
        //int[] numeros = {7, 3, 9, 1, 5}; 
        //imprimir("Inicio: ", numeros); //<- llamada a un método auxiliar
        
        //primera pasada interno
        //->[7][3][9][1][5] j:0 length-1-pasada:4 pasada: 0
        //7 > 3: si
        //t = 7
        //[3][3][9][1][5]
        //[3][7][9][1][5]
        
        //[3]->[7][9][1][5] j:1 length-1-pasada:4 pasada: 0
        //7 > 9: no
        
        //[3][7]->[9][1][5] j:2 length-1-pasada:4 pasada: 0
        //9 > 1: si
        //t = 9
        //[3][7][1][1][5]
        //[3][7][1][9][5]
        
        //[3][7][1]->[9][5] j:3 length-1-pasada:4 pasada: 0
        //9 > 5: si
        //t = 9
        //[3][7][1][5][5]
        //[3][7][1][5][9]
        
        //[3][7][1][5][9] j:4 length-1-pasada:4 pasada: 0
        //terminó el ciclo interno (pasada 0)
        
        //segunda pasada
        //->[3][7][1][5][9] j:0 length-1-pasada:3 pasada: 1
        //3 > 7: no
        
        //[3]->[7][1][5][9] j:1 length-1-pasada:3 pasada: 1
        //7 > 1: si
        //t = 7
        //[3][1][1][5][9]
        //[3][1][7][5][9]
        
        //[3][1]->[7][5][9] j:2 length-1-pasada:3 pasada: 1
        //7 > 5: si
        //t = 7
        //[3][1][5][5][9]
        //[3][1][5][7][9]
        
        //[3][1][5][7][9] j:3 length-1-pasada:3 pasada: 1
        //terminada
        
        //de menor a mayor
        /*for (int pasada = 0; pasada < numeros.length - 1; pasada++) {
            for (int j = 0; j < numeros.length -1 - pasada; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int t = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = t;
                }
            }
            imprimir("pasada: " + (pasada) + ": ", numeros);
        }
        
        //de manor a menor
        for (int pasada = 0; pasada < numeros.length - 1; pasada++) {
            for (int j = 0; j < numeros.length -1 - pasada; j++) {
                if (numeros[j] < numeros[j + 1]) {
                    int t = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = t;
                }
            }
            imprimir("pasada: " + (pasada) + ": ", numeros);
        }*/
        
        //vectores paralelos
        /*String[] nombres = {"Ana", "Luis", "María", "Pedro", "Sofía"};
        int[] notas = {85, 72, 95, 58, 66};
        
        for (int pasada = 0; pasada < notas.length -1; pasada++){
            for (int j= 0; j < notas.length-1-pasada; j++) {
                if (notas[j] < notas[j + 1])
                {
                    int temNota = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = temNota;
                    
                    String temNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = temNombre;
                }
            }
        }
        
        System.out.println("Ranking:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("  " + (i + 1) + ". " + nombres[i] + " " + notas[i]);
        }*/
        
        /*String[] frutas = {"pera", "mango", "uva", "banano", "kiwi"};
        for (int pasada = 0; pasada < frutas.length - 1; pasada++) {
            for(int j = 0; j < frutas.length - 1 - pasada; j++) {
                if (frutas[j].compareTo(frutas[j + 1]) > 0) {
                    String t = frutas[j];
                    frutas[j] = frutas[j + 1];
                    frutas[j + 1] = t;
                }
            }
        }
        
        System.out.print("Frutas en orden alfabético: ");
        for (String f : frutas) {
            System.out.print(f + " ");
        }
        System.out.println();*/
        
        //matrices
        // declarar e inicializar
        int [][] ventas = {
            //[0][1][2][3] -> [0]
            //[0][1][2][3] -> [1]
            //[0][1][2][3] -> [2]
            {200, 350, 150, 400},   // 0. semana 1
            {400, 220, 310, 180},   // 1. semana 2
            {180, 500, 270, 300}    // 2. semana 3
        };
        
        String[] dias = {"Jue", "Vie", "Sáb", "Dom"};
        
        int[][] tablero = new int[3][3];
        tablero[1][1] = 5;
        
        //acceder
        System.out.println("Semana 2, sábado: " + ventas[1][2]);
        System.out.println("Filas: " + ventas.length);              // 3
        System.out.println("Columnas: " + ventas[0].length);        // 4
    
        //recorrer una matriz
        System.out.println();
        for (int i = 0; i < ventas.length; i++) {            // filas
            System.out.print("Semana " + (i + 1) + " ");
            for (int j = 0; j < ventas[i].length; j++) {     // columnas
                System.out.printf("%6d", ventas[i][j]);
            }
            System.out.println();
        }
        
        //total por cada fila
        for (int i = 0; i < ventas.length; i++) {
            int totalFila = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                totalFila += ventas[i][j];
            }
            System.out.println("Total semana: " + (i + 1) + ": " + totalFila);
        }
        
        //total por columna
        for (int j = 0; j < ventas[0].length; j++) {
            int totalColumna = 0;
            for (int i = 0; i < ventas.length; i++) {
                totalColumna += ventas[i][j];
            }
            System.out.println("Total " + dias[j] + ": " + totalColumna);
        }
        
        //valor más alto y la posición de este:
        int mayor = ventas[0][0];
        int filaMayor = 0, colMayor = 0;
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                if (ventas[i][j] > mayor) {
                    mayor = ventas[i][j];
                    filaMayor = i;
                    colMayor = j;
                }
            }
        }
        System.out.println("Venta más alta: " + mayor + " (semana " + (filaMayor + 1)
                + ", " + dias[colMayor] + ")");
    }   
    
    static void imprimir(String titulo, int[] v) {
        System.out.println(titulo);
        
        for( int x : v){
            System.out.println(x + " ");
        }
        System.out.println();
    }
}
