package Pila.EjerciciosPila;

import Pila.Implementacion.Estrategia_1;

public class PilaDireccion {
    public static void main(String[] args) {
        System.out.print("\nCon dos pilas, podes mantener el historial de codigo despues de deshacer o rehacer");
        Estrategia_1 pilaTope = new Estrategia_1();
        pilaTope.InicializarPila();
        pilaTope.Apilar("C://");
        pilaTope.Apilar("Usuarios/");
        pilaTope.Apilar("Documentos/");

        String Value = "C://Users/mdriv/OneDrive/Documentos";
        Value.split("/", 5);



        System.out.print("\nEste es la pila para volver atras");

        while(!pilaTope.PilaVacia()) {
            System.out.print("\n"+pilaTope.Tope());
            pilaTope.Apilar(pilaTope.Tope());
            pilaTope.Desapilar();
        }
        System.out.print("\nEste es la pila para volver atras (Subir atras)");
        pilaTope.Desapilar();
    }
}
