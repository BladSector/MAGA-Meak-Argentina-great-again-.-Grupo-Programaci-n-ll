# Diccionarios

Un diccionario guarda pares clave y valor. La clave es unica.

## Diccionario simple

Cada clave tiene un unico valor.

```text
{dni -> persona}
{usuario -> puntajeMaximo}
{dominio -> ip}
```

Si haces `Agregar(clave, valor)` y la clave ya existe, se reemplaza el valor anterior.

```java
void Agregar(int clave, int valor) {
    Node curr = cabeza;

    while (curr != null && curr.getClave() != clave) {
        curr = curr.getNext();
    }

    if (curr != null) {
        curr.setValor(valor);
    } else {
        cabeza = new Node(clave, valor, cabeza);
    }
}
```

## Diccionario multiple

Cada clave tiene varios valores, sin repetir valores para la misma clave.

```text
{palabra -> {sinonimo1, sinonimo2}}
{legajo -> {materia1, materia2}}
{palabraIndice -> {12, 45, 88}}
```

Si la clave existe, `Agregar(clave, valor)` agrega el valor al conjunto asociado. Si el valor ya estaba, no lo duplica.

```java
void Agregar(int clave, int valor) {
    NodeClave nodoClave = buscarClave(clave);

    if (nodoClave == null) {
        NodeValor nodoValor = new NodeValor(valor, null);
        cabeza = new NodeClave(clave, nodoValor, cabeza);
    } else if (!existeValor(nodoClave, valor)) {
        nodoClave.setPrimero(new NodeValor(valor, nodoClave.getPrimero()));
    }
}
```

## Diferencia para responder en teoria

```text
Diccionario Simple: una clave se asocia a un solo valor. Si agrego la misma clave de nuevo, reemplazo el valor.

Diccionario Multiple: una clave se asocia a un conjunto de valores. Si agrego la misma clave de nuevo, sumo el nuevo valor al conjunto, sin duplicarlo si ya estaba.
```

## Frecuencias con diccionario simple

Problema: dada una pila, construir un diccionario donde la clave es cada numero y el valor es cuantas veces aparece.

Nota de repo: el parcial usa `Recuperar` en diccionario simple y trata `Claves()` como un conjunto. En una interfaz del codigo del profe, `Recuperar` no aparece declarado y `Claves()` devuelve `int[]`. En examen manda el enunciado. Si el enunciado dice conjunto, usá `Pertenece`; si te dan `int[]`, recorré el arreglo.

```java
if (!d.Claves().Pertenece(x)) {
    d.Agregar(x, 1);
} else {
    int actual = d.Recuperar(x);
    d.Agregar(x, actual + 1);
}
```

Variante si `Claves()` devuelve `int[]`:

```java
int[] claves = d.Claves();
boolean existe = false;

for (int i = 0; i < claves.length; i++) {
    if (claves[i] == x) {
        existe = true;
    }
}
```

Ejemplo:

```text
pila: base -> 5 -> 7 -> 5 -> 2 -> 7 -> tope
diccionario: {5->2, 7->2, 2->1}
```

## Invertir diccionario simple a multiple

Problema:

```text
d = {1->5, 2->8, 3->5, 4->8}
```

Resultado:

```text
dm = {5->{1,3}, 8->{2,4}}
```

La clave nueva es el valor viejo. El valor nuevo es la clave vieja.

```java
int valor = d.Recuperar(clave);
dm.Agregar(valor, clave);
```
