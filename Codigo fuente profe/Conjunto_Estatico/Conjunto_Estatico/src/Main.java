import Implementacion.ConjuntoEstatico;
import Interface.ConjuntoTDA;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConjuntoTDA c = new ConjuntoEstatico();

        c.InicializarConjunto();

        System.out.println("¿Conjunto vacío?: " + c.ConjuntoVacio());

        c.Agregar(3);
        c.Agregar(7);
        c.Agregar(3); // no debe repetirse
        c.Agregar(10);

        System.out.println("¿Pertenece 3?: " + c.Pertenece(3));
        System.out.println("¿Pertenece 5?: " + c.Pertenece(5));

        System.out.println("Elemento elegido: " + c.Elegir());

        c.Sacar(7);
        System.out.println("¿Pertenece 7 luego de sacarlo?: " + c.Pertenece(7));

        c.Sacar(3);
        System.out.println("¿Pertenece 3 luego de sacarlo?: " + c.Pertenece(3));

        System.out.println("¿Conjunto vacío?: " + c.ConjuntoVacio());
    }
}