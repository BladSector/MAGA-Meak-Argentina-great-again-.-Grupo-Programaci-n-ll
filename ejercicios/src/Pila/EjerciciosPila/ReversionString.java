package Pila.EjerciciosPila;

import Pila.Implementacion.Estrategia_1;

public class ReversionString {
    public static void main(String[] args) {
        Estrategia_1 pila =  new Estrategia_1();
        pila.InicializarPila();
        String word = "ALGORITMOS";
        System.out.print("Vamos a poner cada letra de ALGORITMOS en la pila:\n");
        for (int i = 0; i <= word.length()-1; i++) {
            pila.Apilar(String.valueOf(word.charAt(i)));
            System.out.print(pila.Tope()+"\n");
        }
        System.out.print("Ahora volviendo a borrar la pila, haciendo que la palabra se lea al reves\n");
        while(!pila.PilaVacia()){
            System.out.print(pila.Tope()+"\n");
            pila.Desapilar();

        }

    }
}
