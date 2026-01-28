package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static final String VERSION = "1.0.0";
    public static void main(String[] args) {
        System.out.println("Platzi Play - Tu plataforma de entretenimiento favorita");

        String nombre = ScannerUtils.capturarTexto("Nombre del contenido: ");
        String generoDeContenido = ScannerUtils.capturarTexto("Género del contenido: ");
        int duracion = ScannerUtils.capturarEntero("Duración en minutos: ");
        double calificacion = ScannerUtils.capturarDecimal("Calificación (0.0 - 10.0): ");

        Pelicula pelicula = new Pelicula(); // instaciando el objeto Pelicula
        pelicula.titulo = nombre;
        pelicula.descripcion = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.";
        pelicula.duracion = duracion;

//        long  duracionLong = pelicula.duracion;
//        int calificacion = (int) pelicula.calificacion;
//        long numeroDePremios = Long.parseLong("25");
//        int numeroDeActores = (int) Long.parseLong("2500000000000");
//        System.out.println("Numero de premios: " + numeroDePremios);

//        System.out.println("Duracion en long: " + duracionLong);
        pelicula.genero = generoDeContenido;
        pelicula.fechaEstreno = LocalDate.of(2024, 7, 16);
        pelicula.calificar(calificacion);
        pelicula.disponible = true;

        Usuario usuario = new Usuario();
        usuario.nombre = "Danniel Navas";
        usuario.fechaRegistro = LocalDateTime.now();
        usuario.ver(pelicula);
        System.out.println(pelicula.obtenerFichaTecnica());
    }
}
