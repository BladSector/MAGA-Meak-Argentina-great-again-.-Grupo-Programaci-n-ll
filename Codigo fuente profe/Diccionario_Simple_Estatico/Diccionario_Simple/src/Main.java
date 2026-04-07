import Implementacion.DiccionarioSimpleEstatico;
import Interface.DiccionarioSimpleTDA;

public class Main {
    public static void main(String[] args) {
        DiccionarioSimpleTDA d = new DiccionarioSimpleEstatico();

        d.InicializarDiccionario();

        d.Agregar(1, 100);
        d.Agregar(2, 200);
        d.Agregar(3, 300);
        d.Agregar(2, 250); // actualiza el valor de la clave 2

        System.out.println("Claves del diccionario:");
        int[] claves1 = d.Claves();
        for (int i = 0; i < claves1.length; i++) {
            System.out.println(claves1[i]);
        }

        d.Eliminar(2);

        System.out.println("Claves luego de eliminar la clave 2:");
        int[] claves2 = d.Claves();
        for (int i = 0; i < claves2.length; i++) {
            System.out.println(claves2[i]);
        }
    }
}