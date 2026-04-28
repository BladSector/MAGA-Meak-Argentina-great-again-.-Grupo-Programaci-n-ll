# Clase 3, bloque 5

## 1. Hospital

Modelo:

```text
Paciente:
    legajo o id
    pila de síntomas
    prioridad calculada

Guardia:
    cola con prioridad de pacientes
```

La pila de síntomas guarda primero el síntoma más reciente en el tope.

```text
base -> fiebre -> tos -> dolor_pecho -> tope
```

La cola con prioridad decide a quién se atiende antes. Si un paciente llega con prioridad más alta, queda antes que los de menor prioridad. Si tiene la misma prioridad que otro, se respeta el orden de llegada si la implementación mantiene FIFO en empates.

Pseudocódigo:

```text
cuando llega un paciente:
    prioridad = calcularPrioridad(paciente.sintomas)
    cola.AcolarPrioridad(paciente, prioridad)

cuando atiendo:
    paciente = cola.Primero()
    cola.Desacolar()
```

## 2. Sistema de tags de facultad

Uso un diccionario donde:

```text
clave: carrera
valor: conjunto de materias obligatorias
```

Ejemplo:

```text
"Licenciatura en Bioinformática" -> {Algoritmos, Matemática, Biología}
```

El valor tiene que ser conjunto porque una materia no debería repetirse y el orden no importa. Lo que interesa es poder preguntar si una materia pertenece a la carrera.

## 3. Implementación de pilas con arreglos

### Estrategia 1

Arreglo más variable `cantidad`.

```text
cantidad apunta a la primera posición libre
tope está en datos[cantidad - 1]
```

Apilar es directo:

```text
datos[cantidad] = x
cantidad++
```

Costo: `O(1)`.

### Estrategia 2

El tope siempre queda en `datos[0]`.

Para apilar hay que correr todo a la derecha y recién ahí poner el nuevo valor en `0`.

```text
antes: [7, 5, 3]
apilo 9
desplazo: [7, 7, 5, 3]
pongo 9: [9, 7, 5, 3]
```

Costo: `O(n)`. Esta es la cara.

### Estrategia 3

`datos[0]` guarda la cantidad. Los datos reales empiezan en `datos[1]`.

```text
datos[0] = 3
datos[1] = 5
datos[2] = 8
datos[3] = 2
```

El tope está en:

```text
datos[datos[0]]
```

Costo de apilar: `O(1)`.

## 4. Pregunta típica de parcial

La estrategia más ineficiente para `Apilar` es la estrategia 2.

Motivo: mantiene el tope en el índice `0`, entonces cada nuevo elemento obliga a desplazar todos los elementos cargados una posición a la derecha. Si hay `n` elementos, mueve `n` elementos. Por eso cuesta `O(n)`.

En las estrategias 1 y 3 se agrega directo en la próxima posición libre. Ahí el costo es `O(1)`.
