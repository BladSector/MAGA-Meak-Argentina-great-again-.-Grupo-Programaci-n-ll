# TDA, abstraccion e interfaz

Un TDA es una caja negra. Desde afuera importa que operaciones ofrece y que comportamiento promete. La implementacion interna puede ser un arreglo, una lista enlazada o cualquier otra cosa.

La idea fuerte es separar dos preguntas:

- Que hace: `Apilar`, `Desapilar`, `Tope`.
- Como lo hace: arreglo, nodos, indices, punteros, contador.

Si mezclas esas dos capas, el codigo queda atado a una implementacion concreta. Hoy funciona con arreglo, mañana cambian a nodos y se rompe.

## Interfaz como contrato

La interfaz dice que metodos existen. No dice como se guardan los datos.

```java
public interface PilaTDA {
    void InicializarPila();
    void Apilar(int x);
    void Desapilar();
    int Tope();
    boolean PilaVacia();
}
```

Si una clase implementa esa interfaz, esta obligada a cumplir esos metodos:

```java
public class PilaDinamica implements PilaTDA {
    private Node tope;

    public void InicializarPila() {
        tope = null;
    }

    public void Apilar(int x) {
        tope = new Node(x, tope);
    }

    public void Desapilar() {
        if (!PilaVacia()) {
            tope = tope.getNext();
        }
    }

    public int Tope() {
        return tope.getData();
    }

    public boolean PilaVacia() {
        return tope == null;
    }
}
```

El usuario de la pila no deberia saber que existe `tope`. Solo usa la interfaz.

## Como responder teoria

Si preguntan "por que usar TDA", responde:

```text
Porque permite separar especificacion e implementacion. El usuario trabaja con operaciones abstractas y no depende de la estructura interna. Eso permite cambiar una implementacion estatica por una dinamica sin modificar el codigo que usa el TDA, mientras se respete el contrato.
```

Si preguntan "que es caja negra", responde:

```text
Es usar una estructura por sus operaciones visibles sin conocer ni tocar su representacion interna.
```

Si preguntan "que pasa si accedo directo al arreglo", responde:

```text
Estoy rompiendo la abstraccion. Mi codigo queda acoplado a esa implementacion y deja de servir si cambia el arreglo por nodos.
```
