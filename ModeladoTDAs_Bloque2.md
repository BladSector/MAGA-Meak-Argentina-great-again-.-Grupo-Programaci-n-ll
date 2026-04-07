Bloque 2: Colas y Colas con Prioridad (FIFO + Ranking) 



**Fila del Cajero: Los clientes llegan al banco de la esquina de la facultad** 



\- Consigna: ¿Es la Cola común o de Prioridad? Justifica según la lógica de atención. 

&#x09;Es una cola común (FIFO) ya que los clientes que van llegando se ordenan en orden de llegada desde la esquina de la facultad. No es prioritario porque no hay una condición sobre 	privilegio de adelanto a la cola. 



**Impresora del Laboratorio: Todos mandan el TP al mismo tiempo para que no cierre la entrega.** 



\- Consigna: Si la impresora recibe 5 archivos, ¿Cuál es el orden de salida? 

&#x09;Usa cola FIFO porque la maquina al recibir los TP le da un orden de llegada, aunque sea de milisegundos. 



**Guardia del Hospital de Clínicas (Triage): Llega un pibe con un rapón (prioridad 1) y un jubilado con un bobazo (prioridad 100).** 



\- Consigna: Definí los valores de prioridad para 3 casos distintos de tu elección. 

&#x09;Para poner ejemplos de prioridad se puede mencionar el 	engripado (Prioridad 20), esguince (Prioridad 30) y fractura 	(Prioridad 50). 



**Examen Final (Promocionados vs Regulares): En la cartelera se anotan todos. Pero los que promocionaron (Prioridad 10) pasan antes que los que rinden final (Prioridad 5).** 



\- Consigna: Si un regular llegó a las 8 AM y un promocionado a las 8:30 AM ¿Quién sale primero al hacer desacolar? 

&#x09;Acá se usa cola por prioridad, no importa el tiempo de 	llegada. Al desacolar lo hace primero el de mayor prioridad, 	en este caso el promocionado de las 8:30 AM 



**Buffet de la Facultas: Fila para el sanguchito de milanesa.** 



\- Consigna: ¿Qué operación de TDA Cola usas para asegurar que no se cuelen ningún “vibe coder”? 

&#x09;Usaría una cola con FIFO, el primero que entra es el primero 	en salir, no hay posibilidades de colarse. Al descolar siempre 	va a ser el primero que entro. 



**Procesador de Tareas (OS Scheduler): El sistema operativo maneja procesos del sistema (Prioridad 50) y procesos del usuario como el Spotify (Prioridad 10).** 



\- Consigna: Asignar prioridades y explicar qué pasa si el sistema se sobrecarga. 

&#x09;Algunas prioridades puede ser el proceso de sonido (Prioridad 	45) y proceso de imagen (Prioridad 48). En una situación de 	sobrecarga, el sistema no deja de ejecutar los procesos 	más importantes, sino que comienza a postergar los de menor 	prioridad. Primero se ven afectados los procesos del usuario, 	que pueden quedar en espera durante más tiempo. Si la 	sobrecarga continúa, también se reduce la ejecución del sonido 	y, en última instancia, del video. 



**Embarque de Aerolíneas: Primero suben pasajeros con movilidad reducida (prioridad 3), luego business (prioridad 2) y al final los mortales (prioridad 1).** 



\- Consigna: Identificar el comportamiento si llegan dos personas con la misma prioridad. 

&#x09;Al llegar al mismo tiempo dos personas con la misma prioridad 	pasa a funcionar como una cola común (FIFO), el que llega 	primero es el que sube. 



**Distribución de Tickets IT: Se rompió el servidor principal (prioridad infinita) vs “No me gusta el fondo de pantalla” (prioridad 0)** 



\- Consigna: Definí explícitamente el valor de prioridad para cada caso. 

&#x09;Lo principal es el funcionamiento continuo o reparación del 	servidor principal ante cualquier complicación que surge, por 	ningún motivo se debe realizar o procesar otra tarea si 	aparece el servidor principal (prioridad “infinito y más 	allá”). Cambiar el fondo de pantalla del escritorio es la 	menor prioridad de todas (prioridad “cuando no tengas nada que 	hacer”), recién se puede prestar atención a ese proceso cuando 	ningún otro proceso este a la espera, tienen que estar 	resueltos todo lo demás para poder poner fachera el fondo de 	pantalla. 



&#x20;

