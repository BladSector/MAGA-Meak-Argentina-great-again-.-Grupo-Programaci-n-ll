# Colas con prioridad

Una cola con prioridad se parece a una cola normal, pero cada elemento trae un valor de prioridad. Sale primero el elemento de mayor prioridad. Si dos elementos tienen la misma prioridad, normalmente se respeta FIFO dentro de esa prioridad.

## Ojo con la convencion

En la guia de clase 3 aparece este criterio:

```text
Mayor valor entero = mayor prioridad
```

El codigo del profe tambien hace eso:

```java
while (curr.getNext() != null && curr.getNext().getPrioridad() >= prioridad) {
    curr = curr.getNext();
}
```

Ese `>=` deja al nuevo elemento atras de los que tienen la misma prioridad. O sea, empates por FIFO.

Pero el parcial del PDF dice otra cosa:

```text
K=3 subcolas, P=0 es la de mayor prioridad.
```

Entonces, para ese ejercicio concreto, `P=0` sale antes que `P=1` y `P=2`.

## Implementacion estatica del profe

Guarda dos arreglos: `datos[]` y `prioridades[]`. Inserta ordenado de mayor a menor prioridad.

```java
void AcolarPrioridad(int numero, int prioridad) {
    if (cantidad < MAX) {
        int i = cantidad - 1;

        while (i >= 0 && prioridades[i] < prioridad) {
            datos[i + 1] = datos[i];
            prioridades[i + 1] = prioridades[i];
            i--;
        }

        datos[i + 1] = numero;
        prioridades[i + 1] = prioridad;
        cantidad++;
    }
}
```

Si la prioridad nueva es mayor, se adelanta. Si es igual, no desplaza a los anteriores, queda atras.

## Implementacion dinamica del profe

La lista queda ordenada por prioridad descendente.

```java
void AcolarPrioridad(int numero, int prioridad) {
    Node nuevo = new Node(numero, prioridad, null);

    if (frente == null || prioridad > frente.getPrioridad()) {
        nuevo.setNext(frente);
        frente = nuevo;
    } else {
        Node curr = frente;
        while (curr.getNext() != null && curr.getNext().getPrioridad() >= prioridad) {
            curr = curr.getNext();
        }
        nuevo.setNext(curr.getNext());
        curr.setNext(nuevo);
    }
}
```

`Desacolar` saca el frente. `Primero` devuelve el dato del frente. `Prioridad` devuelve la prioridad del frente.

## Como combinar dos colas con prioridad sin destruirlas

La receta es copiar cada elemento a `CP3` y tambien a una auxiliar. Despues se restaura la cola original desde la auxiliar.

```java
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

Uso:

```java
static ColaPrioridadTDA combinar(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
    ColaPrioridadTDA cp3 = new ColaPrioridadDinamica();
    ColaPrioridadTDA aux = new ColaPrioridadDinamica();

    cp3.InicializarColaPrioridad();
    aux.InicializarColaPrioridad();

    copiarYRestaurar(cp1, cp3, aux);
    copiarYRestaurar(cp2, cp3, aux);

    return cp3;
}
```

Si en el parcial el nombre del metodo de inicializacion figura como `InicializarCola()`, usa ese nombre. La idea no cambia.
