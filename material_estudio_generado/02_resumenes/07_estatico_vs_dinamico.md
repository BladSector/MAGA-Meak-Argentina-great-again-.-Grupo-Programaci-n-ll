# Estatico vs dinamico

## Implementacion estatica

Usa arreglos. La memoria esta reservada con una capacidad maxima.

Ventajas:

- Simple de entender.
- Acceso directo por indice.
- Menos objetos auxiliares.

Desventajas:

- Tiene limite fijo.
- Si se llena, no puede agregar mas.
- Algunas operaciones obligan a desplazar elementos.

Ejemplo de pila estatica con `datos[0]` como cantidad:

```java
datos[0]++;              // aumenta cantidad
datos[datos[0]] = x;     // guarda nuevo tope
```

## Implementacion dinamica

Usa nodos enlazados. Cada nodo guarda dato y referencia al siguiente.

Ventajas:

- No necesita definir capacidad maxima de entrada.
- Crece mientras haya memoria.
- Insertar o sacar en el frente suele ser `O(1)`.

Desventajas:

- Cada nodo consume memoria extra por el enlace.
- Hay que manejar referencias con cuidado.
- No hay acceso directo por indice.

## Estrategias de pila con arreglos

| Estrategia | Como guarda | Apilar | Desapilar | Comentario |
| --- | --- | --- | --- | --- |
| 1 | Arreglo + `cantidad` separada | `O(1)` | `O(1)` | Tope en `datos[cantidad - 1]` |
| 2 | Tope siempre en `datos[0]` | `O(n)` | `O(n)` | Mueve elementos. Es la mas ineficiente para apilar |
| 3 | `datos[0]` guarda cantidad | `O(1)` | `O(1)` | Pierde la posicion 0 para datos reales |

Respuesta corta para parcial:

```text
La estrategia 2 es la mas ineficiente para Apilar porque mantiene el tope en la posicion 0. Cada nuevo elemento obliga a desplazar todos los elementos existentes una posicion a la derecha. Por eso Apilar cuesta O(n). En las estrategias 1 y 3 se agrega directo en la siguiente posicion libre, con costo O(1).
```

## Cola estatica vs cola dinamica

Cola estatica del profe:

```text
Acolar: agrega al final del arreglo.
Desacolar: corre todo a la izquierda.
```

Cola dinamica del profe:

```text
frente -> primer nodo
fondo -> ultimo nodo
Acolar agrega atras, Desacolar avanza frente.
```

Si te preguntan ventaja de dinamica:

```text
No tiene limite fijo de cantidad. Ademas, desacolar no necesita desplazar todo el arreglo.
```

Si te preguntan desventaja:

```text
Usa mas memoria por nodo y requiere manejar enlaces.
```
