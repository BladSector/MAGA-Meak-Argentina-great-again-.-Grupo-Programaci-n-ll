# Mapa del codigo del profe

Este archivo existe para ubicar rapido implementaciones reales. Si el parcial pide "como se hace con cola dinamica", mira aca primero.

## Pilas

Pilas estaticas:

```text
Codigo fuente profe/Pilas_estaticas/PIlas/src/Interfaces/PilaTDA.java
Codigo fuente profe/Pilas_estaticas/PIlas/src/Implementacion/Estrategia_1.java
Codigo fuente profe/Pilas_estaticas/PIlas/src/Implementacion/Estrategia_2.java
Codigo fuente profe/Pilas_estaticas/PIlas/src/Implementacion/Estrategia_3.java
```

Resumen:

```text
Estrategia 1: arreglo + cantidad. Tope en cantidad - 1.
Estrategia 2: tope en indice 0. Apilar desplaza todo a la derecha. Es la cara.
Estrategia 3: datos[0] guarda cantidad. Tope en datos[datos[0]].
```

Pila dinamica:

```text
Codigo fuente profe/Pila_Dinamica/Pila_Dinamica/src/Implementacion/PilaDinamica.java
Codigo fuente profe/Pila_Dinamica/Pila_Dinamica/src/Implementacion/Node.java
```

Resumen:

```text
tope apunta al primer nodo logico.
Apilar crea nodo nuevo que apunta al tope anterior.
Desapilar avanza tope al siguiente.
```

## Colas

Cola estatica:

```text
Codigo fuente profe/Cola_Estatica/Cola_Estatica/src/Implementacion/ColaEstatica.java
```

Resumen:

```text
Acolar guarda al final.
Desacolar desplaza todos los elementos a la izquierda.
Primero devuelve datos[0].
```

Cola dinamica:

```text
Codigo fuente profe/Cola_Dinamica/Cola_Dinamica/src/Implementacion/ColaDinamica.java
Codigo fuente profe/Cola_Dinamica/Cola_Dinamica/src/Implementacion/Node.java
```

Resumen:

```text
frente apunta al primero.
fondo apunta al ultimo.
Acolar enlaza atras.
Desacolar avanza frente y, si queda vacia, pone fondo en null.
```

## Colas con prioridad

Estatica:

```text
Codigo fuente profe/Cola_Prioridad_Estatica/Cola_Prioridad_Estatica/src/Implementacion/ColaPrioridadEstatica.java
```

Dinamica:

```text
Codigo fuente profe/Cola_Prioridad_Dinamica/Cola_Prioridad_Dinamica/src/Implementacion/ColaPrioridadDinamica.java
```

Resumen:

```text
El codigo del profe usa mayor numero = mayor prioridad.
Si dos prioridades son iguales, el nuevo queda atras de los anteriores.
```

## Conjuntos

Estatico:

```text
Codigo fuente profe/Conjunto_Estatico/Conjunto_Estatico/src/Implementacion/ConjuntoEstatico.java
```

Dinamico:

```text
Codigo fuente profe/Conjunto_Dinamico/Conjunto_Dinamico/src/Implementacion/ConjuntoDinamico.java
```

Resumen:

```text
Agregar solo si no pertenece.
Sacar en estatico reemplaza por el ultimo.
Elegir devuelve un elemento de la estructura, no promete orden.
```

## Diccionarios

Simple estatico:

```text
Codigo fuente profe/Diccionario_Simple_Estatico/Diccionario_Simple/src/Implementacion/DiccionarioSimpleEstatico.java
Codigo fuente profe/Diccionario_Simple_Estatico/Diccionario_Simple/src/Interface/DiccionarioSimpleTDA.java
```

Simple dinamico:

```text
Codigo fuente profe/Diccionario_Simple_Dinamico/Diccionario_Simple_Dinamico/src/Implementacion/DiccionarioSimpleDinamico.java
```

Ojo:

```text
La interfaz de diccionario simple del profe declara InicializarDiccionario, Agregar, Eliminar y Claves.
El parcial usa tambien Recuperar. Para responder el parcial, manda el enunciado del parcial.
```

Multiple estatico:

```text
Codigo fuente profe/Diccionario_Multiple_Estatico/Diccionario_Multiple_Estatico/src/Implementacion/DiccionarioMultipleEstatico.java
```

Multiple dinamico:

```text
Codigo fuente profe/Diccionario_Multiple_Dinamico/Diccionario_Multiple_Dinamico/src/Implementacion/DiccionarioMultipleDinamico.java
```

Resumen:

```text
Diccionario simple: clave -> un valor. Agregar con clave existente reemplaza.
Diccionario multiple: clave -> varios valores. Agregar con valor existente no duplica.
EliminarValor puede eliminar la clave si se queda sin valores.
```

## Ejercicios ya cargados en el repo

```text
clase_3/clase_3_bloque_1_ejercicios/src/Pila/EjerciciosPila
Ejercicio_Clase05/src
parcial_1/parcial_1.md
```

`parcial_1/parcial_1.md` tiene una resolucion previa. La resolucion generada en `material_estudio_generado/03_ejercicios_y_codigo/02_parcial_1_resuelto.md` corrige y aclara la trampa de `Primero()` sobre cola vacia.
