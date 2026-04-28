# Ejercicios de clase 3 resueltos

Fuente: [Guia de trabajos practicos clase 3](../01_pdfs_convertidos/guia_de_trabajos_practicos_clase_3_1.md).

## Bloque 1, Pilas

### Historial de navegacion

Cada pagina visitada se apila. El boton atras desapila la pagina actual y deja como actual la anterior.

```text
Apilar("fi.uba.ar")
Apilar("campus.utn.edu.ar")
Apilar("stackoverflow.com")

Tope = "stackoverflow.com"
Atras: Desapilar()
Tope = "campus.utn.edu.ar"
```

### Editor de codigo, undo

Cada cambio guarda una version del archivo.

```text
Apilar(version0)
Apilar(version1)
Apilar(version2)
```

Para deshacer:

```text
Desapilar()
estadoActual = Tope()
```

Si tambien queres rehacer, necesitas otra pila para los estados que sacaste.

### Balanceo de parentesis

Para `( ( a + b ) * c )`:

```text
leo '(' -> Apilar('(')
leo '(' -> Apilar('(')
leo ')' -> comparo con Tope y Desapilar()
leo ')' -> comparo con Tope y Desapilar()
fin -> PilaVacia() debe ser true
```

Si aparece un cierre y la pila esta vacia, esta mal balanceado. Si al final quedan aperturas, tambien esta mal.

### Reversion de strings

```text
ALGORITMOS
Apilo A, L, G, O, R, I, T, M, O, S
Desapilo S, O, M, T, I, R, O, G, L, A
```

Resultado: `SOMTIROGLA`.

### Call stack

Si `Main()` llama a `CalcularPromedio()` y esa llama a `Sumar()`, mientras se ejecuta la suma el tope es `Sumar()`.

```text
base -> Main -> CalcularPromedio -> Sumar -> tope
```

### Directorios

Cada carpeta a la que entro se apila.

```text
Apilar("C:/")
Apilar("Usuarios")
Apilar("Documentos")
```

Si subo un nivel:

```text
Desapilar()
Tope = "Usuarios"
```

## Bloque 2, Colas y prioridad

Fila del cajero: cola comun. Atiende por orden de llegada.

Impresora: cola comun. Si llegan 5 archivos, salen en el mismo orden en que entraron.

Guardia de hospital: cola con prioridad. Ejemplo:

```text
Raspon: prioridad 1
Fractura: prioridad 50
Infarto: prioridad 100
```

Sale primero el de mayor prioridad, aunque haya llegado despues.

Promocionados vs regulares:

```text
Regular llega 8:00, prioridad 5
Promocionado llega 8:30, prioridad 10
Sale primero el promocionado
```

Buffet: cola comun. `Acolar` al llegar y `Desacolar` cuando se atiende. Nadie se adelanta si se respeta FIFO.

Scheduler de sistema operativo: cola con prioridad. Procesos del sistema pueden tener prioridad `50`, Spotify prioridad `10`. Si hay sobrecarga, los de menor prioridad esperan mas.

Embarque de aerolinea:

```text
Movilidad reducida: prioridad 3
Business: prioridad 2
General: prioridad 1
```

Si dos tienen misma prioridad, se atienden por orden de llegada dentro de esa prioridad.

Tickets IT:

```text
Servidor caido: prioridad 999
Fondo de pantalla feo: prioridad 0
```

## Bloque 3, Conjuntos

Padron electoral:

```text
Conjunto votantes.
Si votantes.Pertenece(legajo), no vota.
Si no pertenece, vota y Agregar(legajo).
```

Invitados:

```text
Si intento Agregar alguien que ya esta, no cambia el conjunto ni su tamaño.
```

Blacklist de spam:

```text
Por cada palabra del mail:
    si blacklist.Pertenece(palabra), marco spam
```

Tags:

```text
Uso conjunto porque no quiero tags repetidos y el orden no me importa.
```

Legajos:

```text
El legajo es clave unica. Antes de agregar, Pertenece(legajo).
```

Elegir vs Sacar:

```text
Elegir mira o devuelve un elemento arbitrario. Sacar elimina un elemento. Si llamo Elegir dos veces sin Sacar, teoricamente no tengo garantia de que sea el mismo, aunque una implementacion concreta podria devolver siempre el primero.
```

## Bloque 4, Diccionarios

Agenda:

```text
TDA simple
Clave: nombre
Valor: telefono
```

Sinonimos:

```text
TDA multiple
Clave: palabra
Valor: conjunto de sinonimos
```

Puntajes de torneo:

```text
TDA simple
Clave: usuario
Valor: puntaje maximo
```

Traductor:

```text
TDA multiple
Clave: palabra
Valor: conjunto de traducciones
Ejemplo: "bank" -> {"banco", "orilla"}
```

Indice de libro:

```text
TDA multiple
Clave: palabra
Valor: conjunto de paginas
```

Inscripcion por alumno:

```text
TDA multiple
Clave: legajo
Valor: conjunto de materias
```

DNS:

```text
TDA simple en el modelo basico de la guia
Clave: dominio
Valor: direccion IP
```

Orden de soporte:

```text
TDA simple
Clave: ID de orden
Valor: script o solucion asociada
```

## Bloque 5, modelos combinados

Hospital:

```text
Cola con prioridad para pacientes.
Cada paciente puede tener una pila de sintomas.
El sintoma mas reciente queda en el tope.
La prioridad se calcula por gravedad.
```

Tags de facultad:

```text
Diccionario multiple o diccionario simple con conjunto como valor.
Clave: carrera
Valor: conjunto de materias obligatorias
```

Estrategia de pila mas ineficiente:

```text
Estrategia 2, porque mantiene el tope en indice 0 y cada Apilar mueve todos los elementos a la derecha. Costo O(n).
```

Sistema de inscripciones UADE:

```text
Legajos unicos: Conjunto. Validar con Pertenece.
Lista de espera con prioridad: Cola con prioridad. Prioridad mas alta para alumnos del Departamento de Tecnologia.
Correlatividades: Diccionario multiple. Clave: materia. Valor: conjunto de correlativas.
```
