# Colas

Una cola sigue FIFO: el primero que entra es el primero que sale. Piensa en una fila normal.

## Operaciones

```java
InicializarCola();
Acolar(x);
Desacolar();
Primero();
ColaVacia();
```

`Acolar` agrega al final. `Desacolar` saca del frente. `Primero` mira el frente sin sacarlo.

## Estado de una cola

```java
c.Acolar(4);
c.Acolar(9);
c.Acolar(2);
```

Estado:

```text
Primero -> 4 -> 9 -> 2 -> ultimo
```

`Primero()` devuelve `4`. Luego de `Desacolar()`:

```text
Primero -> 9 -> 2 -> ultimo
```

## Cola estatica del profe

Usa arreglo y `cantidad`. Acolar agrega al final. Desacolar desplaza todo a la izquierda.

```java
void Acolar(int x) {
    if (cantidad < MAX) {
        datos[cantidad] = x;
        cantidad++;
    }
}

void Desacolar() {
    if (!ColaVacia()) {
        for (int i = 0; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }
        cantidad--;
    }
}

int Primero() {
    return datos[0];
}
```

`Acolar` cuesta `O(1)`. `Desacolar` cuesta `O(n)` por el corrimiento.

## Cola dinamica del profe

Tiene dos referencias:

- `frente`: primer nodo, el que sale.
- `fondo`: ultimo nodo, donde entra el nuevo.

```java
void Acolar(int x) {
    Node node = new Node(x, null);

    if (ColaVacia()) {
        frente = node;
    } else {
        fondo.setNext(node);
    }

    fondo = node;
}

void Desacolar() {
    if (!ColaVacia()) {
        frente = frente.getNext();

        if (frente == null) {
            fondo = null;
        }
    }
}
```

El detalle importante es limpiar `fondo` cuando se elimina el ultimo nodo. Si no, queda apuntando a basura logica.

## Filtrar una cola manteniendo orden

Problema tipico: eliminar de una cola todos los elementos que estan en un conjunto.

Pseudocodigo:

```text
crear cola auxiliar
mientras cola original no este vacia:
    x = Primero(original)
    Desacolar(original)
    si x NO pertenece al conjunto:
        Acolar(aux, x)

mientras aux no este vacia:
    mover Primero(aux) a original
```

Codigo:

```java
static void eliminarPresentes(ColaTDA cola, ConjuntoTDA conjunto) {
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

Ejemplo:

```text
cola = Primero -> 1 -> 2 -> 3 -> 4 -> 5 -> ultimo
conjunto = {2, 3, 4}
resultado = Primero -> 1 -> 5 -> ultimo
```
