# Machete de 1 hora

Este archivo es para examen abierto. La idea no es sonar lindo, es responder bien y rapido.

## Operaciones por TDA

| TDA | Regla mental | Operaciones que suelen pedir |
| --- | --- | --- |
| Pila | LIFO: ultimo en entrar, primero en salir | `InicializarPila`, `Apilar`, `Desapilar`, `Tope`, `PilaVacia` |
| Cola | FIFO: primero en entrar, primero en salir | `InicializarCola`, `Acolar`, `Desacolar`, `Primero`, `ColaVacia` |
| Cola con prioridad | Sale el de mayor prioridad. En empate, FIFO si la implementacion lo respeta | `AcolarPrioridad`, `Desacolar`, `Primero`, `Prioridad`, `ColaVacia` |
| Conjunto | Sin duplicados, sin posicion importante | `InicializarConjunto`, `Agregar`, `Sacar`, `Pertenece`, `Elegir`, `ConjuntoVacio` |
| Diccionario simple | Una clave tiene un solo valor | `InicializarDiccionario`, `Agregar`, `Eliminar`, `Recuperar`, `Claves` |
| Diccionario multiple | Una clave tiene un conjunto de valores | `Agregar`, `EliminarValor`, `Eliminar`, `Recuperar`, `Claves` |

## Como trazar estados sin perderte

Para pila, escribi de base a tope:

```text
base -> 5 -> 12 -> 3 -> tope
```

Para cola, escribi desde el primero al ultimo:

```text
Primero -> 4 -> 9 -> 2 -> ultimo
```

Para prioridad, separa subcolas:

```text
Subcola P=0: [2, 5]
Subcola P=1: [6]
Subcola P=2: vacia
```

Para conjunto, no te cases con el orden:

```text
{3, 7, 9}
```

Para diccionario:

```text
Simple: {7->30, 2->10}
Multiple: {2->{10,15,8}, 4->{7,12}}
```

## Patrones que aparecen todo el tiempo

Recorrer pila sin destruirla:

```java
PilaTDA aux = new PilaDinamica();
aux.InicializarPila();

while (!p.PilaVacia()) {
    int x = p.Tope();
    p.Desapilar();
    // trabajar con x
    aux.Apilar(x);
}

while (!aux.PilaVacia()) {
    p.Apilar(aux.Tope());
    aux.Desapilar();
}
```

Recorrer cola sin destruirla:

```java
ColaTDA aux = new ColaDinamica();
aux.InicializarCola();

while (!c.ColaVacia()) {
    int x = c.Primero();
    c.Desacolar();
    // trabajar con x
    aux.Acolar(x);
}

while (!aux.ColaVacia()) {
    c.Acolar(aux.Primero());
    aux.Desacolar();
}
```

Filtrar una cola manteniendo orden:

```java
while (!c.ColaVacia()) {
    int x = c.Primero();
    c.Desacolar();

    if (!conjunto.Pertenece(x)) {
        aux.Acolar(x);
    }
}

while (!aux.ColaVacia()) {
    c.Acolar(aux.Primero());
    aux.Desacolar();
}
```

Contar frecuencias de una pila:

En el parcial, `Claves()` se usa como conjunto. En el código del profe, algunas interfaces devuelven `int[]`. Mirá el enunciado antes de copiar.

```java
// clave = numero de la pila, valor = cantidad de apariciones
if (!d.Claves().Pertenece(x)) {
    d.Agregar(x, 1);
} else {
    d.Agregar(x, d.Recuperar(x) + 1);
}
```

Si `Claves()` devuelve arreglo:

```java
static boolean contiene(int[] claves, int x) {
    for (int i = 0; i < claves.length; i++) {
        if (claves[i] == x) return true;
    }
    return false;
}
```

Invertir diccionario simple a multiple:

```java
// d: {1->5, 2->8, 3->5}
// dm: {5->{1,3}, 8->{2}}
dm.Agregar(valor, clave);
```

## Errores que cuestan puntos

- Decir que pila es FIFO. No. Pila es LIFO.
- Decir que cola es LIFO. No. Cola es FIFO.
- Usar `datos[]` cuando el enunciado dice "solo operaciones del TDA".
- Vaciar una pila o cola y olvidarte de restaurarla.
- Asumir orden en un conjunto. El conjunto no promete orden.
- Confundir la convencion de prioridad. En el parcial del PDF, `P=0` es mayor prioridad. En el codigo del profe, prioridad mas alta numericamente sale primero.
- Llamar `Primero`, `Tope` o `Elegir` sobre estructura vacia. Eso no esta definido por el TDA y en Java puede explotar.
