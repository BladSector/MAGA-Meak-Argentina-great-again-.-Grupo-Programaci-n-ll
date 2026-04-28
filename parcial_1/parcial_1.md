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

Ej 2. `metodoV()` suma todos los elementos de la pila. Para recorrerla, va sacando el tope y guardándolo en una pila auxiliar. Después devuelve los elementos desde la auxiliar a la pila original. La pila queda igual que antes de llamar al método. Para el estado del inciso (d), retorna 35 porque 5+12+3+9+6=35.

Ej 3. Si se intenta `Apilar()` con la pila llena, `PilaLlena()` da true, entonces `!PilaLlena()` da false y no entra al `if`. La pila queda igual. Si se intenta `Desapilar()` con la pila vacía, `PilaVacia()` da true, entonces `!PilaVacia()` da false y no se decrementa `datos[0]`. También queda igual.


Ej 4. Implementación estática: usa un arreglo de tamaño fijo. En esta versión, `datos[0]` guarda la cantidad y el tope está en `datos[datos[0]]`. Ventaja: es simple y el acceso al tope es directo. Desventaja: tiene capacidad máxima.

Implementación dinámica: usa nodos enlazados. Cada nodo guarda el valor y una referencia al siguiente. Ventaja: puede crecer mientras haya memoria. Desventaja: usa memoria extra por los enlaces y hay que manejar referencias.


▸ Estado de una COLA
De PRIMERO al último: Primero→v1→v2→...→último → ejemplo: Primero→10→25→7→último

Ej 5. formato: output, Primero(), Primero→v1→v2→...→último

(a): 4, 4, Primero→4→9→2→7→5→último
(b): 2, 2, Primero→2→7→5→11→3→último
(c): true, Primero→vacia→último
(d): error / operación no definida sobre cola vacía, Primero→vacia→último
(e): 8, Primero→8→último, si se toma `c.Acolar(8)` como instrucción ejecutable después de (d)

Ej 6. formato: output, datos[0], {v1, v2, ...}

(a): true, 5, {3,7,1,5,9}
(b): false, 5, {3,7,1,5,9}
(c): false, 5, {3,7,9,5,4}
(d): false, 5, {3,7,9,5,4}
(e): true, 5, {3,7,9,5,4}
(f): 6, 6, {3,7,9,5,4,2}
(g): 6, 6, {3,7,9,5,4,2}

Fragmento clave:

```java
void Agregar(int x) {
    if (!ConjuntoLleno() && !Pertenece(x)) {
        datos[0]++;
        datos[datos[0]] = x;
    }
}
```

Ej 7. `Agregar(x)` no agrega nada si el conjunto está lleno o si `x` ya pertenece al conjunto. El `if` exige dos cosas al mismo tiempo: `!ConjuntoLleno()` y `!Pertenece(x)`. Si alguna falla, el conjunto queda igual.

Ej 8.

cola = Primero→1→2→3→4→5→último
conjunto = {2,3,4}

```java
static void eliminarDeColaLosElementosPresentesEnConjunto(ColaTDA cola, ConjuntoTDA conjunto) {

    ColaTDA colaAux = new ColaDinamica();
    colaAux.InicializarCola();

    while (cola.ColaVacia() == false) {
        int elemento = cola.Primero();
        cola.Desacolar();

        if (conjunto.Pertenece(elemento) == false) {
            colaAux.Acolar(elemento);
        }
    }

    while (colaAux.ColaVacia() == false) {
        int elemento = colaAux.Primero();
        colaAux.Desacolar();
        cola.Acolar(elemento);
    }
}
```

Ej 9. formato: output, Subcola P=0: [...] | Subcola P=1: [...] | Subcola P=2: [...]

(a): 2, Subcola P=0: [2, 5, 4] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(b): 0, Subcola P=0: [2, 5, 4] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(c): 5, Subcola P=0: [5, 4] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(d): 6, Subcola P=0: vacía | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(e): 1, Subcola P=0: vacía | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(f): 7, Subcola P=0: [7, 3] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(g): false, Subcola P=0: [7, 3] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]
(h): 7, Subcola P=0: [7, 3, 8] | Subcola P=1: [6, 9] | Subcola P=2: [13, 1]

Ej 10. Cola simple: sale por orden de llegada, FIFO global. Cola con prioridad: sale primero la prioridad más alta. Dentro de una misma prioridad se respeta FIFO si la implementación lo define así. En una cola simple, `Desacolar()` elimina siempre el primer elemento. En una cola con prioridad, `Desacolar()` busca primero la subcola de mayor prioridad no vacía y saca el primero de esa subcola.

Ej 11. 

```java
static ColaPrioTDA combinarColasConPrioridad(ColaPrioTDA CP1, ColaPrioTDA CP2) {
    ColaPrioTDA CP3 = new ColaPrioTDA(); // usar la implementación concreta del enunciado
    CP3.InicializarCola();

    ColaPrioTDA CPAux = new ColaPrioTDA(); // auxiliar del mismo TDA
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
```

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

Ej 14. Diccionario Simple: una clave tiene un único valor. Si llamo `Agregar` con una clave existente, reemplaza el valor anterior. Diccionario Múltiple: una clave tiene un conjunto de valores. Si llamo `Agregar` con una clave existente, agrega el valor al conjunto. Si ese valor ya estaba, no lo duplica.

Ej 15.

```java
static void frecuencias(PilaTDA p, DicSimpleTDA d) {
    d.InicializarDiccionario();

    PilaTDA pilaAux = new PilaDinamica();
    pilaAux.InicializarPila();

    while (p.PilaVacia() == false) {
        int elementoActual = p.Tope();
        p.Desapilar();

        ConjuntoTDA clavesDiccionario = d.Claves(); // según el parcial, Claves() se usa como conjunto

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
```

Ej 16.

```java
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
```
