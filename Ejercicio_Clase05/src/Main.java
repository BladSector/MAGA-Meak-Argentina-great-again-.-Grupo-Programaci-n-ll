import Implementacion.ColaDinamica;
import Implementacion.ColaEstatica;
import Implementacion.PilaDinamica;
import Implementacion.PilaEstatica_Estrategia_1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // Instanciamos las 4 TDAs
    ColaDinamica colaD = new ColaDinamica();
    PilaDinamica pilaD = new PilaDinamica();
    PilaEstatica_Estrategia_1 pilaE = new PilaEstatica_Estrategia_1();
    ColaEstatica colaE = new ColaEstatica();

    // Inicializamos las 4 TDAs
    colaD.InicializarCola();
    pilaD.InicializarPila();
    pilaE.InicializarPila();
    colaE.InicializarCola();

    // Elementos a mover
    int[] datos = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    // Acolando elementos en cola dinamica
    System.out.println("Acolando datos en Cola Dinámica...");
    System.out.print("Orden de acolado: ");
    for (int d : datos) {
        colaD.Acolar(d);
        System.out.print(d + " ");
    }

    // Moviendo datos de cola dinamica a pila dinamica
    System.out.println("\nMoviendo datos a Pila Dinámica...");
    System.out.print("Orden de apilado: ");
    while (!colaD.ColaVacia()) {
        pilaD.Apilar(colaD.Primero());
        System.out.print(colaD.Primero() + " ");
        colaD.Desacolar();
    }

    // Moviendo datos de pila dinamica a pila estatica
    System.out.println("\nMoviendo datos a Pila Estática...");
    System.out.print("Orden de apilado: ");
    while (!pilaD.PilaVacia()) {
        pilaE.Apilar(pilaD.Tope());
        System.out.print(pilaD.Tope() + " ");
        pilaD.Desapilar();
    }

    // Moviendo datos de pila estatica a cola estatica
    System.out.println("\nMoviendo datos a Cola Estática...");
    System.out.print("Orden de acolado: ");
    while (!pilaE.PilaVacia()) {
        colaE.Acolar(pilaE.Tope());
        System.out.print(pilaE.Tope() + " ");
        pilaE.Desapilar();
    }

    // Desacolando cola estatica
    System.out.println("\nDesacolando datos de Cola Estática...");
    System.out.print("Orden de desacolado: ");
    while (!colaE.ColaVacia()) {
        System.out.print(colaE.Primero() + " ");
        colaE.Desacolar();
    }
}
