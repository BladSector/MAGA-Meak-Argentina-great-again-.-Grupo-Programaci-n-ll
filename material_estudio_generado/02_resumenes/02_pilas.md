# Pilas

Una pila sigue LIFO: el ultimo que entra es el primero que sale. Piensa en platos. El ultimo plato que pusiste arriba es el primero que podes sacar sin mover todo.

## Operaciones

```java
InicializarPila();
Apilar(x);
Desapilar();
Tope();
PilaVacia();
```

`Tope()` mira el ultimo elemento apilado. `Desapilar()` lo saca. Si la pila esta vacia, no deberias llamar `Tope()`.

## Estado de una pila

Si haces:

```java
p.Apilar(5);
p.Apilar(12);
p.Apilar(3);
```

El estado se escribe:

```text
base -> 5 -> 12 -> 3 -> tope
```

`Tope()` devuelve `3`. Si haces `Desapilar()`, queda:

```text
base -> 5 -> 12 -> tope
```

## Implementacion estatica, estrategia 1

Usa arreglo y una variable `cantidad`. El tope queda en `datos[cantidad - 1]`.

```java
void Apilar(int x) {
    if (cantidad < MAX) {
        datos[cantidad] = x;
        cantidad++;
    }
}

void Desapilar() {
    if (!PilaVacia()) {
        cantidad--;
    }
}

int Tope() {
    return datos[cantidad - 1];
}
```

Costo normal: `Apilar`, `Desapilar` y `Tope` son `O(1)`.

## Implementacion estatica, estrategia 2

El tope siempre esta en `datos[0]`. Para apilar, corre todo a la derecha.

```java
void Apilar(int x) {
    if (cantidad < MAX) {
        for (int i = cantidad; i > 0; i--) {
            datos[i] = datos[i - 1];
        }
        datos[0] = x;
        cantidad++;
    }
}
```

Esta es la estrategia pesada. `Apilar` cuesta `O(n)` porque mueve todos los elementos.

## Implementacion estatica, estrategia 3

La posicion `datos[0]` guarda la cantidad. Los datos reales empiezan en `datos[1]`.

```java
void InicializarPila() {
    datos = new int[MAX + 1];
    datos[0] = 0;
}

void Apilar(int x) {
    if (datos[0] < MAX) {
        datos[0]++;
        datos[datos[0]] = x;
    }
}

int Tope() {
    return datos[datos[0]];
}
```

Esto es lo que usa el parcial en el ejercicio 1.

## Implementacion dinamica

Usa nodos. El atributo `tope` apunta al ultimo nodo agregado.

```java
void Apilar(int x) {
    Node nuevo = new Node(x, tope);
    tope = nuevo;
}

void Desapilar() {
    if (!PilaVacia()) {
        tope = tope.getNext();
    }
}
```

Ventaja: no tiene capacidad fija como un arreglo. Desventaja: cada nodo guarda dato y enlace, y la implementacion es mas delicada.

## Balanceo de parentesis

Idea:

```text
Si veo apertura: apilo.
Si veo cierre: necesito que haya una apertura en el tope, comparo y desapilo.
Al final la pila debe quedar vacia.
```

Ejemplo para `( ( a + b ) * c )`:

```text
leo '(' -> Apilar('(')
leo '(' -> Apilar('(')
leo ')' -> Tope debe ser '(' y Desapilar()
leo ')' -> Tope debe ser '(' y Desapilar()
fin -> PilaVacia() debe ser true
```

## Revertir un string

```java
String palabra = "ALGORITMOS";

for (int i = 0; i < palabra.length(); i++) {
    p.Apilar(palabra.charAt(i));
}

while (!p.PilaVacia()) {
    System.out.print(p.Tope());
    p.Desapilar();
}
```

Sale `SOMTIROGLA`, porque la pila devuelve primero lo ultimo que entro.

## Undo de editor

Cada cambio guarda una version del texto:

```text
Apilar(estado0)
Apilar(estado1)
Apilar(estado2)
```

Para deshacer:

```java
pilaEstados.Desapilar();
estadoActual = pilaEstados.Tope();
```

## Call stack

Si `Main()` llama a `CalcularPromedio()` y esta llama a `Sumar()`, en el momento de ejecutar la suma el tope conceptual del call stack es `Sumar()`.
