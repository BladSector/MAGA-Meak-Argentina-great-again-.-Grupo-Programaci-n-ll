package Pila.EjerciciosPila;

import Pila.Implementacion.Estrategia_1;

public class BalanceoPilas {
    public static void main(String[] args) {

        String value = "((1+8)*2)";
        System.out.println("La expresion es" + value);

        Estrategia_1 Pila = new Estrategia_1();
        Pila.InicializarPila();
        String[] parentisis = value.split("\\(, \\),\\+, *"); // Este no funciono
        Pila.Apilar(parentisis[0]);
        System.out.println("La expresion es" + Pila.Tope());

    }
}

