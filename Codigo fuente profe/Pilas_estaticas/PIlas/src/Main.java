import Implementacion.Estrategia_1;
import Implementacion.Estrategia_2;
import Implementacion.Estrategia_3;
import Interfaces.PilaTDA;

public class Main {
    public static void main(String[] args) {

        PilaTDA p1 = new Estrategia_1();
        PilaTDA p2 = new Estrategia_2();
        PilaTDA p3 = new Estrategia_3();

        probarPila("Estrategia 1", p1);
        probarPila("Estrategia 2", p2);
        probarPila("Estrategia 3", p3);
    }

    public static void probarPila(String nombre, PilaTDA pila) {
        System.out.println("=== " + nombre + " ===");

        pila.InicializarPila();

        pila.Apilar(10);
        pila.Apilar(20);
        pila.Apilar(30);

        System.out.println("Tope luego de apilar 10, 20, 30: " + pila.Tope());

        pila.Desapilar();
        System.out.println("Tope luego de desapilar una vez: " + pila.Tope());

        pila.Desapilar();
        System.out.println("Tope luego de desapilar otra vez: " + pila.Tope());

        pila.Desapilar();
        System.out.println("¿Pila vacía?: " + pila.PilaVacia());

        System.out.println();
    }
}