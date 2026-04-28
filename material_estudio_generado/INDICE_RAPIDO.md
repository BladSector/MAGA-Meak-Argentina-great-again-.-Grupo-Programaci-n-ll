# Indice rapido para estudiar con carpeta abierta

Nota Brutal: si tenes una hora, no leas todo de punta a punta. Usa este orden.

## 1. Primero

Lee [00_machete_1_hora.md](02_resumenes/00_machete_1_hora.md). Ahi esta lo que mas suele sumar puntos: operaciones de cada TDA, trampas y patrones.

## 2. Si aparece teoria

- [01_tdas_abstraccion.md](02_resumenes/01_tdas_abstraccion.md): TDA, interfaz, contrato, caja negra.
- [07_estatico_vs_dinamico.md](02_resumenes/07_estatico_vs_dinamico.md): arreglos vs nodos, costos, estrategias de pila.
- [08_mapa_codigo_profe.md](02_resumenes/08_mapa_codigo_profe.md): donde esta cada implementacion en el repo.

## 3. Si aparece una estructura concreta

- [02_pilas.md](02_resumenes/02_pilas.md): LIFO, pila estatica, dinamica, balanceo, undo, call stack.
- [03_colas.md](02_resumenes/03_colas.md): FIFO, cola estatica, dinamica, filtrado manteniendo orden.
- [04_colas_prioridad.md](02_resumenes/04_colas_prioridad.md): prioridad, desempates, combinar dos colas sin destruirlas.
- [05_conjuntos.md](02_resumenes/05_conjuntos.md): sin duplicados, Elegir, Sacar, Pertenece.
- [06_diccionarios.md](02_resumenes/06_diccionarios.md): simple, multiple, frecuencias, invertir.

## 4. Si aparece codigo o ejercicio

- [01_patrones_de_resolucion.md](03_ejercicios_y_codigo/01_patrones_de_resolucion.md): recetas copiables.
- [02_parcial_1_resuelto.md](03_ejercicios_y_codigo/02_parcial_1_resuelto.md): parcial completo, con respuestas y codigo.
- [03_ejercicios_clase_3_resueltos.md](03_ejercicios_y_codigo/03_ejercicios_clase_3_resueltos.md): ejercicios de modelado de clase 3.

## 5. PDFs convertidos a Markdown

- [Clase 2](01_pdfs_convertidos/clase_2.md)
- [Guia de Actividades Practicas](01_pdfs_convertidos/guia_de_actividades_practicas.md)
- [Guia de Trabajos Practicos clase 3](01_pdfs_convertidos/guia_de_trabajos_practicos_clase_3_1.md)
- [Examen Parcial 1](01_pdfs_convertidos/examenparcial1_progii_1.md)

## Alertas que no podes olvidar

- No llames `Tope`, `Primero` o `Elegir` si la estructura esta vacia. En Java real puede romper con error.
- Si el enunciado dice "usar solo operaciones del TDA", no toques `datos[]`, nodos, `cab`, `col`, `frente`, etc.
- En conjuntos el orden no importa. En una implementacion estatica, `Sacar` suele reemplazar el elemento borrado por el ultimo.
- La convencion de prioridad cambia segun el material. El parcial dice `P=0` mayor prioridad. El codigo del profe usa numero mas alto como mayor prioridad.
- El parcial usa `Recuperar` en diccionario simple. En el codigo del profe, una interfaz de diccionario simple esta incompleta y no lo declara. Para el parcial, segui el enunciado del parcial.
- Si recorres una pila o cola y debe quedar intacta, necesitas auxiliar y restaurar.
