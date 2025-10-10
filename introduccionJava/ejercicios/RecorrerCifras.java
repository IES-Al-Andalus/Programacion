package org.iesalandalus.programacion.introjava.variados;

import org.iesalandalus.programacion.utilidades.Entrada;

public class RecorrerCifras {
    public static void main(String[] args) {
        int numero;
        do {
            System.out.print("Escribe un número mayor que cero: ");
            numero = Entrada.entero();
        } while (numero <= 0);
        
        int numeroCifras = (int) Math.log10(numero) + 1;

        System.out.println("Recorro las cifras de derecha a izquierda");
        for (int i = 0; i < numeroCifras; i++) {
            int cifra = numero / (int)Math.pow(10, i) % 10;
            System.out.println("La cifra que ocupa la posición: " + i + " es: " + cifra);
        }

        System.out.println("Recorro las cifras de izquierda a derecha");
        for (int i = numeroCifras - 1; i >= 0; i--) {
            int cifra = numero / (int)Math.pow(10, i) % 10;
            System.out.println("La cifra que ocupa la posición: " + i + " es: " + cifra);
        }
    }
}
