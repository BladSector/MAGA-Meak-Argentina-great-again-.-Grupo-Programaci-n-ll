**BLOQUE 3**



**Padron electoral**

Para evitar que un "vivo" vote 2 veces, podemos usar un conjunto de votos donde se guarde el legajo del estudiante que voto. Cada vez que un estudiante intente agregar un voto (a partir del metodo Agregar), debe validarse previamente si ese estudiante ya voto, usando el metodo Pertenece para verificar que el estudiante no este en el conjunto.



**Invitados a la fiesta de fin de cursada**

Si se intenta agregar a alguien al conjunto de invitados a la fiesta que ya esta en la lista, el tamano de la misma no varia ya que los conjuntos no permiten duplicados.



**Filtro de Spam (Blacklist)**

Para verificar si un mail entrante tiene una palabra prohibida deneriamos recorrer el mail y preguntar palabra por palabra si pertenece al conjunto Blacklist.



**Tags de un Blog de ingenieria**

En este caso se usa un conjunto y no una pila ya que no nos interesa el orden de los elementos, y tampoco tiene sentido guardar elementos duplicados.



**Gestion de legajos**

Para asegurarse que el Sistema no duplique el ID de un estudiante que se anota a dos carreras diferentes, se deberia guardar en un conjunto el ID de los estudiantes. Entonces cada vez que un estudiante se anota a una Carrera, su ID se agrega al conjunto siempre y cuando no pertenezca al mismo previamente (metodo Pertenece)



**Operacion Elegir vs Sacar**

En la teoria, el metodo Elegir devuelve un elemento cualquiera que pertenezca al conjunto, por lo tanto no hay ninguna garantia de que el metodo devuelva siempre el mismo elemento ya que puede devolver cualquiera que pertenezca al conjunto. Sin embargo, la respuesta a esta pregunta va a depender de la implementacion interna del conjunto, ya que si el mismo usa una lista enlazada internamente lo mas probable es que siempre te devuelva el primer nodo de la lista, mientras que con otras implementaciones el elemento a devolver puede ser diferente en cada llamada.

