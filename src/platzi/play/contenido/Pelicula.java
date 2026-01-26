package platzi.play.contenido;

public class Pelicula {
    public String titulo;
    public String descripcion;
    public int duracion; // Duracion en minutos
    public String genero;
    public int anioEstreno;
    public double calificacion; // Calificacion de 0.0 a 10.0
    public boolean disponible;

    public void reproducir() {
        System.out.println("Reproduciendo la película: " + titulo);
    }

    public String obtenerFichaTecnica() {
        return "Título: " + titulo + "\n" +
               "Descripción: " + descripcion + "\n" +
               "Duración: " + duracion + " minutos\n" +
               "Género: " + genero + "\n" +
               "Año de Estreno: " + anioEstreno + "\n" +
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
}
