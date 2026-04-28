# Bloque 6: sistema de inscripciones

Consigna: modelar inscripciones con legajos únicos, cupos, lista de espera con prioridad y correlatividades.

## TDAs que usaría

```text
Legajos únicos:
    Conjunto de legajos
    operación clave: Pertenece(legajo)

Lista de espera:
    Cola con prioridad
    prioridad alta para alumnos del Departamento de Tecnología

Correlatividades:
    Diccionario múltiple
    clave: materia
    valor: conjunto de materias correlativas
```

## Modelo mínimo

```text
Alumno:
    legajo
    carrera
    trabajaEnDeptoTecnologia
    materiasAprobadas: conjunto

Materia:
    codigo
    cupoMaximo
    inscriptos: conjunto de legajos
    espera: cola con prioridad
```

Las correlatividades pueden ir en un diccionario aparte:

```text
correlativas:
    clave = codigo de materia
    valor = conjunto de codigos de materias previas
```

Ejemplo:

```text
Programacion2 -> {Programacion1, Algoritmos}
BaseDatos2 -> {BaseDatos1}
```

## Pseudocódigo de inscripción

```text
inscribirAlumno(alumno, materia):
    si materia.inscriptos.Pertenece(alumno.legajo):
        cortar, ya está inscripto

    si no cumple correlativas:
        cortar, no puede inscribirse

    si hay cupo:
        materia.inscriptos.Agregar(alumno.legajo)
    si no:
        prioridad = calcularPrioridad(alumno)
        materia.espera.AcolarPrioridad(alumno.legajo, prioridad)
```

## Cómo calcular prioridad

Si el criterio es que los alumnos del Departamento de Tecnología pasen antes:

```text
si alumno.trabajaEnDeptoTecnologia:
    prioridad = 10
si no:
    prioridad = 1
```

Si dos alumnos tienen la misma prioridad, la cola debería respetar orden de llegada dentro de esa prioridad.

## Verificar correlativas

Idea:

```text
requisitos = correlativas.Recuperar(materia.codigo)

mientras requisitos no esté vacío:
    correlativa = requisitos.Elegir()
    si alumno.materiasAprobadas.Pertenece(correlativa) == false:
        no cumple
    requisitos.Sacar(correlativa)

si pasó todo:
    cumple
```

## Cuando se libera un cupo

Si alguien se baja de la materia:

```text
materia.inscriptos.Sacar(legajo)

si materia.espera no está vacía:
    siguiente = materia.espera.Primero()
    materia.espera.Desacolar()
    materia.inscriptos.Agregar(siguiente)
```

## Respuesta corta de parcial

```text
Requerimiento 1: Conjunto, porque evita legajos duplicados con Pertenece.
Requerimientos 2 y 3: Cola con prioridad, porque hay lista de espera y algunos alumnos pasan antes.
Requerimiento 4: Diccionario múltiple, con materia como clave y conjunto de correlativas como valor.
```
