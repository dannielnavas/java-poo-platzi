package platzi.play.contenido;

import java.time.LocalDate;

public class Pelicula {
    private String titulo;
    private String descripcion;
    private int duracion; // Duracion en minutos
    private String genero;
    private double calificacion; // Calificacion de 0.0 a 10.0
    private LocalDate fechaEstreno;
    private boolean disponible;

    public Pelicula(String titulo, String descripcion, int duracion, String genero, LocalDate fechaEstreno) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;

    }

    public Pelicula(String titulo, String descripcion, int duracion, String genero, double calificacion, LocalDate fechaEstreno, boolean disponible) {
        this(titulo, descripcion, duracion, genero, fechaEstreno);
        this.calificar(calificacion);
        this.disponible = disponible;
    }

    public void reproducir() {
        System.out.println("Reproduciendo la película: " + titulo);
    }

    public String obtenerFichaTecnica() {
        return "Título: " + titulo + "\n" +
               "Descripción: " + descripcion + "\n" +
               "Duración: " + duracion + " minutos\n" +
               "Género: " + genero + "\n" +
               "Año de Estreno: " + fechaEstreno.getYear() + "\n" +
               "Calificación: " + calificacion + "/10\n" +
               "Disponible: " + (disponible ? "Sí" : "No");
    }

    public void calificar(double calificacion) {
        if(calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
            System.out.println("Has calificado la película " + titulo + " con " + calificacion + " puntos.");
        } else {
            System.out.println("Calificación inválida. Debe estar entre 0.0 y 10.0.");
        }
    }

    public boolean esPopular() {
        return calificacion >= 7.0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
