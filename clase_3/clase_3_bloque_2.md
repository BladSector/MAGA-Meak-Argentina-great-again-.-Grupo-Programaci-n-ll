# Bloque 2: Colas y colas con prioridad

Cola común: FIFO. El primero que llega es el primero que sale.

Cola con prioridad: sale primero el de mayor prioridad. Si dos tienen la misma prioridad, se suele respetar el orden de llegada dentro de esa prioridad.

## Fila del cajero

Es una cola común. No hay privilegios ni ranking: el cliente que llega primero se atiende primero.

```text
Acolar(cliente)
Desacolar() cuando pasa a la caja
```

## Impresora del laboratorio

También es una cola común. Si entran cinco archivos, salen en el orden en que fueron recibidos por la impresora.

```text
archivo1, archivo2, archivo3, archivo4, archivo5
```

Salida:

```text
archivo1, archivo2, archivo3, archivo4, archivo5
```

## Guardia del hospital, triage

Es cola con prioridad. No gana el que llegó primero, gana el caso más urgente.

Ejemplo:

```text
raspón -> prioridad 1
fractura -> prioridad 50
infarto -> prioridad 100
```

Si el raspón llegó antes que el infarto, igual se atiende primero el infarto.

## Promocionados vs regulares

Datos:

```text
regular llega 8:00 -> prioridad 5
promocionado llega 8:30 -> prioridad 10
```

Sale primero el promocionado, porque tiene mayor prioridad.

## Buffet de la facultad

Para que nadie se meta en la fila, uso una cola común.

```text
cuando llega una persona -> Acolar(persona)
cuando atienden -> Desacolar()
```

La operación que cuida el orden es `Desacolar()`, porque siempre saca al primero de la cola.

## Scheduler del sistema operativo

Conviene modelarlo como cola con prioridad.

```text
proceso del sistema -> prioridad 50
audio -> prioridad 45
video -> prioridad 40
Spotify -> prioridad 10
```

Si el sistema se sobrecarga, los procesos de baja prioridad esperan más. Los del sistema siguen saliendo antes porque no conviene bloquearlos.

## Embarque de aerolíneas

Modelo:

```text
movilidad reducida -> prioridad 3
business -> prioridad 2
general -> prioridad 1
```

Si llegan dos personas con la misma prioridad, se atienden por orden de llegada dentro de esa subcola.

## Tickets IT

Modelo:

```text
servidor principal caído -> prioridad 999
fondo de pantalla feo -> prioridad 0
```

El servidor caído sale primero aunque el otro ticket haya llegado antes.
