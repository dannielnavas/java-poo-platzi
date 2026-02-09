package platzi.play.contenido;

import java.time.LocalDate;

public class Pelicula extends Contenido {
//    constructor
    public Pelicula(String titulo, String descripcion, int duracion, Genero genero, double calificacion, LocalDate fechaEstreno, boolean disponible) {
        super(titulo, descripcion, duracion, genero, calificacion, fechaEstreno, disponible);
    }
}
