## Pila(LIFO)

### 1. Ej: Historial de Navegacion
Primero tenes que crear una pila, y luego la inicializas.\
Cada vez ingresás una pagina, apilas la dicha pagina en la pila, asi haciendo que se guardo el historial en la pila.
Ahi es donde se apila.
```
pila.Apilar("fi.uba.ar");  
System.out.println(pila.Tope());  
pila.Apilar("campus.utn.edu.ar ");  
System.out.println(pila.Tope());  
pila.Apilar("stackoverflow.com");
```
Si un usuario quiere apretar la flechita de "Atras", lo cual debe actúa como Desapilar():
```
pila.Desapilar();
System.out.print(pila.Tope());
```

### 2.Editor de Codigo (Undo/Deshacer)
Usando unas dos pilas inicializadas, una auxiliar que va a ser usada para recuperar el estado anterior, y la otra original que apilas cada vez que el usuario hace un cambio.
Primero creas una pila para guardar unos cambios, con el simple de InicializarPila(), Apilar(cambio).
Y luego creas los siguientes metodos que sirviran para poder ver el historial y volver a los cambios.
```
\\Este es la pila para volver atras. Asi es como recuperas al estado anterior, similar como el CTRL+Z
while(!pilaTope.PilaVacia()) {
    System.out.print("\n"+pilaTope.Tope());
    pilaAtras.Apilar(pilaTope.Tope());
    pilaTope.Desapilar();
}
\\Asi es como volves a los cambios
while(!pilaAtras.PilaVacia()) {
    System.out.print("\n"+pilaAtras.Tope());
    pilaTope.Apilar(pilaAtras.Tope());
    pilaAtras.Desapilar();
}
```

### 3.Balanceo de Parantesis
Se apilara el valor que este dentro del parentesis, como por ejemplo;
```
((a+b)*2)
Pila.Apilar("a+b")
Pila.Apilar(*2)
PILA: [a+b, *2]
```

### 4.Reversion de Strings
Con el ayuda de value.charAt(i) y for.
Cada caracter de la palabra, se va a apilar el caracter que este localizado.\
Asi como tal se ve en el siguiente codigo.
```
String word = "ALGORITMOS";
//Vamos a poner cada letra de ALGORITMOS en la pila
for (int i = 0; i <= word.length()-1; i++) {
    pila.Apilar(String.valueOf(word.charAt(i)));
    System.out.print(pila.Tope()+"\n");
}
```

Para imprimir la pila y asi haciendo como se vea el resultado. Haciendo que la palabra se lea al reves.
```
while(!pila.PilaVacia()){
    System.out.print(pila.Tope()+"\n");
    pila.Desapilar();

}
```
El resultado:
```
S
O
M
T
I
R
O
G
L
A
```
### 5. Pila de Llamadas (Call Stack)
Si bien vas a inicializar una pila que guardara las notas de los parciales, y con los metodos CalcularPromedio que llamará la Sumar().\
Dentro del metodo de Suma, el tope va a ser la ultima nota que ingresaste. Y este tope va a ser usado como un elemento que sumará al total de las notas, asi haciendo que se acumule.\
Asi como tal se muestra el codigo:
```
public static double Suma(PilaTDAI pila){
    double aux = 0;
    while(!pila.PilaVacia()){
        aux+=pila.Tope();
        pila.Desapilar();
    }
    return (aux);
}
```


### 6. Navegacion de Directorios
Cada vez ingresas una carpeta, se apila la direccion en la pila ya inicializada, asi haciendo que se vean las carpetas.
``` 
Estrategia_1 pilaTope = new Estrategia_1();
pilaTope.InicializarPila();
pilaTope.Apilar("C://");
pilaTope.Apilar("Usuarios/");
pilaTope.Apilar("Documentos/");
```
Asi haciendo que la pila se vera como
`C://Users/mdriv/OneDrive/Documentos`\
Para saber a que carpeta volver si apretas a subir, es necesario usar la auxiliar pila o el auxiliar valor si en caso para leer que carpeta vas a volver atras\
```
String value=pilaTope.Tope();
pilaTope.Desapilar();
System.out.print("\n"+pilaTope.Tope()); // Se va a mostrar a que carpeta vas a volver.
pilaTope.Apilar(value); // Asi haciendo que estes en la pagina.
```
Asi es como usas una pila para que el sistema sepa