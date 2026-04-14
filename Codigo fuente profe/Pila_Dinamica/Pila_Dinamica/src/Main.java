import Implementacion.PilaDinamica;
import Interfaces.PilaTDA;

public class Main {
    public static void main(String[] args) {

        PilaTDA pila = new PilaDinamica();

        probarPila("Pila Dinámica con Nodo", pila);
    }

    public static void probarPila(String nombre, PilaTDA pila) {
        System.out.println("=== " + nombre + " ===");

        pila.InicializarPila();

        pila.Apilar(10);
        pila.Apilar(20);
        pila.Apilar(30);

        System.out.println("Tope luego de apilar 10, 20, 30: " + pila.Tope()); // 30

        pila.Desapilar();
        System.out.println("Tope luego de desapilar una vez: " + pila.Tope()); // 20

        pila.Desapilar();
        System.out.println("Tope luego de desapilar otra vez: " + pila.Tope()); // 10

        pila.Desapilar();
        System.out.println("¿Pila vacía?: " + pila.PilaVacia()); // true

        System.out.println();
    }
}