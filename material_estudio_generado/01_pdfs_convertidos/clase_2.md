# Clase 2

Origen: `archivos_del_teams/Clase_2.pdf`

> Conversión automática a Markdown. Las páginas marcadas como `ocr` vienen de reconocimiento de texto sobre imagen.

## Página 1 (ocr)

> Clase_2:
Tipos_de_Datos_Abstractos.exe
Dejando el código espagueti atrás (o al menos intentándolo).
// Buenas, gente. Bienvenidos a la Clase 2.
// Hoy nos ponemos serios con el diseño de software.
// Preparen el mate que se viene la abstracción._

## Página 2 (ocr)

Hoy vamos a abstraer
la implementación de
los datos.
Para hacer el código
más fácil, ¿no?
¿Para hacerlo más
fácil, NO?!
AGENDA DEL DÍA:
- ¿Qué onda con los TDAs?
- Niveles de abstracción.
- La interfaz como contrato.
- Pilas y Colas (LIFO VS.
FIFO) .
- El resto de la banda
(Conjuntos, Diccionarios).
- Implementación estática
(arreglos) .

## Página 3 (ocr)

¿Qué es un TDA, posta?
Datos
TDA
(Tipo de Dato Abstracto)
Resultados
Caja Negra (No tocar)
La Semántica (El Comportamiento)
Qué hace la estructura desde el punto
de vista del usuario. Ej: "Quiero guardar
este número y sacarlo después."
La Implementación (El Cómo)
Los detalles técnicos ocultos.
Ej: "¿Lo guardo en un array? ¿Uso
punteros? Problema mío, no tuyo."
Separamos la especificación de la implementación. Abstraemos para no volvernos locos.

## Página 4 (ocr)

Niveles de Abstracción: Auto vs. Mecánico
Nivel Alto (El Usuario)
Solo necesitas saber manejar. El volante gira, el
acelerador avanza, Los detalles del motor están
intencionalmente ocultos.
Nivel Bajo (El Creador)
El ingeniero o mecánico necesita conocer la inyección
de combustible, los pistones y la transmisión.
La programación avanzada exige que aprendas a pensar como el mecánico, mientras le construyes el auto al usuario.

## Página 5 (ocr)

La Perspectiva lo es Todo: Mascota vs. Veterinario
Riñón
Estómago
Intestino
Corazón
Pulmón
Vejiga
Hígado
Abstracción de
Usuario:
Comportamiento
esperado.
Ronronea, come,
duerme.
Abstracción de
Implementación:
Estructura interna.
Organos, huesos,
sistemas biológicos.
Un Tipo de Dato Abstracto (TDA) nos permite interactuar con el "gato" sin tener que
operar sus "órganos" manualmente cada vez que queremos que maúlle.

## Página 6 (ocr)

La Interfaz: El Contrato Sagrado
Implementación 1
Interfaz
Usuario
del TDA
Implementación 2
El Contrato
La interfaz es una clase abstracta con
los métodos que el TDA ofrece. Si
prometiste un método apilar(), lo
tenés que cumplir.
Intercambiabilidad
Si respetas la interfaz, podés cambiar
TODA la implementación interna (de
estática a dinámica, por ejemplo) y el
usuario ni se entera.
La Analogía
Es como el enchufe de la pared. A vos
no te importa si la electricidad viene
de una represa o de un panel solar;
vos enchufás la compu y carga.

## Página 7 (ocr)

El costo de no usar TDAs (Atarlo con alambre)
IT WORKS
ON MY MACHINE
› ERROR: Dependencia fuertemente acoplada detectada.
- Si tu código depende de CÓMO está programado el TDA por dentro (ej: accedés
directo al índice del arreglo en vez de usar el método), el día que cambiemos la
implementación... explota todo.
- "En mi compu anda joya, en producción es un desastre." Respeten el contrato, che.

## Página 8 (ocr)

Las Estrellas del Show: Pilas vs. Colas
PILAS (Stacks)
COLAS (Queues)
SUBE
SUBE
- Concepto: LIFO (Last In, First Out). El último que
entra es el primero que sale.
- Analogía visual: Una pila gigante de platos sucios
en la bacha. No podés sacar el de abajo sin romper
todo.
- Uso típico: Deshacer (Ctrl+Z), historial del navegador.
- Concepto: FIFO (First In, First Out). El primero que
entra es el primero que sale.
- Analogía visual: La fila para cargar la SUBE a fin de
mes. El que llega primero, se atiende primero.
Respetá el orden, fiera.
- Uso típico: Cola de impresión, servidores web.

## Página 9 (ocr)

Colas con Prioridad: El VIP de los Datos
[ LIFO : Last In, First Out ]
Funciona como una cola normal, pero cada
elemento trae un 'Pase VIP' (prioridad).
La Regla de Marge: Un elemento con
prioridad alta siempre se adelanta a uno
de baja, sin importar cuándo llegó.
¿Y los empates?: El implementador decide
las reglas de desempate.
Interfaz (Operaciones)
AcolarPrioridad(dato, prioridad)
Prioridad()
Burbujeo de Prioridad
Developer Tools

## Página 10 (ocr)

Conjuntos (Sets): Colección Estricta
Una caja mágica sin orden posicional. La
única regla: NO SE ADMITEN DUPLICADOS.
Uso real: Ideal para verificar membresías
rápidamente. ¿Este usuario ya existe en el
sistema?
Agregar (dato): Entra si no es un clon.
Sacar (dato): Elimina el elemento.
Pertenece (dato) -> booleano: La pregunta del millón.
Elegir(): Saca un elemento arbitrario.
Developer Tools

## Página 11 (ocr)

Diccionarios: El Contacto Secreto
No buscas el dato secuencialmente.
Tienes una Clave (el contacto), y esa
clave te entrega directamente el Valor (la
mercancía).
• Diccionario Simple: Una clave mapea
a un único valor (ej. DNI - Persona).
• Diccionario Múltiple: Una clave
mapea a un grupo de valores.
Clave
(Key)
Valor
(Value)
Agregar (clave, valor)
Recuperar (clave)
Eliminar (clave)
Developer Tools

## Página 12 (ocr)

Desapilar()
Radiografía de una Pila
Apilar(dato)
9
3
Tope()
•
1
2
4
5
6
7
8
// Operaciones fundamentales de una Pila
InicializarPila();
Apilar (dato); // Push: Agregar un plato
Desapilar(); // Pop: Sacar el plato de arriba
Tope( );
PilaVacia();
// Mirar el de arriba sin sacarlo
// ¿Quedan platos?

## Página 13 (ocr)

Primero()
3
5
Desacolar()
Radiografía de una Cola
Acolar(dato)
2
9
1
// Operaciones fundamentales de una Cola
2
InicializarCola();
3
4
5
Acolar (dato); // Enqueue (a la fila)
Desacolar(); // Dequeue (el siguiente, por favor)
6
7
8
Primero();
ColaVacia();
// ¿A quién le toca?
// ¿Se fueron todos?

## Página 14 (ocr)

Spoiler Alert: Estático vs. Dinámico
Conozco a
un chabón...
que conoce a
un chabon...
→
Senior_Dev_Mati
13:19
Hoy (Estático): Vamos a guardar nuestros TDAs en Arreglos (Arrays). Tamaño fijo,
memoria contigua. Seguro pero rígido.
Más adelante (Dinámico): Listas enlazadas. Literalmente este meme. Un nodo que
no sabe nada de la estructura total, pero tiene un puntero al siguiente chabón.
(Paciencia, ya vamos a llegar a los punteros y a llorar juntos).

## Página 15 (ocr)

El Resto de la Banda (Otros TDAs)
Colas con Prioridad
Conjuntos (Sets)
Igual que una cola, pero los elementos tienen
prioridad. El VIP de prioridad alta se cuela y
pasa primero. Si tienen misma prioridad,
decide el patovica (el implementador).
AcolarPrioridad(dato, prioridad);
Prioridad();
Una bolsa de elementos SIN DUPLICADOS y
SIN ORDEN. No importa quién entró primero.
Agregar(); Sacar();
Pertenece(); Elegir(); // Saca uno arbitrario

## Página 16 (ocr)

Diccionarios: Clave y Valor
Diccionario Simple
Diccionario Multiple
Clave
Valor
- Concepto: Una clave, UN único valor asociado.
- Visual: Buscás una palabra (Clave) -> Obtenés
una definición (Valor).
- Métodos: Agregar(clave, valor), Eliminar(clave),
Recuperar (clave).
Agregar (clave, valor), Eliminar (clave);
Recuperar (clave);
Juan (Clave)
(Conjunto de Valores)
Casa: 555-0100
Celular: 555-0101
Trabajo: 555-0102
- Concepto: Una clave, MUCHOS valores.
- Visual: Buscás "Juan" (Clave) -> Obtenés el
número de casa, el celular y el del trabajo.
- Métodos extra: EliminarValor(clave, valor
específico).
EliminarValor(clave, valor específico)

## Página 17 (ocr)

> STATUS: Recreo mental finalizado. Preparando inmersión a bajo nivel...
Divide y vencerás.

## Página 18 (ocr)

Implementación Estática en Arreglos: Las 3 Estrategias
Estrategia 1
1
2
3
3
5
4
7
5
6
7
8
9
Alineación: Izquierda.
Puntero: Una variable int separada que apunta
a la primera posición libre. Para agregar,
ponés el dato y sumás 1 a la variable.
Estrategia 2
1
7
2
5
3
3
4
1
5
6
8
9
Alineación: Derecha (Tope siempre en índice 0).
Costo: ¡Pesadísimo! Al agregar, hay que
desplazar TODO el arreglo hacia la derecha
(O(n)). La variable apunta a la última posición
ocupada.
Estrategia 3
4
1
1
2
3
3
5
4
5
6
7
8
9
7
Alineación: Izquierda.
Puntero: No hay variable separada. Se
sacrifica el índice 0 del arreglo para guardar
la cantidad de elementos.

## Página 19 (ocr)

El Taller del Desarrollador: Tu Caja de Herramientas
TDA
Pila
Cola
Conjunto
Diccionario
Regla de Flujo
LIFO (Último en entrar,
primero en salir)
FIFO (Primero en entrar,
primero en salir)
Sin orden, sin duplicados
Mapeo Clave-Valor
Analogía Real
Platos sucios
Fila del
supermercado
Bolsa de
sorpresas
Agenda
telefónica
Operaciones Clave
Apilar(), Desapilar()
Acolar(), Desacolar()
Agregar(), Pertenece()
Agregar (K,V),
Recuperar(K)
Developer
