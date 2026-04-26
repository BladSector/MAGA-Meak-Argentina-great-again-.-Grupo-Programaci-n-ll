sistema de inscripciones

una nueva class alumnos:
    primary key: legajo, no se debe repetir

hay una class materia
    la materia tiene cupos
    la materia tiene un id unico primary key
    la materia puede tener correlativas, son otras materias y se listan por su id unico
    
    los cupos son una cola con prioridad, ya que si llega alguien

    if cupo esta lleno entonces
        todo el que llegue se debe poner en una cola con prioridad
            en esta los alumnos que sean de informatica tienen prioridad sobre los demas
    