package Pila.EjerciciosPila;

import Pila.Implementacion.Estrategia_1;

public class EditorCodigo {
    public static void main(String[] args) {
        System.out.print("\nCon dos pilas, podes mantener el historial de codigo despues de deshacer o rehacer");
        Estrategia_1 pilaTope = new Estrategia_1();
        pilaTope.InicializarPila();
        pilaTope.Apilar("Line 1");
        pilaTope.Apilar("Line 2");
        pilaTope.Apilar("Line 3");
        Estrategia_1 pilaAtras = new Estrategia_1();
        pilaAtras.InicializarPila();

        System.out.print("\nEste es la pila para volver atras");
        while(!pilaTope.PilaVacia()) {
            System.out.print("\n"+pilaTope.Tope());
            pilaAtras.Apilar(pilaTope.Tope());
            pilaTope.Desapilar();
        }
        System.out.print("\nEste es la pila para recuperar los datos de la pila");
        while(!pilaAtras.PilaVacia()) {
            System.out.print("\n"+pilaAtras.Tope());
            pilaTope.Apilar(pilaAtras.Tope());
            pilaAtras.Desapilar();
        }


}


}
