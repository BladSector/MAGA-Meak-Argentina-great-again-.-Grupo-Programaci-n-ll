## Bloque 1: Pilas, LIFO

Una pila devuelve primero lo último que entró. Esa es la regla. Si en el parcial te olvidás de eso, se cae todo lo demás.

### 1. Historial de navegación

Cada página visitada se apila. El `Tope()` representa la página actual.

```java
pila.InicializarPila();

pila.Apilar("fi.uba.ar");
pila.Apilar("campus.utn.edu.ar");
pila.Apilar("stackoverflow.com");

System.out.println(pila.Tope()); // stackoverflow.com
```

Cuando el usuario toca "Atrás", se saca la página actual. Después el nuevo `Tope()` es la página anterior.

```java
pila.Desapilar();
System.out.println(pila.Tope()); // campus.utn.edu.ar
```

Pseudocódigo:

```text
entrar a una página -> Apilar(página)
volver atrás -> Desapilar()
página actual -> Tope()
```

### 2. Editor de código, undo

Para `Ctrl+Z`, conviene guardar estados del archivo. Cada cambio importante se apila.

```text
Apilar(estado_inicial)
Apilar(estado_con_linea_1)
Apilar(estado_con_linea_2)
```

Para deshacer, saco el estado actual y vuelvo al anterior.

```java
if (!historial.PilaVacia()) {
    historial.Desapilar();
}

if (!historial.PilaVacia()) {
    estadoActual = historial.Tope();
}
```

Si también quiero rehacer, necesito otra pila para guardar lo que fui desapilando.

### 3. Balanceo de paréntesis

Acá no se apila `a+b`. Se apilan símbolos de apertura: `(`, `{`, `[`.

Regla:

```text
si leo apertura -> Apilar(apertura)
si leo cierre -> el Tope debe ser la apertura correspondiente, luego Desapilar()
al final -> la pila debe quedar vacía
```

Ejemplo con `((a+b)*c)`:

```text
leo '(' -> Apilar('(')
leo '(' -> Apilar('(')
leo ')' -> Tope() es '(' -> Desapilar()
leo ')' -> Tope() es '(' -> Desapilar()
fin -> PilaVacia() == true
```

Si aparece un cierre y la pila está vacía, está mal. Si al final queda algo en la pila, también está mal.

### 4. Reversión de strings

Para invertir una palabra, apilo letra por letra y después desapilo.

```java
String palabra = "ALGORITMOS";

for (int i = 0; i < palabra.length(); i++) {
    pila.Apilar(String.valueOf(palabra.charAt(i)));
}

while (!pila.PilaVacia()) {
    System.out.print(pila.Tope());
    pila.Desapilar();
}
```

Salida:

```text
SOMTIROGLA
```

### 5. Pila de llamadas, call stack

Si `Main()` llama a `CalcularPromedio()` y esa función llama a `Sumar()`, mientras se ejecuta `Sumar()` el tope conceptual de la pila es `Sumar()`.

```text
base -> Main -> CalcularPromedio -> Sumar -> tope
```

Cuando `Sumar()` termina, se desapila y vuelve el control a `CalcularPromedio()`.

### 6. Navegación de directorios

Cada carpeta visitada se apila.

```java
pila.Apilar("C:/");
pila.Apilar("Usuarios");
pila.Apilar("Documentos");
```

Estado:

```text
base -> C:/ -> Usuarios -> Documentos -> tope
```

Si el usuario sube un nivel:

```java
pila.Desapilar();
System.out.println(pila.Tope()); // Usuarios
```

La pila sirve porque la carpeta anterior siempre queda justo debajo de la actual.
