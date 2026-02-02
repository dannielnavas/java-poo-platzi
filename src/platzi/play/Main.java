package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;

public class Main {
    public static final String VERSION = "1.0.0";
    public static  final String NOMBRE_PLATAFORMA = "Platzi Play";
    public  static  final int SALIR = 5;
    public  static  final int AGREGAR = 1;
    public  static  final int MOSTRAR = 2;
    public  static  final int MOSTRAR_TITULO = 3;
    public  static  final int ELIMINAR = 4;


    public static void main(String[] args) {
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        String nombre = ScannerUtils.capturarTexto("Nombre del contenido: ");
        String generoDeContenido = ScannerUtils.capturarTexto("Género del contenido: ");
        int duracion = ScannerUtils.capturarEntero("Duración en minutos: ");
        double calificacion = ScannerUtils.capturarDecimal("Calificación (0.0 - 10.0): ");

        Pelicula pelicula = new Pelicula(
                nombre,
                "",
                duracion,
                generoDeContenido,
                LocalDate.now()
        ); // instaciando el objeto Pelicula
//        pelicula.titulo = nombre;
//        pelicula.descripcion = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.";
//        pelicula.duracion = duracion;

//        long  duracionLong = pelicula.duracion;
//        int calificacion = (int) pelicula.calificacion;
//        long numeroDePremios = Long.parseLong("25");
//        int numeroDeActores = (int) Long.parseLong("2500000000000");
//        System.out.println("Numero de premios: " + numeroDePremios);

//        System.out.println("Duracion en long: " + duracionLong);
//        pelicula.genero = generoDeContenido;
//        pelicula.fechaEstreno = LocalDate.of(2024, 7, 16);
//        pelicula.calificar(calificacion);
//        pelicula.disponible = true;

//        Usuario usuario = new Usuario("Danniel Navas", "dannielnavas@gmail.com");
//        usuario.ver(pelicula);
//        System.out.println(pelicula.obtenerFichaTecnica());
//
//        // plataforma
//
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
//                plataforma.agreagar(pelicula);
//
//       plataforma.mostrarTitulos();
//       plataforma.eliminar(pelicula);
//


       while(true) {
           int opcionElegida = ScannerUtils.capturarEntero(
                   "Seleccione una opción:\n" +
                           "1. Agregar película\n" +
                           "2. Mostrar todo\n" +
                           "3. Mostrar títulos\n" +
                           "4. Eliminar película\n" +
                           "5. Salir\n" +
                           "Opción: "
           );
           System.out.println("Opcion elegida: " + opcionElegida);

           switch (opcionElegida) {
               case AGREGAR -> {
                   String titulo = ScannerUtils.capturarTexto("Título de la película: ");
                   String genero = ScannerUtils.capturarTexto("Género de la película: ");
                   int duracionMinutos = ScannerUtils.capturarEntero("Duración en minutos: ");

                   Pelicula nuevaPelicula = new Pelicula(
                           titulo,
                           "",
                           duracionMinutos,
                           genero,
                           LocalDate.now()
                   );
                   plataforma.agreagar(nuevaPelicula);
               }
               case MOSTRAR_TITULO -> {
                     plataforma.mostrarTitulos();
               }
               case MOSTRAR -> {
                   // falta
               }
               case ELIMINAR -> {
                   // falta
               }
                case SALIR -> System.exit(0);

           }

           if(opcionElegida == AGREGAR) {
               String titulo = ScannerUtils.capturarTexto("Título de la película: ");
               String genero = ScannerUtils.capturarTexto("Género de la película: ");
               int duracionMinutos = ScannerUtils.capturarEntero("Duración en minutos: ");

               Pelicula nuevaPelicula = new Pelicula(
                       titulo,
                       "",
                       duracionMinutos,
                       genero,
                       LocalDate.now()
               );
               plataforma.agreagar(nuevaPelicula);
           } else  if(opcionElegida == MOSTRAR) {
               plataforma.mostrarTitulos();
           } else if(opcionElegida == MOSTRAR_TITULO) {
               // falta
           } else if(opcionElegida == ELIMINAR) {
               // falta
           }
           else  if(opcionElegida == SALIR) {
               System.exit(0);
           }
       }
    }
}
