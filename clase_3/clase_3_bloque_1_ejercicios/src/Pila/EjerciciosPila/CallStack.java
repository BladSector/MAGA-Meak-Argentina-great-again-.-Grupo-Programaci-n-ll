package Pila.EjerciciosPila;

import Pila.Implementacion.Estrategia_2;
import Pila.Interfaz.PilaTDAI;

public class CallStack {
    public static void main(String[] args) {
        Estrategia_2 listNotas = new Estrategia_2();
        listNotas.InicializarPila();
        listNotas.Apilar(2);
        listNotas.Apilar(6);
        listNotas.Apilar(10);
        listNotas.Apilar(7);
        listNotas.Apilar(8);
        int PromedioN = 0;
        PromedioN = CalcularPromedio(listNotas);
        System.out.println("Promedio N: " + PromedioN);


    }

    public static int CalcularPromedio(Estrategia_2 pila){
        int countItems=0;
        countItems=pila.Cantidad();
        double total = Suma(pila);

        total=total/countItems;
        return (int)total;

    }

    public static double Suma(PilaTDAI pila){
        double aux = 0;


        while(!pila.PilaVacia()){
            aux+=pila.Tope();
            pila.Desapilar();
        }

        return (aux);


    }


}
