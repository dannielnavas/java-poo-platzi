package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Platzi Play - Tu plataforma de entretenimiento favorita");
        Pelicula pelicula = new Pelicula(); // instaciando el objeto Pelicula
        pelicula.titulo = "Inception";
        pelicula.descripcion = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.";
        pelicula.duracion = 148;

        long  duracionLong = pelicula.duracion;

        System.out.println("Duracion en long: " + duracionLong);
        pelicula.genero = "Science Fiction";
        pelicula.fechaEstreno = LocalDate.of(2024, 7, 16);
        pelicula.calificar(8.8);
        pelicula.disponible = true;

        Usuario usuario = new Usuario();
        usuario.nombre = "Danniel Navas";
        usuario.fechaRegistro = LocalDateTime.now();
        usuario.ver(pelicula);
        System.out.println(pelicula.obtenerFichaTecnica());


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Por favor, ingresa tu nombre:");
//        String nombre = scanner.nextLine();
//        System.out.println("¡Hola, " + nombre + "! Bienvenido a Platzi Play.");
//        System.out.println(nombre + ", Cuantos años tienes?");
//        int edad = scanner.nextInt();
//        System.out.println(nombre +", puedes ver contenido +"+ edad);
//        scanner.close();


    }
}
