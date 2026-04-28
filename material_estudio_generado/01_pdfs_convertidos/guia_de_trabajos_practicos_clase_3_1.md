# GUÍA DE TRABAJOS PRÁCTICOS clase 3 (1)

Origen: `archivos_del_teams/GUÍA DE TRABAJOS PRÁCTICOS clase 3 (1).pdf`

> Conversión automática a Markdown. Las páginas marcadas como `ocr` vienen de reconocimiento de texto sobre imagen.

## Página 1 (texto)

GUÍA DE TRABAJOS
PRÁCTICOS finde XL:
MODELADO DE TDAS
1. Machete Rápido: Comportamiento y Operaciones
Para que no se olviden nada antes del parcial, acá tienen el
resumen de las estructuras. Ojo con los nombres de los métodos,
que en Java los vamos a implementar tal cual:
TDA Lógica Operaciones Principales
Pila LIFO (Last In, First Out) InicializarPila, Apilar, Desapilar,
Tope, PilaVacia
Cola FIFO (First In, First Out) InicializarCola, Acolar,
Desacolar, Primero, ColaVacia
Cola de
Prioridad
Ranking (Mayor val =
Prioridad)
AcolarPrioridad, Desacolar,
Primero, Prioridad
Conjunto Sin duplicados / Sin
orden
Agregar, Sacar, Pertenece,
Elegir, ConjuntoVacio
Diccionario
Simple
Clave única \rightarrow
Valor único
Agregar, Eliminar, Recuperar,
Claves
Diccionario
Múltiple
Clave única \rightarrow
Conjunto de valores
Agregar, EliminarValor,
Recuperar, Claves
Refuerzo (La Interfaz):
public interface PilaTDA {
void InicializarPila();
void Apilar(int x);
void Desapilar();
int Tope();
boolean PilaVacia();
}
--------------------------------------------------------------------------------
2. Bloque 1: Pilas (LIFO - Last In, First Out)
La Pila es como esa montaña de platos para lavar en el depto de
estudiantes: el último que apoyás arriba es el primero que tenés
que lavar (o el primero que vuela si se cae la pila).
Historial de Navegación: El botón "Atrás" del Chrome. Si visitás fi.uba.ar,
después campus.utn.edu.ar y por último stackoverflow.com.
o Consigna: Identificá qué se apila en cada paso y qué sucede (qué se
desapila) cuando el usuario aprieta la flechita de "Atrás".

## Página 2 (texto)

Editor de Código (Undo/Deshacer): Estás codeando y borrás una línea
por error.
o Consigna: Describí qué estado del código deberías Apilar cada vez
que el usuario hace un cambio y cómo recuperás el estado anterior.
Balanceo de Paréntesis: El compilador de Java chequea que no te hayas
olvidado de cerrar una llave.
o Consigna: En la expresión ( ( a + b ) * c ), ¿en qué momento exacto
hacés un Apilar y cuándo comparás para hacer un Desapilar?
Reversión de Strings: Querés dar vuelta la palabra "ALGORITMOS".
o Consigna: Explicá el proceso de meter letra por letra en la Pila y
cómo quedan al sacarlas.
Pila de Llamadas (Call Stack): Cuando una función llama a otra.
o Consigna: Si Main() llama a CalcularPromedio() y esta llama a
Sumar(), ¿quién está en el Tope() en el momento de la ejecución de
la suma?
Navegación de Directorios: Entrás a C:/, luego a Usuarios, luego a
Documentos.
o Consigna: ¿Cómo usás una Pila para que el sistema sepa a qué
carpeta volver si apretás "Subir un nivel"?
--------------------------------------------------------------------------------
3. Bloque 2: Colas y Colas con Prioridad (FIFO +
Ranking)
Acá el que llega primero se atiende primero... a menos que seas un
pesado con privilegios o una emergencia médica. Importante:
Usamos el criterio "Mayor valor entero = Mayor prioridad".
Fila del Cajero: Los clientes llegan al banco de la esquina de la facultad.
o Consigna: ¿Es Cola común o de Prioridad? Justificá según la lógica de
atención.
Impresora del Laboratorio: Todos mandan el TP al mismo tiempo para
que no cierre la entrega.
o Consigna: Si la impresora recibe 5 archivos, ¿cuál es el orden de
salida?
Guardia del Hospital de Clínicas (Triage):
o Situación: Llega un pibe con un raspón (Prioridad 1) y un jubilado
con un bobazo (Prioridad 100).

## Página 3 (texto)

o Consigna: Definí los valores de prioridad para 3 casos distintos de tu
elección.
Examen Final (Promocionados vs Regulares):
o Situación: En la cartelera se anotan todos. Pero los que
promocionaron (Prioridad 10) pasan antes que los que rinden final
(Prioridad 5).
o Consigna: Si un regular llegó a las 8:00 AM y un promocionado a las
8:30 AM, ¿quién sale primero al hacer Desacolar?
Buffet de la Facultad: Fila para el sanguchito de milanesa.
o Consigna: ¿Qué operación de TDA Cola usás para asegurar que no se
cuele ningún "vibe coder"?
Procesador de Tareas (OS Scheduler): El sistema operativo maneja
procesos del sistema (Prioridad 50) y procesos del usuario como el Spotify
(Prioridad 10).
o Consigna: Asigná prioridades y explicá qué pasa si el sistema se
sobrecarga.
Embarque de Aerolíneas: Primero suben pasajeros con movilidad
reducida (Prioridad 3), luego Business (Prioridad 2) y al final los mortales
(Prioridad 1).
o Consigna: Identificá el comportamiento si llegan dos personas con la
misma prioridad.
Distribución de Tickets IT: Se rompió el servidor principal (Prioridad 999)
vs "No me gusta el fondo de pantalla" (Prioridad 0).
o Consigna: Definí explícitamente el valor de prioridad para cada caso.
--------------------------------------------------------------------------------
4. Bloque 3: Conjuntos (Sin Duplicados)
En un Conjunto, si ya estás, no entrás de nuevo. Es como el derecho
de admisión de un boliche pero sin el patovica mala onda.
Padrón Electoral: Registro de alumnos para votar en el Centro de
Estudiantes.
o Operación Clave: ¿Cómo evitás que un "vivo" vote dos veces usando
Pertenece?
Invitados a la Fiesta de Fin de Cursada:
o Consigna: ¿Qué pasa si intentás Agregar a alguien que ya está en la
lista? ¿Cambia el tamaño del conjunto?
Filtro de Spam (Blacklist): Un conjunto de palabras como "Crypto",
"Ganá", "Premio".

## Página 4 (texto)

o Consigna: ¿Cómo verificás si un mail entrante tiene una palabra
prohibida?
Tags de un Blog de Ingeniería: Un post sobre Java tiene etiquetas
#Programacion, #Java, #OOP.
o Consigna: ¿Por qué usamos un Conjunto y no una Pila para los tags?
Gestión de Legajos: En la base de datos de Ingeniería en Informática, el
legajo es único.
o Consigna: Si un alumno se anota a dos carreras, ¿cómo se asegura
el sistema de no duplicar su ID?
Operación Elegir vs Sacar:
o Pregunta Técnica: Si llamás a Elegir dos veces seguidas sin llamar a
Sacar, ¿te devuelve el mismo elemento? (Pista: Es arbitrario, no
necesariamente aleatorio).
--------------------------------------------------------------------------------
5. Bloque 4: Diccionarios Simples y Múltiples (Clave-
Valor)
La clave es única, el valor puede ser uno (Simple) o muchos
(Múltiple).
Agenda de Contactos:
o TDA: Simple.
o Modelado: Clave: [Nombre] / Valor: [Teléfono]
Diccionario de Sinónimos:
o TDA: Múltiple.
o Modelado: Clave: [Palabra] / Valor: [Conjunto de Sinónimos]
Puntajes de Torneo de E-Sports: Cada usuario tiene un puntaje
máximo.
o Modelado: Clave: [ ] / Valor: [ ]
Traductor de Idiomas: La palabra "Bank" puede ser "Banco" o "Orilla".
o TDA Sugerido: Justificá si usarías Simple o Múltiple.
Índice de un Libro de Algoritmos: La palabra "Recursión" aparece en
las páginas 12, 45 y 88.
o Modelado: Clave: [ ] / Valor: [ ]
Inscripción por Alumno: Un legajo está anotado a varias materias.

## Página 5 (texto)

o Modelado: Clave: [Legajo] / Valor: [Conjunto de Materias]
DNS (Domain Name System): google.com \rightarrow 142.250.190.46.
o Modelado: Clave: [ ] / Valor: [ ]
Chipotle Support Bot (Meme Context): El bot Pepper asocia un ID de
Orden con un script de Python para resolver un problema.
o Modelado: Clave: [Orden ID] / Valor: [Script Python]
--------------------------------------------------------------------------------
6. Bloque 5: Mix de Modelado y Estrategias de
Implementación
1. El Hospital Premium: Modelar una guardia donde los pacientes se
atienden por prioridad (Cola de Prioridad), pero cada paciente tiene un
historial de síntomas que se guarda en una Pila (para ver el último
síntoma detectado primero).
2. Sistema de Tags de Facultad: Un Diccionario donde la clave es el
nombre de la carrera (ej: "Licenciatura en Bioinformática") y el valor es un
Conjunto de materias obligatorias.
3. Análisis de Implementación (Pilas): Existen 3 estrategias para Pilas
con arreglos.
o Estrat. 1: Arreglo + variable contador (apunta a la primera
posición libre).
o Estrat. 2: Arreglo + desplazamiento (el tope siempre está en el
índice 0).
o Estrat. 3: Arreglo donde la posición [0] guarda la cantidad de
elementos.
4. Pregunta de Parcial: ¿Cuál de estas estrategias es la más ineficiente
para Apilar y por qué?
o Respuesta esperada: Citá la complejidad temporal. En la Estrategia
2, cada vez que apilás, tenés que desplazar todos los elementos
existentes una posición a la derecha. Eso es un costo O(n),
mientras que la Estrategia 1 es O(1) porque vas directo al índice.
--------------------------------------------------------------------------------
7. Desafío Final: El Sistema del "Departamento de
Tecnología"
La UADE te pide modelar el sistema de inscripciones. No podés fallar.
Requerimientos:
1. Legajos únicos: Los alumnos no se pueden duplicar.
2. Lista de espera: Si una materia está llena, los alumnos esperan por
orden de llegada.

## Página 6 (texto)

3. Prioridad de Ingreso: Los alumnos que trabajan en el Departamento de
Tecnología se inscriben antes que el resto.
4. Correlatividades: Cada materia tiene un conjunto de materias previas
que deben estar aprobadas.
Consigna de Modelado:
Requerimiento 1 \rightarrow TDA: ___________ / Operación para validar:
Pertenece
Requerimiento 2 y 3 \rightarrow TDA: ___________ / Criterio: Mayor valor =
Mayor prioridad.
Requerimiento 4 \rightarrow TDA: ___________ / Clave: [Materia] - Valor:
[Conjunto de Correlativas].
/**
* Ejemplo de firma para el sistema del Depto.
* Recordá usar @Override si implementás la interfaz.
*/
public void inscribirAlumno(int legajo, String materiaCod) {
// Si el legajo NO pertenece al conjunto de inscriptos...
// Acolar con prioridad según el promedio o cargo...
}
