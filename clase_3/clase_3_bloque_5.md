# Clase 3 - Bloque 5

## 1. Hospital

### Entidades

#### Paciente
Es la entidad principal del sistema. Cada paciente tiene su propia pila de síntomas.

#### Pila de síntomas
Guarda los síntomas del paciente en orden. Los más viejos quedan al fondo y el más reciente queda en el tope. Por eso, cuando se consulta la pila, lo primero que aparece es lo último que sintió el paciente.

#### Cola con prioridad
Guarda a los pacientes en espera y los ordena según la prioridad con la que deben ser atendidos.

### Funcionamiento del sistema

Cuando llega un paciente al hospital, se lo debe encolar en la cola de prioridad.

Antes de encolarlo, primero hay que calcular su prioridad. Esa prioridad se obtiene a partir de sus síntomas, usando algo como `prioridad(paciente.getSintomas)`.

Una vez calculada, se revisa la cola actual. Si el nuevo paciente tiene una prioridad más alta que alguno de los pacientes que ya están esperando, se lo ubica delante de ese paciente. Pero también debe quedar detrás de cualquier otro que tenga una prioridad más alta que la suya.

Así, la cola queda ordenada según la urgencia de atención.

### Cálculo de la prioridad

La prioridad de un paciente se calcula a partir de su pila de síntomas.

Como la pila mantiene el orden de aparición, el síntoma más reciente queda en el tope y los más viejos quedan más abajo.

Para asignar la prioridad, se puede consultar una base de datos o una tabla donde figure cada síntoma y su nivel de gravedad.

A partir de eso, se recorre la pila y se obtiene una prioridad final. En este planteo, esa prioridad sale del promedio de gravedad de los síntomas del paciente.

---

## 2. Sistema de tags de facultad

Este sistema se puede modelar con un diccionario. La clave es el nombre de una carrera y el valor asociado es un conjunto de materias obligatorias.

Por ejemplo, una clave puede ser `Licenciatura en Bioinformática` y su valor será el conjunto de materias obligatorias de esa carrera.

El valor no conviene que sea una lista, sino un conjunto. La razón es simple: una misma materia no debería aparecer repetida, y además el orden no importa. Lo que interesa es saber si una materia pertenece o no a la carrera.

Cuando se registra una carrera en el sistema, se la guarda como clave del diccionario. Después se le asocia su conjunto de materias obligatorias. Con esa estructura se puede agregar una carrera, cargar sus materias, consultar cuáles son y verificar si una materia determinada pertenece a ese conjunto.

La relación principal del modelo es esa: a cada carrera le corresponde un conjunto de materias obligatorias.

---

## 3. Análisis de implementación de pilas

Hay tres formas de implementar una pila con arreglos.

### Estrategia 1
Se usa un arreglo junto con una variable contador. Ese contador señala la primera posición libre del arreglo.

Entonces, al apilar, el nuevo elemento se guarda en esa posición y el contador avanza. El tope queda justo antes de la primera posición libre.

### Estrategia 2
También se usa un arreglo, pero en este caso el tope de la pila siempre queda en la posición `0`.

Eso obliga a mover todos los elementos una posición hacia la derecha cada vez que se apila uno nuevo. Recién después de ese desplazamiento se puede guardar el nuevo elemento en el índice `0`.

### Estrategia 3
En esta estrategia, la posición `0` del arreglo no guarda un dato de la pila sino la cantidad de elementos que hay cargados.

Los datos reales empiezan después. Esa cantidad se usa como referencia para saber dónde está el tope y dónde debe guardarse el siguiente elemento.

Las tres estrategias representan la misma pila, pero cambian la forma de organizar el arreglo y el costo de las operaciones.

---

## 4. Pregunta de parcial

### ¿Cuál de las estrategias es la más ineficiente para apilar y por qué?

La estrategia que termina siendo más pesada al momento de apilar es la Estrategia 2.

El motivo es que esa implementación mantiene el tope siempre en la posición `0`. Entonces, cuando entra un elemento nuevo, no se lo puede guardar directamente: antes hay que correr todos los elementos que ya estaban cargados una posición hacia la derecha.

Si la pila tiene muchos elementos, ese corrimiento hay que hacerlo completo en cada inserción. Por eso apilar en esta estrategia tiene costo **O(n)**.

En cambio, en la Estrategia 1 el elemento se agrega en la próxima posición libre del arreglo usando el contador, sin mover lo anterior. Por eso ahí el costo de apilar es **O(1)**.
