▸ Estado de una PILA
De BASE a CIMA: base→v1→v2→...→tope → ejemplo: base→4→9→2→3→tope
Estado del arreglo: indicá datos[0] y los valores datos[1]..datos[datos[0]]

Ej 1. formato: output, datos[0], base→v1→v2→...→tope

(a): 1, 5, base→5→12→3→8→1→tope
(b): 5, 5, base→5→12→3→8→1→tope
(c): 6, 5, base→5→12→3→9→6→tope
(d): 5, 5, base→5→12→3→9→6→tope
(e): 35, 5, base→5→12→3→9→6→tope
(f): 6, 5, base→5→12→3→9→6→tope
(g): 5, 5, base→5→12→3→9→6→tope
(h): 7, 7, base→5→12→3→9→6→4→7→tope

Ej 2. Lo que hace metodoV() es ir iterando sobre la pila y sumando a cada iteracion el valor de la posicion que estaba iterando. Es asi como termina con un return suma que nos devolvera el valor sumado de todos los elementos de la pila. La pila no queda modificada al terminar porque durante esta iteracion se va guardando en una pila auxiliar, que tras terminar la iteracion vuelva a la pila original a su estado con el que comenzo la funcion. El valor correcto que retorna es 35, ya que es la suma de todos sus valores, 5+12+3+9+6=35.

Ej 3. Tanto el metodo Apilar() como Desapilar() verifican que PilaLlena() y PilaVacia() sean diferente de true, es decir que sean false, por ende que no este ni llena ni vacia respectivamente. Si se intenta Apilar con la pila llena, PilaLlena() da true, entonces !PilaLlena() da false y no se ejecuta el cuerpo del if, la pila queda igual y no se agrega el elemento; si se intenta Desapilar con la pila vacía, PilaVacia() da true, entonces !PilaVacia() da false y no se decrementa datos[0], la pila queda igual.


Ej 4. En la implementación estática la pila se guarda en un arreglo de tamaño fijo. datos[0] indica la cantidad de elementos y el tope está en datos[datos[0]]. Su ventaja es que es simple y el acceso al tope es directo. Su desventaja es que tiene una capacidad máxima fija: si se llena, no se pueden apilar más elementos. En la implementación dinámica la pila se guarda con nodos enlazados, donde cada nodo contiene un valor y una referencia al siguiente. El tope suele estar referenciado por un puntero o nodo inicial. Su ventaja es que no necesita definir un tamaño máximo fijo y puede crecer mientras haya memoria. Su desventaja es que usa más memoria por los enlaces y es más compleja de implementar.


▸ Estado de una COLA
De PRIMERO al último: Primero→v1→v2→...→último → ejemplo: Primero→10→25→7→último

Ej 5. formato: output, Primero(), Primero→v1→v2→...→último

(a): 4, 4, Primero→4→9→2→7→5→último
(b): 2, 2, Primero→2→7→5→11→3→último
(c): true, null, Primero→vacia→último
(d): null, null, Primero→vacia→último
(e): 8, 8, Primero→8→último

Ej 6. formato: output, datos[0], {v1, v2, ...}

(a): true, 5, {3,7,1,5,9}
(b): false, 5, {3,7,1,5,9}
(c): false, 5, {3,7,5,9,4}
(d): false, 5, {3,7,5,9,4}
(e): true, 5, {3,7,5,9,4}
(f): 6, 6, {3,7,5,9,4,2}
(g): 6, 6, {3,7,5,9,4,2}

Agregar(int x) {
if (!ConjuntoLleno() && !Pertenece(x))

Ej 7. No podremos agregar nada al conjunto, si este esta lleno y si el item que queremos agregar ya partenece al conjunto. Esto es asi porque la funcion agregar() tiene un condicional if que verificara que las funciones ConjuntoLleno() y Pertenece(x) sean false. De ambas no ser false, entonces no agregara el valor y el conjunto no cambiara.

Ej 8.

cola = Primero→1→2→3→4→5→último
conjunto = {2,3,4}

static void eliminarDeColaLosElementosPresentesEnConjunto(ColaTDA cola, ConjuntoTDA conjunto) {

    ColaTDA colaAux = new ColaTDA(); 
    colaAux.InicializarCola();

    while ( cola.ColaVacia() == false ) {
        int elementoAMoverAColaAUX = cola.Primero();
        cola.Desacolar();

        if ( conjunto.Pertenece ( elementoAMoverAColaAUX ) == false ) {
            colaAux.Acolar( elementoAMoverAColaAUX );
        }
    }

    while ( colaAux.ColaVacia() == false ) {
        int elementoAMoverAColaOriginal = colaAux.Primero();
        colaAux.Desacolar();
        cola.Acolar( elementoAMoverAColaOriginal );
    }
}

Ej 9. formato: output, Subcola P=0: [...] | Subcola P=1: [...] | Subcola P=2: [...]

(a): 2, Subcola P=0: [2, 5, 4] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(b): 0, Subcola P=0: [2, 5, 4] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(c): 5, Subcola P=0: [5, 4] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(d): 6, Subcola P=0: vacía | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(e): 1, Subcola P=0: vacía | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(f): 7, Subcola P=0: [7, 3] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(g): false, Subcola P=0: [7, 3] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(h): 7, Subcola P=0: [7, 3, 8] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]

Ej 10. En una Cola simple los elementos se atienden únicamente por orden de llegada: el primero que entra es el primero que sale. Es decir, sigue la regla FIFO directamente sobre una sola cola. En una Cola con Prioridad, cada elemento tiene asociada una prioridad. La estructura no atiende necesariamente al elemento que llegó primero en general, sino al primer elemento de la subcola no vacía con mayor prioridad. Dentro de una misma prioridad sí se respeta FIFO. La diferencia en Desacolar es que en una Cola simple se elimina siempre el primer elemento de la cola. En una Cola con Prioridad, Desacolar primero busca desde la prioridad más alta hacia la más baja, y elimina el primero de la primera subcola no vacía.

Ej 11. 

static ColaPrioTDA combinarColasConPrioridad(ColaPrioTDA CP1, ColaPrioTDA CP2) {
    ColaPrioTDA CP3 = new ColaPrioTDA();
    CP3.InicializarCola();

    ColaPrioTDA CPAux = new ColaPrioTDA();
    CPAux.InicializarCola();

    while (CP1.ColaVacia() == false) {
        int elementoAMover = CP1.Primero();
        int prioridadElemento = CP1.Prioridad();

        CP3.AcolarPrioridad(elementoAMover, prioridadElemento);
        CPAux.AcolarPrioridad(elementoAMover, prioridadElemento);

        CP1.Desacolar();
    }

    while (CPAux.ColaVacia() == false) {
        int elementoAMoverAColaOriginal = CPAux.Primero();
        int prioridadElemento = CPAux.Prioridad();

        CP1.AcolarPrioridad(elementoAMoverAColaOriginal, prioridadElemento);

        CPAux.Desacolar();
    }

    while (CP2.ColaVacia() == false) {
        int elementoAMover = CP2.Primero();
        int prioridadElemento = CP2.Prioridad();

        CP3.AcolarPrioridad(elementoAMover, prioridadElemento);
        CPAux.AcolarPrioridad(elementoAMover, prioridadElemento);

        CP2.Desacolar();
    }

    while (CPAux.ColaVacia() == false) {
        int elementoAMoverAColaOriginal = CPAux.Primero();
        int prioridadElemento = CPAux.Prioridad();

        CP2.AcolarPrioridad(elementoAMoverAColaOriginal, prioridadElemento);

        CPAux.Desacolar();
    }

    return CP3;
}

Ej 12. formato: output, {clave→valor, ...}

(a): 8, {3→15, 7→8, 1→22, 5→8}
(b): {3, 7, 1, 5}, {3→15, 7→8, 1→22, 5→8}
(c): 22, {7→8, 1→22, 5→8}
(d): 30, {7→30, 1→22, 5→8}
(e): {7, 1, 5}, {7→30, 1→22, 5→8}
(f): {7}, {7→30}
(g): 10, {7→30, 2→10}

Ej 13. formato: output, {clave→{valores}, ...}

(a): {10, 15, 8}, {2→{10, 15, 8}, 4→{7, 3, 12}, 6→{5}}
(b): {7, 3, 12}, {2→{10, 15, 8}, 4→{7, 3, 12}, 6→{5}}
(c): {2, 4, 6}, {2→{10, 15, 8}, 4→{7, 3, 12}, 6→{5}}
(d): {7, 12}, {2→{10, 15, 8}, 4→{7, 12}, 6→{5}}
(e): {2, 4}, {2→{10, 15, 8}, 4→{7, 12}}
(f): {10, 15, 8}, {2→{10, 15, 8}, 4→{7, 12}}
(g): {10, 15, 8}, {2→{10, 15, 8}, 4→{7, 12}}

Ej 14. La diferencia conceptual entre un Diccionario Simple y un Diccionario Múltiple es que en el Diccionario Simple cada clave tiene asociado un único valor, mientras que en el Diccionario Múltiple cada clave puede tener asociado un conjunto de valores. Si se llama a Agregar con una clave que ya existe en un Diccionario Simple, el valor anterior de esa clave se reemplaza por el nuevo valor. Si se llama a Agregar con una clave que ya existe en un Diccionario Múltiple, el nuevo valor se agrega al conjunto de valores asociado a esa clave. Si ese valor ya estaba en el conjunto, no se duplica.

Ej 15.

static void frecuencias(PilaTDA p, DicSimpleTDA d) {
    PilaTDA pilaAux = new PilaTDA();
    pilaAux.InicializarPila();

    while (p.PilaVacia() == false) {
        int elementoActual = p.Tope();
        p.Desapilar();

        ConjuntoTDA clavesDiccionario = d.Claves();

        if (clavesDiccionario.Pertenece(elementoActual) == false) {
            d.Agregar(elementoActual, 1);
        } else {
            int frecuenciaActual = d.Recuperar(elementoActual);
            d.Agregar(elementoActual, frecuenciaActual + 1);
        }

        pilaAux.Apilar(elementoActual);
    }

    while (pilaAux.PilaVacia() == false) {
        int elementoADevolver = pilaAux.Tope();
        pilaAux.Desapilar();

        p.Apilar(elementoADevolver);
    }
}

Ej 16.

static void invertir(DicSimpleTDA d, DicMultipleTDA dm) {
    dm.InicializarDiccionario();

    ConjuntoTDA clavesDiccionarioSimple = d.Claves();

    while (clavesDiccionarioSimple.ConjuntoVacio() == false) {
        int claveDiccionarioSimple = clavesDiccionarioSimple.Elegir();
        clavesDiccionarioSimple.Sacar(claveDiccionarioSimple);

        int valorDiccionarioSimple = d.Recuperar(claveDiccionarioSimple);

        dm.Agregar(valorDiccionarioSimple, claveDiccionarioSimple);
    }
}

