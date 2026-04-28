# Bloque 3: Conjuntos

Un conjunto no admite repetidos. El orden no importa.

## Padrón electoral

Guardo en un conjunto los legajos que ya votaron.

```text
si votantes.Pertenece(legajo):
    no puede votar otra vez
si no:
    vota
    votantes.Agregar(legajo)
```

La operación que evita el doble voto es `Pertenece`.

## Invitados a la fiesta

Si intento agregar a alguien que ya está, el conjunto queda igual. El tamaño no cambia.

```text
invitados = {Ana, Juan}
Agregar(Juan)
invitados = {Ana, Juan}
```

## Filtro de spam

La blacklist puede ser un conjunto de palabras prohibidas.

```text
blacklist = {"crypto", "premio", "ganá"}
```

Para revisar un mail, recorro sus palabras y pregunto:

```java
if (blacklist.Pertenece(palabra)) {
    esSpam = true;
}
```

## Tags de un blog

Uso conjunto porque no quiero repetir tags y no me importa cuál fue cargado primero.

```text
{Programacion, Java, OOP}
```

Una pila sería mala elección porque una pila habla de orden de salida, no de pertenencia.

## Gestión de legajos

El legajo debería ser único. Antes de cargar un alumno, pregunto si ya está.

```text
si alumnos.Pertenece(legajo):
    no agrego
si no:
    alumnos.Agregar(legajo)
```

## Elegir vs Sacar

`Elegir()` devuelve un elemento del conjunto, pero no lo elimina.

`Sacar(x)` elimina `x` si está.

Si llamo `Elegir()` dos veces seguidas sin `Sacar()`, desde la teoría no tengo que asumir nada sobre el orden. En una implementación concreta puede devolver siempre el primer elemento interno, pero el TDA no promete eso.
