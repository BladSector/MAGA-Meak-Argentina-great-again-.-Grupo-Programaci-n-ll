# Parcial 1 resuelto

Fuente: [ExamenParcial1_ProgII convertido](../01_pdfs_convertidos/examenparcial1_progii_1.md).

## Ejercicio 1, Pila

Estado inicial luego de apilar `5, 12, 3, 8, 1`:

```text
datos[0] = 5
base -> 5 -> 12 -> 3 -> 8 -> 1 -> tope
```

Respuestas:

```text
(a) output: 1, datos[0]: 5, pila: base -> 5 -> 12 -> 3 -> 8 -> 1 -> tope
(b) output: 5, datos[0]: 5, pila: base -> 5 -> 12 -> 3 -> 8 -> 1 -> tope
(c) output: 6, datos[0]: 5, pila: base -> 5 -> 12 -> 3 -> 9 -> 6 -> tope
(d) output: 5, datos[0]: 5, pila: base -> 5 -> 12 -> 3 -> 9 -> 6 -> tope
(e) output: 35, datos[0]: 5, pila: base -> 5 -> 12 -> 3 -> 9 -> 6 -> tope
(f) output: 6, datos[0]: 5, pila: base -> 5 -> 12 -> 3 -> 9 -> 6 -> tope
(g) output: 5, datos[0]: 5, pila: base -> 5 -> 12 -> 3 -> 9 -> 6 -> tope
(h) output: 7, datos[0]: 7, pila: base -> 5 -> 12 -> 3 -> 9 -> 6 -> 4 -> 7 -> tope
```

`metodoV()` suma todos los elementos de la pila. Para no perderlos, los pasa a una pila auxiliar y despues los devuelve. La pila queda igual que antes de llamar al metodo. Para el estado del inciso `(d)`, retorna `35` porque `5 + 12 + 3 + 9 + 6 = 35`.

Si se llama `Apilar` con pila llena, no hace nada porque el `if (!PilaLlena())` no entra. Si se llama `Desapilar` con pila vacia, tampoco hace nada porque el `if (!PilaVacia())` no entra.

Estatico vs dinamico:

```text
Estatico: usa arreglo de tamaño fijo. Ventaja: simple y acceso directo. Desventaja: capacidad limitada.
Dinamico: usa nodos enlazados. Ventaja: crece mientras haya memoria. Desventaja: cada nodo consume enlace y hay que manejar referencias.
```

## Ejercicio 2, Cola y Conjunto

### Cola

Respuestas esperadas por logica de TDA:

```text
(a) output: 4, cola: Primero -> 4 -> 9 -> 2 -> 7 -> 5 -> ultimo
(b) output: 2, cola: Primero -> 2 -> 7 -> 5 -> 11 -> 3 -> ultimo
(c) output: true, cola: vacia
```

Trampa del PDF: despues de `(c)` se llama `Primero()` con la cola vacia.

En Java literal, `Primero()` hace `return cab.val;`. Si `cab == null`, eso produce `NullPointerException`. El TDA tampoco define `Primero` para cola vacia.

Entonces:

```text
(d) output: error / operacion no definida sobre cola vacia, cola: vacia
```

El PDF muestra `c.Acolar(8)` en la misma linea del comentario de `(d)`. Si el profesor lo quiso como instruccion posterior, entonces:

```text
(e) output: 8, cola: Primero -> 8 -> ultimo
```

Si se ejecuta Java exactamente como esta escrito en el PDF, el programa se corta en `(d)` y `(e)` no llega a ejecutarse. En examen, yo responderia `(d) error/indefinido` y aclararia la intencion probable de `(e)=8` si `c.Acolar(8)` se toma como linea ejecutable.

### Conjunto

Despues de agregar `3, 7, 1, 5, 9`:

```text
{3, 7, 1, 5, 9}
```

Luego `Sacar(1)` reemplaza el `1` por el ultimo (`9`) y baja la cantidad. Despues `Agregar(4)` agrega `4`.

Respuestas:

```text
(a) output: true, conjunto: {3, 7, 1, 5, 9}
(b) output: false, conjunto: {3, 7, 1, 5, 9}
(c) output: false, conjunto: {3, 7, 9, 5, 4}
(d) output: false, conjunto: {3, 7, 9, 5, 4}
(e) output: true, conjunto: {3, 7, 9, 5, 4}
(f) output: 6, conjunto: {3, 7, 9, 5, 4, 2}
(g) output: 6, conjunto: {3, 7, 9, 5, 4, 2}
```

El orden del conjunto no deberia importar. Si el formulario pide estado, uso el orden de la implementacion mostrada.

Si `Agregar` se llama con conjunto lleno, no agrega. Si el elemento ya pertenece, tampoco agrega. El codigo exige las dos condiciones:

```java
if (!ConjuntoLleno() && !Pertenece(x)) {
    datos[0]++;
    datos[datos[0]] = x;
}
```

Metodo pedido:

```java
static void eliminarDeColaLosElementosPresentesEnConjunto(ColaTDA cola, ConjuntoTDA conjunto) {
    ColaTDA aux = new ColaDinamica();
    aux.InicializarCola();

    while (!cola.ColaVacia()) {
        int x = cola.Primero();
        cola.Desacolar();

        if (!conjunto.Pertenece(x)) {
            aux.Acolar(x);
        }
    }

    while (!aux.ColaVacia()) {
        cola.Acolar(aux.Primero());
        aux.Desacolar();
    }
}
```

## Ejercicio 3, Cola con Prioridad

Convencion del parcial: `P=0` es mayor prioridad.

Estado luego de las primeras cargas:

```text
Subcola P=0: [2, 5, 4]
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]
```

Respuestas:

```text
(a) output: 2
Subcola P=0: [2, 5, 4]
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]

(b) output: 0
Subcola P=0: [2, 5, 4]
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]

(c) output: 5
Subcola P=0: [5, 4]
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]

(d) output: 6
Subcola P=0: vacia
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]

(e) output: 1
Subcola P=0: vacia
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]

(f) output: 7
Subcola P=0: [7, 3]
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]

(g) output: false
Subcola P=0: [7, 3]
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]

(h) output: 7
Subcola P=0: [7, 3, 8]
Subcola P=1: [6, 9]
Subcola P=2: [13, 1]
```

Diferencia con cola simple:

```text
Cola simple: atiende por orden de llegada, FIFO global.
Cola con prioridad: atiende primero la prioridad mas alta. Dentro de la misma prioridad se mantiene FIFO si la implementacion lo define asi.
```

Metodo para combinar:

```java
static ColaPrioridadTDA combinarColasConPrioridad(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
    ColaPrioridadTDA cp3 = new ColaPrioridadDinamica();
    ColaPrioridadTDA aux = new ColaPrioridadDinamica();

    cp3.InicializarColaPrioridad();
    aux.InicializarColaPrioridad();

    copiarYRestaurar(cp1, cp3, aux);
    copiarYRestaurar(cp2, cp3, aux);

    return cp3;
}

static void copiarYRestaurar(ColaPrioridadTDA origen,
                             ColaPrioridadTDA destino,
                             ColaPrioridadTDA aux) {
    while (!origen.ColaVacia()) {
        int x = origen.Primero();
        int p = origen.Prioridad();

        destino.AcolarPrioridad(x, p);
        aux.AcolarPrioridad(x, p);
        origen.Desacolar();
    }

    while (!aux.ColaVacia()) {
        origen.AcolarPrioridad(aux.Primero(), aux.Prioridad());
        aux.Desacolar();
    }
}
```

## Ejercicio 4, Diccionarios

### Diccionario simple

Respuestas:

```text
(a) output: 8, diccionario: {3->15, 7->8, 1->22, 5->8}
(b) output: {3, 7, 1, 5}, diccionario: {3->15, 7->8, 1->22, 5->8}
(c) output: 22, diccionario: {7->8, 1->22, 5->8}
(d) output: 30, diccionario: {7->30, 1->22, 5->8}
(e) output: {7, 1, 5}, diccionario: {7->30, 1->22, 5->8}
(f) output: {7}, diccionario: {7->30}
(g) output: 10, diccionario: {7->30, 2->10}
```

Si el corrector no exige orden, cualquier orden equivalente de claves esta bien.

### Diccionario multiple

Respuestas:

```text
(a) output: {10, 15, 8}, diccionario: {2->{10, 15, 8}, 4->{7, 3, 12}, 6->{5}}
(b) output: {7, 3, 12}, diccionario: {2->{10, 15, 8}, 4->{7, 3, 12}, 6->{5}}
(c) output: {2, 4, 6}, diccionario: {2->{10, 15, 8}, 4->{7, 3, 12}, 6->{5}}
(d) output: {7, 12}, diccionario: {2->{10, 15, 8}, 4->{7, 12}, 6->{5}}
(e) output: {2, 4}, diccionario: {2->{10, 15, 8}, 4->{7, 12}}
(f) output: {10, 15, 8}, diccionario: {2->{10, 15, 8}, 4->{7, 12}}
(g) output: {10, 15, 8}, diccionario: {2->{10, 15, 8}, 4->{7, 12}}
```

Teoria:

```text
Diccionario Simple: una clave tiene un unico valor. Si agrego una clave existente, reemplazo el valor.

Diccionario Multiple: una clave tiene un conjunto de valores. Si agrego una clave existente, agrego el valor al conjunto sin duplicarlo.
```

## Ejercicio 5, Integrador

Frecuencias:

Este código sigue el enunciado del parcial: `Claves()` se trata como conjunto y `DicSimpleTDA` tiene `Recuperar`.

```java
static void frecuencias(PilaTDA p, DicSimpleTDA d) {
    d.InicializarDiccionario();

    PilaTDA aux = new PilaDinamica();
    aux.InicializarPila();

    while (!p.PilaVacia()) {
        int x = p.Tope();
        p.Desapilar();

        ConjuntoTDA claves = d.Claves();
        if (!claves.Pertenece(x)) {
            d.Agregar(x, 1);
        } else {
            d.Agregar(x, d.Recuperar(x) + 1);
        }

        aux.Apilar(x);
    }

    while (!aux.PilaVacia()) {
        p.Apilar(aux.Tope());
        aux.Desapilar();
    }
}
```

Invertir:

```java
static void invertir(DicSimpleTDA d, DicMultipleTDA dm) {
    dm.InicializarDiccionario();

    ConjuntoTDA claves = d.Claves();

    while (!claves.ConjuntoVacio()) {
        int clave = claves.Elegir();
        claves.Sacar(clave);

        int valor = d.Recuperar(clave);
        dm.Agregar(valor, clave);
    }
}
```

Ejemplo:

```text
d = {1->5, 2->8, 3->5, 4->8}
dm = {5->{1, 3}, 8->{2, 4}}
```
