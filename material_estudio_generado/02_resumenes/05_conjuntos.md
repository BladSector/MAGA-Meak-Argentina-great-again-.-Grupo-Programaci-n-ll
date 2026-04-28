# Conjuntos

Un conjunto guarda elementos sin duplicados. No promete orden.

## Operaciones

```java
InicializarConjunto();
Agregar(x);
Sacar(x);
Pertenece(x);
Elegir();
ConjuntoVacio();
```

`Pertenece(x)` es la pregunta clave: sirve para evitar repetidos.

## Implementacion estatica del profe

Guarda elementos en un arreglo y una `cantidad`.

```java
void Agregar(int x) {
    if (cantidad < MAX && !Pertenece(x)) {
        datos[cantidad] = x;
        cantidad++;
    }
}
```

Si el conjunto esta lleno, no agrega. Si el elemento ya esta, tampoco agrega.

`Sacar` busca el elemento y lo reemplaza por el ultimo:

```java
void Sacar(int x) {
    int i = 0;

    while (i < cantidad && datos[i] != x) {
        i++;
    }

    if (i < cantidad) {
        datos[i] = datos[cantidad - 1];
        cantidad--;
    }
}
```

Eso cambia el orden del arreglo interno, pero no importa porque el conjunto no tiene orden.

## Implementacion dinamica del profe

Usa una lista enlazada. Agrega al inicio si no pertenece.

```java
void Agregar(int x) {
    if (!Pertenece(x)) {
        cabeza = new Node(x, cabeza);
    }
}
```

`Elegir()` devuelve el primer nodo:

```java
int Elegir() {
    return cabeza.getData();
}
```

En teoria, `Elegir` devuelve un elemento cualquiera. En una implementacion concreta puede ser siempre el primero, pero no deberias depender de eso salvo que el enunciado muestre el codigo.

## Ejemplos de modelado

Padron electoral:

```text
Conjunto de legajos que ya votaron.
Antes de votar: si Pertenece(legajo) es true, no lo dejo votar.
Si es false, voto y Agregar(legajo).
```

Tags de blog:

```text
Uso conjunto porque no quiero tags repetidos y no importa el orden.
```

Filtro de spam:

```text
Conjunto blacklist = {"crypto", "premio", "gana"}
Por cada palabra del mail pregunto blacklist.Pertenece(palabra).
```
