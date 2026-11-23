/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba1;
import java.util.Scanner;
/**
 *
 * @author estefaniamazariegos
 */
public class Prueba1 {
    
    static final String NOMBRE_TIENDA = "Tienda Doña Mary";
    static final double IVA = 0.12;
    static final int STOCK_MINIMO = 5;
    static final int CAPACIDAD = 10;
    static final String[] DIAS = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};

    //  MAIN: solo organiza el trabajo lo hacen los métodos
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[CAPACIDAD];
        double[] precios = new double[CAPACIDAD];
        int[] stock = new int[CAPACIDAD];
        int[][] ventasSemana = new int[CAPACIDAD][7];

        nombres[0] = "Agua pura 600ml"; precios[0] = 8.00;  stock[0] = 30;
        nombres[1] = "Pan dulce";       precios[1] = 1.50;  stock[1] = 40;
        nombres[2] = "Frijoles 400g";   precios[2] = 12.75; stock[2] = 8;
        int totalProductos = 3;
        
        /*
          0  1 2 3 4 5 6
        0[6][4][][][][][]
        1[20][15][][][][][]
        2[2][3][][][][][]
        3[][][][][][][]
        4[][][][][][][]
        5[][][][][][][]
        6[][][][][][][]
        7[][][][][][][]
        8[][][][][][][]
        9[][][][][][][]
        */
        ventasSemana[0][0] = 6;  ventasSemana[0][1] = 4;
        ventasSemana[1][0] = 20; ventasSemana[1][1] = 15;
        ventasSemana[2][0] = 2;  ventasSemana[2][1] = 3;
        int diaActual = 2;

        int ventasDelDia = 0;
        double totalDelDia = 0;
        int opcion;

        do {
            mostrarMenu(diaActual);
            opcion = leerEnteroEnRango(sc, "Elige una opción: ", 1, 9);

            switch (opcion) {
                case 1:
                    double cobrado = vender(sc, nombres, precios, stock, totalProductos, ventasSemana, diaActual);
                    if (cobrado > 0) {
                        ventasDelDia++;
                        totalDelDia += cobrado;
                    }
                    break;
                case 2:
                    mostrarInventario(nombres, precios, stock, totalProductos);
                    break;
                case 3:
                    mostrarBusqueda(sc, nombres, precios, stock, totalProductos);
                    break;
                case 4:
                    totalProductos = agregarProducto(sc, nombres, precios, stock, totalProductos);
                    break;
                case 5:
                    totalProductos = eliminarProducto(sc, nombres, precios, stock, ventasSemana, totalProductos);
                    break;
                case 6:
                    ordenarPorPrecio(nombres, precios, stock, ventasSemana, totalProductos);
                    mostrarInventario(nombres, precios, stock, totalProductos);
                    break;
                case 7:
                    mostrarReporte(nombres, ventasSemana, totalProductos);
                    break;
                case 8:
                    mostrarResumenDia(nombres, stock, ventasSemana, totalProductos, diaActual, ventasDelDia, totalDelDia);
                    ventasDelDia = 0;
                    totalDelDia = 0;
                    if (diaActual < 6) {
                        diaActual++;
                    } else {
                        System.out.println("Terminó la semana. El reporte empieza de nuevo.");
                        diaActual = 0;
                        limpiarMatriz(ventasSemana);
                    }
                    System.out.println("Abriendo el " + DIAS[diaActual] + "...");
                    break;
                case 9:
                    System.out.println("¡Hasta mañana!");
                    break;
            }
        } while (opcion != 9);

        sc.close();
    }

    //  MÉTODOS 

    static void mostrarMenu(int diaActual) {
        System.out.println();
        System.out.println("=================================");
        System.out.println("     " + NOMBRE_TIENDA + " · " + DIAS[diaActual]);
        System.out.println("=================================");
        System.out.println("1. Vender");
        System.out.println("2. Ver inventario");
        System.out.println("3. Buscar producto");
        System.out.println("4. Agregar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Ordenar inventario por precio");
        System.out.println("7. Reporte semanal");
        System.out.println("8. Cerrar día");
        System.out.println("9. Salir");
    }

    // Pide un entero HASTA que esté entre min y max. Reemplaza los do-while repetidos.
    static int leerEnteroEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor;
        do {
            System.out.print(mensaje);
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Debe estar entre " + min + " y " + max + ".");
            }
        } while (valor < min || valor > max);
        return valor;
    }

    static double leerDecimalMinimo(Scanner sc, String mensaje, double minimo) {
        double valor;
        do {
            System.out.print(mensaje);
            valor = sc.nextDouble();
            if (valor < minimo) {
                System.out.printf("Debe ser al menos Q%.2f.%n", minimo);
            }
        } while (valor < minimo);
        return valor;
    }

    // Lee S/N, E/T, etc.: repite hasta que la letra sea una de las dos válidas
    static char leerOpcion(Scanner sc, String mensaje, char a, char b) {
        char letra;
        do {
            System.out.print(mensaje);
            letra = sc.next().toUpperCase().charAt(0);
        } while (letra != a && letra != b);
        return letra;
    }

    static void mostrarProductos(String[] nombres, double[] precios, int[] stock, int total) {
        for (int i = 0; i < total; i++) {
            System.out.printf("%d. %-18s Q%6.2f (stock: %d)%n", i + 1, nombres[i], precios[i], stock[i]);
        }
    }

    // Búsqueda lineal: devuelve la posición o -1
    static int buscarProducto(String[] nombres, int total, String buscado) {
        for (int i = 0; i < total; i++) {
            if (nombres[i].equalsIgnoreCase(buscado)) {
                return i;
            }
        }
        return -1;
    }

    static double calcularPorcentajeDescuento(double subtotal, boolean clienteFrecuente) {
        double porcentaje;
        if (subtotal >= 200) {
            porcentaje = 0.10;
        } else if (subtotal >= 100) {
            porcentaje = 0.05;
        } else {
            porcentaje = 0;
        }
        if (clienteFrecuente) {
            porcentaje += 0.05;
        }
        return porcentaje;
    }

    static void imprimirTicket(String producto, int cantidad, double precio,
                               double subtotal, double porcentaje, double total) {
        double descuento = subtotal - total;
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
    }

    static void cobrar(Scanner sc, double total) {
        char formaPago = leerOpcion(sc, "Forma de pago (E = efectivo, T = tarjeta): ", 'E', 'T');
        if (formaPago == 'E') {
            double pago = leerDecimalMinimo(sc, "¿Con cuánto paga? Q", total);
            System.out.printf("Vuelto: Q%.2f%n", pago - total);
        } else {
            System.out.println("Pago con tarjeta aprobado.");
        }
    }

    //  OPCIONES DEL MENÚ

    // Devuelve lo cobrado (0 si no hubo venta)
    static double vender(Scanner sc, String[] nombres, double[] precios, int[] stock,
                         int total, int[][] ventasSemana, int diaActual) {
        if (total == 0) {
            System.out.println("No hay productos en el inventario.");
            return 0;
        }
        mostrarProductos(nombres, precios, stock, total);
        int p = leerEnteroEnRango(sc, "Producto (1-" + total + "): ", 1, total) - 1;

        if (stock[p] == 0) {
            System.out.println(nombres[p] + " está agotado.");
            return 0;
        }
        int cantidad = leerEnteroEnRango(sc, "Cantidad (1 a " + stock[p] + "): ", 1, stock[p]);

        double subtotal = precios[p] * cantidad;
        boolean frecuente = leerOpcion(sc, "¿Tiene tarjeta de cliente frecuente? (S/N): ", 'S', 'N') == 'S';
        double porcentaje = calcularPorcentajeDescuento(subtotal, frecuente);
        double totalVenta = subtotal - subtotal * porcentaje;

        imprimirTicket(nombres[p], cantidad, precios[p], subtotal, porcentaje, totalVenta);
        cobrar(sc, totalVenta);

        stock[p] -= cantidad;
        ventasSemana[p][diaActual] += cantidad;
        if (stock[p] < STOCK_MINIMO) {
            System.out.println("ALERTA: quedan " + stock[p] + " de " + nombres[p] + ". Pedir más producto.");
        }
        System.out.println("¡Venta registrada!");
        return totalVenta;
    }

    static void mostrarInventario(String[] nombres, double[] precios, int[] stock, int total) {
        System.out.println("--- Inventario (" + total + " de " + CAPACIDAD + " espacios) ---");
        mostrarProductos(nombres, precios, stock, total);
        double valor = 0;
        for (int i = 0; i < total; i++) {
            valor += precios[i] * stock[i];
        }
        System.out.printf("Valor del inventario: Q%.2f%n", valor);
    }

    static void mostrarBusqueda(Scanner sc, String[] nombres, double[] precios, int[] stock, int total) {
        sc.nextLine();
        System.out.print("Nombre del producto: ");
        String buscado = sc.nextLine();
        int pos = buscarProducto(nombres, total, buscado);
        if (pos != -1) {
            System.out.printf("Encontrado: %s | Q%.2f | stock: %d%n", nombres[pos], precios[pos], stock[pos]);
        } else {
            System.out.println("No existe un producto llamado \"" + buscado + "\".");
        }
    }

    // Devuelve el NUEVO total de productos
    static int agregarProducto(Scanner sc, String[] nombres, double[] precios, int[] stock, int total) {
        if (total == CAPACIDAD) {
            System.out.println("El inventario está lleno (" + CAPACIDAD + " productos).");
            return total;
        }
        sc.nextLine();
        System.out.print("Nombre del nuevo producto: ");
        String nombre = sc.nextLine();
        if (buscarProducto(nombres, total, nombre) != -1) {      // reutilizamos buscar
            System.out.println("Ese producto ya está en el inventario.");
            return total;
        }
        nombres[total] = nombre;
        precios[total] = leerDecimalMinimo(sc, "Precio: Q", 0.01);
        stock[total] = leerEnteroEnRango(sc, "Stock inicial: ", 0, 10000);
        System.out.println("Producto agregado.");
        return total + 1;
    }

    // Devuelve el NUEVO total de productos
    static int eliminarProducto(Scanner sc, String[] nombres, double[] precios, int[] stock,
                                int[][] ventasSemana, int total) {
        if (total == 0) {
            System.out.println("No hay productos para eliminar.");
            return total;
        }
        mostrarProductos(nombres, precios, stock, total);
        int e = leerEnteroEnRango(sc, "Producto a eliminar (1-" + total + "): ", 1, total) - 1;
        if (leerOpcion(sc, "¿Seguro que quieres eliminar " + nombres[e] + "? (S/N): ", 'S', 'N') == 'N') {
            System.out.println("No se eliminó nada.");
            return total;
        }
        String eliminado = nombres[e];
        for (int i = e; i < total - 1; i++) {
            nombres[i] = nombres[i + 1];
            precios[i] = precios[i + 1];
            stock[i] = stock[i + 1];
            ventasSemana[i] = ventasSemana[i + 1];
        }
        nombres[total - 1] = null;
        precios[total - 1] = 0;
        stock[total - 1] = 0;
        ventasSemana[total - 1] = new int[7];
        System.out.println(eliminado + " fue eliminado.");
        return total - 1;
    }

    static void ordenarPorPrecio(String[] nombres, double[] precios, int[] stock,
                                 int[][] ventasSemana, int total) {
        for (int pasada = 0; pasada < total - 1; pasada++) {
            for (int j = 0; j < total - 1 - pasada; j++) {
                if (precios[j] > precios[j + 1]) {
                    double tPrecio = precios[j];
                    precios[j] = precios[j + 1];
                    precios[j + 1] = tPrecio;

                    String tNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tNombre;

                    int tStock = stock[j];
                    stock[j] = stock[j + 1];
                    stock[j + 1] = tStock;

                    int[] tFila = ventasSemana[j];
                    ventasSemana[j] = ventasSemana[j + 1];
                    ventasSemana[j + 1] = tFila;
                }
            }
        }
        System.out.println("Inventario ordenado de menor a mayor precio.");
    }

    static int totalFila(int[][] m, int fila) {
        int suma = 0;
        for (int d = 0; d < m[fila].length; d++) {
            suma += m[fila][d];
        }
        return suma;
    }

    static int totalColumna(int[][] m, int columna, int filasUsadas) {
        int suma = 0;
        for (int i = 0; i < filasUsadas; i++) {
            suma += m[i][columna];
        }
        return suma;
    }

    static void mostrarReporte(String[] nombres, int[][] ventasSemana, int total) {
        System.out.println("--- Unidades vendidas en la semana ---");
        System.out.printf("%-18s", "Producto");
        for (int d = 0; d < 7; d++) {
            System.out.printf("%5s", DIAS[d]);
        }
        System.out.printf("%7s%n", "Total");

        int masVendido = -1;
        int max = -1;
        for (int i = 0; i < total; i++) {
            System.out.printf("%-18s", nombres[i]);
            for (int d = 0; d < 7; d++) {
                System.out.printf("%5d", ventasSemana[i][d]);
            }
            int t = totalFila(ventasSemana, i);
            System.out.printf("%7d%n", t);
            if (t > max) {
                max = t;
                masVendido = i;
            }
        }
        System.out.printf("%-18s", "Total del día");
        int semana = 0;
        for (int d = 0; d < 7; d++) {
            int t = totalColumna(ventasSemana, d, total);
            System.out.printf("%5d", t);
            semana += t;
        }
        System.out.printf("%7d%n", semana);
        if (masVendido != -1) {
            System.out.println("Producto más vendido: " + nombres[masVendido] + " (" + max + " unidades)");
        }
    }

    static int posicionMenorStock(int[] stock, int total) {
        int menor = 0;
        for (int i = 1; i < total; i++) {
            if (stock[i] < stock[menor]) {
                menor = i;
            }
        }
        return menor;
    }

    static void mostrarResumenDia(String[] nombres, int[] stock, int[][] ventasSemana, int total,
                                  int dia, int ventas, double dinero) {
        System.out.println("--- Resumen del " + DIAS[dia] + " ---");
        System.out.println("Ventas realizadas: " + ventas);
        System.out.println("Unidades vendidas: " + totalColumna(ventasSemana, dia, total));
        System.out.printf("Total vendido:     Q%.2f%n", dinero);
        if (total > 0) {
            int m = posicionMenorStock(stock, total);
            System.out.println("Producto con menos stock: " + nombres[m] + " (" + stock[m] + ")");
        }
    }

    static void limpiarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 0;
            }
        }
    }
    
}
