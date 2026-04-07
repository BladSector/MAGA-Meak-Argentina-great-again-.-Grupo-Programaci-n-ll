# Ejercicio 1: hospital

## Entidades

### Paciente
Es la entidad principal del sistema. Cada paciente tiene su propia pila de síntomas.

### Pila de síntomas
Guarda los síntomas del paciente en orden. Los más viejos quedan al fondo y el más reciente queda en el tope. Por eso, cuando se consulta la pila, lo primero que aparece es lo último que sintió el paciente.

### Cola con prioridad
Guarda a los pacientes en espera y los ordena según la prioridad con la que deben ser atendidos.

## Funcionamiento del sistema

Cuando llega un paciente al hospital, se lo debe encolar en la cola de prioridad.

Antes de encolarlo, primero hay que calcular su prioridad. Esa prioridad se obtiene a partir de sus síntomas, usando algo como `prioridad(paciente.getSintomas)`.

Una vez calculada, se revisa la cola actual. Si el nuevo paciente tiene una prioridad más alta que alguno de los pacientes que ya están esperando, se lo ubica delante de ese paciente. Pero también debe quedar detrás de cualquier otro que tenga una prioridad más alta que la suya.

Así, la cola queda ordenada según la urgencia de atención.

## Cálculo de la prioridad

La prioridad de un paciente se calcula a partir de su pila de síntomas.

Como la pila mantiene el orden de aparición, el síntoma más reciente queda en el tope y los más viejos quedan más abajo.

Para asignar la prioridad, se puede consultar una base de datos o una tabla donde figure cada síntoma y su nivel de gravedad.

A partir de eso, se recorre la pila y se obtiene una prioridad final. En tu planteo actual, esa prioridad sale del promedio de gravedad de los síntomas del paciente.
