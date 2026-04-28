# Patrones de resolucion con pseudocodigo y Java

Estos son moldes. En parcial, cambia nombres de clases segun el enunciado.

## Recorrer pila y dejarla igual

```java
static void procesarPila(PilaTDA p) {
    PilaTDA aux = new PilaDinamica();
    aux.InicializarPila();

    while (!p.PilaVacia()) {
        int x = p.Tope();
        p.Desapilar();

        // usar x

        aux.Apilar(x);
    }

    while (!aux.PilaVacia()) {
        p.Apilar(aux.Tope());
        aux.Desapilar();
    }
}
```

Pseudocodigo:

```text
Mientras la pila tenga elementos:
    leo el tope
    lo saco
    lo guardo en auxiliar
Despues devuelvo desde auxiliar a la original
```

## Recorrer cola y dejarla igual

```java
static void procesarCola(ColaTDA c) {
    ColaTDA aux = new ColaDinamica();
    aux.InicializarCola();

    while (!c.ColaVacia()) {
        int x = c.Primero();
        c.Desacolar();

        // usar x

        aux.Acolar(x);
    }

    while (!aux.ColaVacia()) {
        c.Acolar(aux.Primero());
        aux.Desacolar();
    }
}
```

## Eliminar de cola los elementos presentes en conjunto

```java
static void eliminarDeColaLosPresentesEnConjunto(ColaTDA cola, ConjuntoTDA conjunto) {
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

Explicacion simple:

```text
Saco uno por uno de la cola. Si no esta en el conjunto, lo paso a una cola auxiliar. Al final reconstruyo la original con la auxiliar. Asi mantengo el orden relativo de los que quedan.
```

## Combinar dos colas con prioridad sin destruirlas

```java
static ColaPrioridadTDA combinar(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
    ColaPrioridadTDA cp3 = new ColaPrioridadDinamica();
    ColaPrioridadTDA aux = new ColaPrioridadDinamica();

    cp3.InicializarColaPrioridad();
    aux.InicializarColaPrioridad();

    copiar(cp1, cp3, aux);
    copiar(cp2, cp3, aux);

    return cp3;
}

static void copiar(ColaPrioridadTDA origen,
                   ColaPrioridadTDA destino,
                   ColaPrioridadTDA aux) {
    while (!origen.ColaVacia()) {
        int x = origen.Primero();
        int pr = origen.Prioridad();

        destino.AcolarPrioridad(x, pr);
        aux.AcolarPrioridad(x, pr);
        origen.Desacolar();
    }

    while (!aux.ColaVacia()) {
        origen.AcolarPrioridad(aux.Primero(), aux.Prioridad());
        aux.Desacolar();
    }
}
```

Si el enunciado usa `InicializarCola()` para cola con prioridad, cambia solo ese nombre.

## Frecuencias de una pila en diccionario simple

El parcial supone que `DicSimpleTDA` tiene `Recuperar` y que `Claves()` se puede consultar como conjunto. Si tu implementacion concreta devuelve un arreglo de claves, recorres ese arreglo para saber si la clave existe. La logica es la misma.

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

Misma idea si `Claves()` devuelve `int[]`:

```java
static boolean existeClave(DicSimpleTDA d, int x) {
    int[] claves = d.Claves();

    for (int i = 0; i < claves.length; i++) {
        if (claves[i] == x) {
            return true;
        }
    }

    return false;
}
```

## Invertir diccionario simple en diccionario multiple

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

Explicacion:

```text
Recorro cada clave del diccionario simple. Recupero su valor. En el diccionario multiple agrego como clave ese valor y como valor asociado la clave original.
```
