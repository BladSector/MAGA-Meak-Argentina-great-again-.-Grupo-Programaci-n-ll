Bloque 4: Diccionarios Simples y Múltiples (Clave-Valor) La clave es
única, el valor puede ser uno (Simple) o muchos (Múltiple).

Agenda de Contactos:

TDA: Simple. Modelado: Clave: \[Nombre\] / Valor: \[Teléfono\]

Diccionario de Sinónimos:

TDA: Múltiple. Modelado: Clave: \[Palabra\] / Valor: \[Conjunto de
Sinónimos\]

Puntajes de Torneo de E-Sports: Cada usuario tiene un puntaje máximo.

TDA: Simple. Cada usuario tiene un único puntaje máximo. Modelado:
Clave: \[Usuario\] / Valor: \[Puntaje Máximo\]

Traductor de Idiomas: La palabra \"Bank\" puede ser \"Banco\" o
\"Orilla\".

TDA Sugerido: Múltiple. Una misma palabra puede tener más de una
traducción según el contexto. Con un diccionario Simple solo se podría
guardar un valor por clave, perdiendo las traducciones restantes. Al
usar Múltiple, la clave \[Palabra\] puede asociarse con un conjunto de
traducciones: {\"Banco\", \"Orilla\"}.

Índice de un Libro de Algoritmos: La palabra \"Recursión\" aparece en
las páginas 12, 45 y 88.

TDA: Múltiple. Una palabra puede aparecer en varias páginas. Modelado:
Clave: \[Palabra\] / Valor: \[Conjunto de Páginas\]

Inscripción por Alumno: Un legajo está anotado a varias materias.

TDA: Múltiple. Un alumno puede cursar varias materias simultáneamente.
Modelado: Clave: \[Legajo\] / Valor: \[Conjunto de Materias\]

DNS (Domain Name System): google.com → 142.250.190.46.

TDA: Simple. Un nombre de dominio resuelve a una única dirección IP.
Modelado: Clave: \[Dominio\] / Valor: \[Dirección IP\]

Chipotle Support Bot (Meme Context): El bot Pepper asocia un ID de Orden
con un script de Python para resolver un problema.

TDA: Simple. Cada orden tiene un único script asociado. Modelado: Clave:
\[Orden ID\] / Valor: \[Script Python\]
