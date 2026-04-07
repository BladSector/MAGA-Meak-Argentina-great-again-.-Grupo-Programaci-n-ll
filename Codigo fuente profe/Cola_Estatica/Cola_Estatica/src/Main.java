import Implementacion.ColaEstatica;
import Interface.ColaTDA;

public class Main {
    public static void main(String[] args) {
        ColaTDA cola = new ColaEstatica();

        cola.InicializarCola();

        System.out.println("¿Cola vacía?: " + cola.ColaVacia());

        cola.Acolar(10);
        cola.Acolar(20);
        cola.Acolar(30);

        System.out.println("Primero: " + cola.Primero()); // 10

        cola.Desacolar();
        System.out.println("Primero luego de desacolar: " + cola.Primero()); // 20

        cola.Acolar(40);
        System.out.println("Primero luego de acolar 40: " + cola.Primero()); // 20

        cola.Desacolar();
        System.out.println("Primero luego de desacolar: " + cola.Primero()); // 30

        cola.Desacolar();
        System.out.println("Primero luego de desacolar: " + cola.Primero()); // 40

        cola.Desacolar();
        System.out.println("¿Cola vacía?: " + cola.ColaVacia()); // true
    }
}