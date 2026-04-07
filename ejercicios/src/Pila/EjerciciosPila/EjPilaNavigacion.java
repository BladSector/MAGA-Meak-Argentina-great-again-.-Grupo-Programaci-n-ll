package Pila.EjerciciosPila;

import Pila.Implementacion.Estrategia_1;

public class EjPilaNavigacion {
    public static void main(String[] args) {
        Estrategia_1 pila = new Estrategia_1();
        pila.InicializarPila();
        System.out.print("Eso sucede cuando entras las paginas\n");
        pila.Apilar("fi.uba.ar");
        System.out.println(pila.Tope());
        pila.Apilar("campus.utn.edu.ar ");
        System.out.println(pila.Tope());
        pila.Apilar("stackoverflow.com");
        System.out.println(pila.Tope());
        System.out.print("\nEso muestra que estas en la pagina\n");
        System.out.print(pila.Tope());
        System.out.print("\nY volves atras con el boton de atras\n");
        pila.Desapilar();
        // Actualmente estas en la pagina de atras
        System.out.print(pila.Tope());



        }


    }


