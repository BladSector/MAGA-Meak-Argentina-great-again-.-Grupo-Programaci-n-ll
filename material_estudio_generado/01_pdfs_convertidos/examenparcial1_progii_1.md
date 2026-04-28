# ExamenParcial1 ProgII (1)

Origen: `archivos_del_teams/ExamenParcial1_ProgII (1).pdf`

> Conversión automática a Markdown. Las páginas marcadas como `ocr` vienen de reconocimiento de texto sobre imagen.

## Página 1 (texto)

UADE
PROGRAMACIÓN II
ALGORITMOS Y ESTRUCTURAS DE DATOS II
Dpto. Tecnología Informática | Duración: 1 hora | Aprobación ≥ 60%
EXAMEN
PARCIAL
1
ALUMNO:
___________________________
LU: ________________ FECHA: _____________
CARRERA:
__________________________
TURNO: _____________ HOJA: /
INSTRUCCIONES: Justificá toda respuesta. Usá los nombres de operaciones del TDA correspondiente. Las respuestas
se cargan en un formulario: seguí exactamente el formato de las "Convenciones para respuestas escritas". Preguntas
que no sepas responder: escribí "NO RESPONDO". Firmá en la última hoja.
CONVENCIONES PARA RESPUESTAS ESCRITAS
Las respuestas se cargan en un formulario: NO se aceptan dibujos ni gráficos. Describí todo textualmente siguiendo
exactamente los formatos indicados.
▸ Estado de una PILA
De BASE a CIMA: base→v1→v2→...→tope → ejemplo: base→4→9→2→3→tope
Estado del arreglo: indicá datos[0] y los valores datos[1]..datos[datos[0]].
▸ Estado de una COLA
De PRIMERO al último: Primero→v1→v2→...→último → ejemplo: Primero→10→25→7→último
▸ Estado de una COLA CON PRIORIDAD
Una línea por subcola, de mayor a menor prioridad, de Primero() al último. Formato: Subcola P=X: [v1, v2, ...]
Ejemplo — K=3 subcolas (P=0 mayor prioridad):
Subcola P=0: [5, 3]
Subcola P=1: [9]
Subcola P=2: vacía
▸ Estado de un CONJUNTO
Todos los elementos entre llaves: {v1, v2, ...} → ejemplo: {3, 7, 12} (el orden no importa)
▸ Estado de un DICCIONARIO SIMPLE
Pares clave→valor: {clave→valor, ...} → ejemplo: {3→15, 7→8}
▸ Estado de un DICCIONARIO MÚLTIPLE
Pares clave→conjunto: {clave→{v1,v2}, ...} → ejemplo: {2→{10,15}, 4→{7,3}}
Claves(): solo las claves entre llaves: {k1, k2, ...}
Ej 1 Ej 2 Ej 3 Ej 4 Ej 5 TOTAL
20 pts 20 pts 20 pts 20 pts 20 pts 100 pts
Obt.: ___ Obt.: ___ Obt.: ___ Obt.: ___ Obt.: ___ NOTA: ___
EJERCICIO 1 — TDA PILA
TDA Pila: InicializarPila(P), Apilar(P,x), Desapilar(P), Tope(P), PilaVacia(P). Implementación estática: datos[0]
almacena la cantidad de elementos; el tope está en datos[datos[0]]. MAX=7.
class PilaTDA {
static final int MAX = 7;
int[] datos = new int[MAX + 1];
void InicializarPila() { datos[0] = 0; }
boolean PilaVacia() { return datos[0] == 0; }
boolean PilaLlena() { return datos[0] == MAX; }
int Tope() { return datos[datos[0]]; }
void Apilar(int x) {
if (!PilaLlena()) {
datos[0]++;
datos[datos[0]] = x;
}
}
void Desapilar() {
if (!PilaVacia()) datos[0]--;
}
int metodoV() {

## Página 2 (texto)

PilaTDA aux = new PilaTDA(); aux.InicializarPila();
int suma = 0;
while (!PilaVacia()) {
int x = Tope(); Desapilar();
suma += x;
aux.Apilar(x);
}
while (!aux.PilaVacia()) {
Apilar(aux.Tope()); aux.Desapilar();
}
return suma;
}
}
1) Ejecutá las instrucciones sobre una pila vacía. Para cada línea marcada indicá: el valor retornado, el valor de
datos[0] y el contenido de la pila en formato "base→...→tope". [8 pts]
Rúbrica: 1 pt por cada inciso correcto (8 en total).
PilaTDA p = new PilaTDA(); p.InicializarPila();
p.Apilar(5); p.Apilar(12); p.Apilar(3); p.Apilar(8); p.Apilar(1);
System.out.println(p.Tope()); // (a)
System.out.println(p.datos[0]); // (b)
p.Desapilar(); p.Desapilar();
p.Apilar(9); p.Apilar(6);
System.out.println(p.Tope()); // (c)
System.out.println(p.datos[0]); // (d)
System.out.println(p.metodoV()); // (e)
System.out.println(p.Tope()); // (f)
System.out.println(p.datos[0]); // (g)
p.Apilar(4); p.Apilar(7);
System.out.println(p.datos[0]); // (h)
2) Describí en lenguaje natural qué hace metodoV(). ¿La pila queda modificada al terminar? Para el estado del
inciso (d), indicá el valor concreto que retorna y explicá por qué. [4 pts]
Rúbrica: 2 pts: descripción correcta. 1 pt: estado de la pila al terminar. 1 pt: valor concreto y justificación.
3) ¿Qué ocurre si intentás Apilar un elemento cuando la pila ya está llena (PilaLlena() = true)? ¿Y si intentás
Desapilar cuando está vacía (PilaVacia() = true)? Explicá el comportamiento basándote en el código de la
implementación. [4 pts]
Rúbrica: 2 pts: comportamiento al Apilar con pila llena. 2 pts: comportamiento al Desapilar con pila vacía.
4) Describí las diferencias entre la implementación estática (arreglo) y la implementación dinámica (lista
enlazada) del TDA Pila. Mencioná una ventaja y una desventaja de cada una. [4 pts]
Rúbrica: 2 pts: diferencias correctas. 1 pt: ventaja/desventaja estática. 1 pt: ventaja/desventaja dinámica.
EJERCICIO 2 — TDA COLA y TDA CONJUNTO
TDA Cola: InicializarCola(C), Acolar(C,x), Desacolar(C), Primero(C), ColaVacia(C). TDA Conjunto:
InicializarConjunto(S), Agregar(S,x), Sacar(S,x), Elegir(S), Pertenece(S,x), ConjuntoVacio(S). Implementación
dinámica de Cola (lista enlazada, sin límite de capacidad). Implementación estática de Conjunto (arreglo sin
orden, MAX=6; datos[0]=cantidad):
class ColaTDA {
static class Nodo { int val; Nodo sig; Nodo(int v){val=v;} }
Nodo cab = null, col = null;
void InicializarCola() { cab = null; col = null; }
boolean ColaVacia() { return cab == null; }
int Primero() { return cab.val; }
void Acolar(int x) {
Nodo n = new Nodo(x);
if (col != null) col.sig = n; else cab = n;
col = n;
}
void Desacolar() {
if (!ColaVacia()) {
cab = cab.sig;
if (cab == null) col = null;
}
}
}

## Página 3 (texto)

class ConjuntoTDA {
static final int MAX = 6;
int[] datos = new int[MAX + 1];
void InicializarConjunto() { datos[0] = 0; }
boolean ConjuntoVacio() { return datos[0] == 0; }
boolean ConjuntoLleno() { return datos[0] == MAX; }
boolean Pertenece(int x) {
for (int i = 1; i <= datos[0]; i++)
if (datos[i] == x) return true;
return false;
}
void Agregar(int x) {
if (!ConjuntoLleno() && !Pertenece(x)) {
datos[0]++; datos[datos[0]] = x;
}
}
void Sacar(int x) {
for (int i = 1; i <= datos[0]; i++) {
if (datos[i] == x) {
datos[i] = datos[datos[0]];
datos[0]--;
return;
}
}
}
int Elegir() { return datos[1]; }
}
5) Ejecutá las instrucciones sobre una cola vacía. Para cada línea marcada indicá el valor retornado y el
contenido de la cola en formato "Primero→...→último" (o "vacía" si corresponde). [5 pts]
Rúbrica: 1 pt por cada inciso correcto (5 en total).
ColaTDA c = new ColaTDA(); c.InicializarCola();
c.Acolar(4); c.Acolar(9); c.Acolar(2); c.Acolar(7); c.Acolar(5);
System.out.println(c.Primero()); // (a)
c.Desacolar(); c.Desacolar();
c.Acolar(11); c.Acolar(3);
System.out.println(c.Primero()); // (b)
c.Desacolar(); c.Desacolar(); c.Desacolar(); c.Desacolar(); c.Desacolar();
System.out.println(c.ColaVacia()); // (c)
System.out.println(c.Primero()); // (d) — c.Acolar(8);
System.out.println(c.Primero()); // (e)
6) Ejecutá las instrucciones sobre un conjunto vacío. Para cada línea marcada indicá el valor retornado y el
estado del conjunto en formato "{v1, v2, ...}". [7 pts]
Rúbrica: 1 pt por cada inciso correcto (7 en total).
ConjuntoTDA s = new ConjuntoTDA(); s.InicializarConjunto();
s.Agregar(3); s.Agregar(7); s.Agregar(1); s.Agregar(5); s.Agregar(9);
System.out.println(s.Pertenece(7)); // (a)
System.out.println(s.Pertenece(4)); // (b)
s.Sacar(1); s.Agregar(4);
System.out.println(s.ConjuntoVacio()); // (c)
System.out.println(s.Pertenece(1)); // (d)
System.out.println(s.Pertenece(4)); // (e)
s.Agregar(2);
System.out.println(s.datos[0]); // (f)
s.Agregar(6);
System.out.println(s.datos[0]); // (g) —
7) ¿Qué ocurre si llamás a Agregar cuando el conjunto ya está lleno (ConjuntoLleno() = true)? ¿Y si llamás a
Agregar con un elemento que ya pertenece al conjunto? Explicá el comportamiento basándote en el código. [4
pts]
Rúbrica: 2 pts: comportamiento con conjunto lleno. 2 pts: comportamiento con elemento ya existente.
8) Implementá un método externo estático que, dada una Cola y un Conjunto, elimine de la Cola todos los
elementos que pertenecen al Conjunto, dejando la Cola con el resto de los elementos en el mismo orden. Usá
solo las operaciones de ambos TDAs. [4 pts]
Rúbrica: 4 pts: código correcto usando solo operaciones de los TDAs.

## Página 4 (texto)

EJERCICIO 3 — TDA COLA CON PRIORIDAD
TDA Cola con Prioridad: InicializarCola(CP), AcolarPrioridad(CP,x,p), Desacolar(CP), Primero(CP), Prioridad(CP),
ColaVacia(CP). Implementación: K=3 subcolas circulares de CAP=4 cada una (P=0 es la de mayor prioridad).
AcolarPrioridad encola al final de la subcola p. Si la subcola está llena, la operación no tiene efecto. Desacolar
recorre desde P=0 hasta P=K−1 y extrae el primero de la primera subcola no vacía.
9) Ejecutá las operaciones sobre una Cola con Prioridad vacía. Para cada línea marcada indicá el valor retornado
y el estado de las subcolas con el formato de Convenciones. [8 pts]
Rúbrica: 1 pt por cada inciso correcto (8 en total).
ColaPrioTDA cp = new ColaPrioTDA(); cp.InicializarCola();
cp.AcolarPrioridad(6, 1);
cp.AcolarPrioridad(2, 0);
cp.AcolarPrioridad(13, 2);
cp.AcolarPrioridad(5, 0);
cp.AcolarPrioridad(9, 1);
cp.AcolarPrioridad(1, 2);
cp.AcolarPrioridad(4, 0);
System.out.println(cp.Primero()); // (a)
System.out.println(cp.Prioridad()); // (b)
cp.Desacolar();
System.out.println(cp.Primero()); // (c)
cp.Desacolar(); cp.Desacolar();
System.out.println(cp.Primero()); // (d)
System.out.println(cp.Prioridad()); // (e)
cp.AcolarPrioridad(7, 0);
cp.AcolarPrioridad(3, 0);
System.out.println(cp.Primero()); // (f)
System.out.println(cp.ColaVacia()); // (g)
cp.AcolarPrioridad(8, 0);
System.out.println(cp.Primero()); // (h)
10) Describí la diferencia entre el TDA Cola con Prioridad y el TDA Cola simple. ¿En qué se diferencia la
semántica de Desacolar en cada uno? [4 pts]
Rúbrica: 2 pts: diferencia conceptual. 2 pts: diferencia en la semántica de Desacolar.
11) Implementá un método externo estático que combine dos Colas con Prioridad CP1 y CP2 en una nueva Cola
con Prioridad CP3, de forma que contenga todos los elementos de CP1 y CP2 con sus prioridades originales. CP1
y CP2 deben quedar intactas al terminar. Usá solo las operaciones del TDA. [8 pts]
Rúbrica: 6 pts: código correcto usando solo operaciones del TDA. 2 pts: CP1 y CP2 quedan intactas.
EJERCICIO 4 — TDA DICCIONARIO SIMPLE y TDA DICCIONARIO MÚLTIPLE
TDA Diccionario Simple: InicializarDiccionario(D), Agregar(D,clave,valor), Eliminar(D,clave), Recuperar(D,clave),
Claves(D). Agregar con una clave ya existente reemplaza el valor anterior. TDA Diccionario Múltiple:
InicializarDiccionario(D), Agregar(D,clave,valor), Eliminar(D,clave), EliminarValor(D,clave,valor),
Recuperar(D,clave), Claves(D). Agregar con una clave ya existente añade el valor al conjunto de esa clave (sin
duplicados).
12) Ejecutá las operaciones sobre un Diccionario Simple vacío. Para cada línea marcada indicá el valor
retornado y el estado del diccionario en formato "{clave→valor, ...}". [7 pts]
Rúbrica: 1 pt por cada inciso correcto (7 en total).
DicSimpleTDA d = new DicSimpleTDA(); d.InicializarDiccionario();
d.Agregar(3, 15);
d.Agregar(7, 8);
d.Agregar(1, 22);
d.Agregar(5, 8);
System.out.println(d.Recuperar(7)); // (a)
System.out.println(d.Claves()); // (b)
d.Eliminar(3);
System.out.println(d.Recuperar(1)); // (c)
d.Agregar(7, 30);
System.out.println(d.Recuperar(7)); // (d)
System.out.println(d.Claves()); // (e)
d.Eliminar(5); d.Eliminar(1);
System.out.println(d.Claves()); // (f)
d.Agregar(2, 10);
System.out.println(d.Recuperar(2)); // (g)

## Página 5 (texto)

13) Ejecutá las operaciones sobre un Diccionario Múltiple vacío. Para cada línea marcada indicá el valor
retornado y el estado del diccionario en formato "{clave→{valores}, ...}". [7 pts]
Rúbrica: 1 pt por cada inciso correcto (7 en total).
DicMultipleTDA dm = new DicMultipleTDA(); dm.InicializarDiccionario();
dm.Agregar(2, 10);
dm.Agregar(2, 15);
dm.Agregar(4, 7);
dm.Agregar(4, 3);
dm.Agregar(4, 12);
dm.Agregar(6, 5);
dm.Agregar(2, 8);
System.out.println(dm.Recuperar(2)); // (a)
System.out.println(dm.Recuperar(4)); // (b)
System.out.println(dm.Claves()); // (c)
dm.EliminarValor(4, 3);
System.out.println(dm.Recuperar(4)); // (d)
dm.Eliminar(6);
System.out.println(dm.Claves()); // (e)
dm.Agregar(2, 10);
System.out.println(dm.Recuperar(2)); // (f)
dm.EliminarValor(2, 99);
System.out.println(dm.Recuperar(2)); // (g)
14) Describí la diferencia conceptual entre Diccionario Simple y Diccionario Múltiple. ¿Qué ocurre en cada uno si
se llama a Agregar con una clave que ya existe? [6 pts]
Rúbrica: 3 pts: diferencia conceptual. 3 pts: comportamiento de Agregar con clave existente en cada uno.
EJERCICIO 5 — PROBLEMA INTEGRADOR
Usá únicamente las operaciones de los TDAs. No está permitido acceder directamente a la implementación
interna.
15) Implementá un método externo estático frecuencias(PilaTDA p, DicSimpleTDA d) que, dada una pila p,
construya en d un Diccionario Simple donde cada clave es un valor que aparece en la pila y el valor asociado es
la cantidad de veces que ese valor aparece. La pila p debe quedar intacta al terminar. [10 pts]
Rúbrica: 6 pts: código correcto usando solo operaciones de los TDAs. 4 pts: la pila queda intacta al terminar.
16) Dado un Diccionario Simple d con claves enteras y valores enteros, implementá un método externo estático
invertir(DicSimpleTDA d, DicMultipleTDA dm) que construya en dm un Diccionario Múltiple donde cada clave es
un valor de d y el conjunto asociado son las claves de d que tenían ese valor. Ejemplo: si d = {1→5, 2→8, 3→5,
4→8} entonces dm debe quedar = {5→{1,3}, 8→{2,4}}. [10 pts]
Rúbrica: 7 pts: código correcto usando solo operaciones de los TDAs. 3 pts: manejo correcto cuando dos claves de d tienen el mismo valor.
Firma de honor — FIRMA: __________________________ ACLARACIÓN: __________________________
