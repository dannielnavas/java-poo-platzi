package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static final String VERSION = "1.0.0";
    public static  final String NOMBRE_PLATAFORMA = "Platzi Play";
    public  static  final int SALIR = 6;
    public  static  final int AGREGAR = 1;
    public  static  final int MOSTRAR = 2;
    public  static  final int MOSTRAR_TITULO = 3;
    public  static  final int ELIMINAR = 4;
    public static final int BUSCAR_POR_GENERO = 5;
    public static final int VER_POPULARES = 7;


    public static void main(String[] args) {
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

//        String nombre = ScannerUtils.capturarTexto("Nombre del contenido: ");
//        String generoDeContenido = ScannerUtils.capturarTexto("Género del contenido: ");
//        int duracion = ScannerUtils.capturarEntero("Duración en minutos: ");
//        double calificacion = ScannerUtils.capturarDecimal("Calificación (0.0 - 10.0): ");

//        Pelicula pelicula = new Pelicula(
//                nombre,
//                "",
//                duracion,
//                generoDeContenido,
//                LocalDate.now()
//        ); // instaciando el objeto Pelicula
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

//                plataforma.agreagar(pelicula);
//
//       plataforma.mostrarTitulos();
//       plataforma.eliminar(pelicula);
//

        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        cargarPeliculas(plataforma);

        System.out.println("Bienvenido a " + plataforma.getNombre() + "! Tenemos " + plataforma.getContenio().size() + " películas disponibles, Y mas de " + plataforma.getDuracionTotal() + " minutos de entretenimiento para ti.");

       while(true) {
           int opcionElegida = ScannerUtils.capturarEntero(
                   "Seleccione una opción:\n" +
                           "1. Agregar película\n" +
                           "2. Mostrar todo\n" +
                           "3. Mostrar títulos\n" +
                           "4. Eliminar película\n" +
                           "5. Buscar por genero\n" +
                           "6. Salir\n" +
                           "7. Ver populares\n" +
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
                     String nombreBuscado = ScannerUtils.capturarTexto("Ingrese el título de la película a buscar: ");
                     Pelicula peliculaEncontrada = plataforma.buscarPorTitulo(nombreBuscado);
                     if(peliculaEncontrada != null) {
                             System.out.println("Película encontrada:");
                             System.out.println(peliculaEncontrada.obtenerFichaTecnica());
                      } else {
                             System.out.println("La película con título '" + nombreBuscado + "' no fue encontrada.");
                     }
               }
               case MOSTRAR -> {
                   List<String> titulos = plataforma.getTitulos();
                   titulos.forEach(System.out::println);
               }
               case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Ingrese el título de la película a eliminar: ");
                    Pelicula peliculaAEliminar = plataforma.buscarPorTitulo(nombreAEliminar);
                    if(peliculaAEliminar != null) {
                         plataforma.eliminar(peliculaAEliminar);
                         System.out.println("La película '" + nombreAEliminar + "' ha sido eliminada.");
                    } else {
                         System.out.println("La película con título '" + nombreAEliminar + "' no fue encontrada.");
                    }
               }
               case BUSCAR_POR_GENERO -> {
                   String generoBuscado = ScannerUtils.capturarTexto("Ingrese el género de las películas a buscar: ");
                   List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                   System.out.println(contenidoPorGenero.size() + " películas encontradas del género '" + generoBuscado + "':");
                   contenidoPorGenero.forEach(pelicula -> System.out.println("- " + pelicula.getTitulo()));

                   }
                case SALIR -> System.exit(0);

               case VER_POPULARES -> {
                   List<Pelicula> peliculasPopulares = plataforma.getPopulares(2);
                   peliculasPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));

               }
           }

//           if(opcionElegida == AGREGAR) {
//               String titulo = ScannerUtils.capturarTexto("Título de la película: ");
//               String genero = ScannerUtils.capturarTexto("Género de la película: ");
//               int duracionMinutos = ScannerUtils.capturarEntero("Duración en minutos: ");
//
//               Pelicula nuevaPelicula = new Pelicula(
//                       titulo,
//                       "",
//                       duracionMinutos,
//                       genero,
//                       LocalDate.now()
//               );
//               plataforma.agreagar(nuevaPelicula);
//           } else  if(opcionElegida == MOSTRAR) {
//               plataforma.mostrarTitulos();
//           } else if(opcionElegida == MOSTRAR_TITULO) {
//               String nombreBuscado = ScannerUtils.capturarTexto("Ingrese el título de la película a buscar: ");
//               Pelicula peliculaEncontrada = plataforma.buscarPorTitulo(nombreBuscado);
//               if(peliculaEncontrada != null) {
//                     System.out.println("Película encontrada:");
//                     System.out.println(peliculaEncontrada.obtenerFichaTecnica());
//                } else {
//                     System.out.println("La película con título '" + nombreBuscado + "' no fue encontrada.");
//               }
//           } else if(opcionElegida == ELIMINAR) {
//                String nombreAEliminar = ScannerUtils.capturarTexto("Ingrese el título de la película a eliminar: ");
//                Pelicula peliculaAEliminar = plataforma.buscarPorTitulo(nombreAEliminar);
//                if(peliculaAEliminar != null) {
//                     plataforma.eliminar(peliculaAEliminar);
//                     System.out.println("La película '" + nombreAEliminar + "' ha sido eliminada.");
//                } else {
//                     System.out.println("La película con título '" + nombreAEliminar + "' no fue encontrada.");
//                }
//           }
//           else  if(opcionElegida == SALIR) {
//               System.exit(0);
//           }
       }
    }

       private static  void cargarPeliculas(Plataforma plataforma) {
           plataforma.agreagar(
                     new Pelicula(
                            "Inception",
                            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                            148,
                            "Sci-Fi",
                            8.8,
                            LocalDate.of(2010, 7, 16),
                            true
                     )
           );
              plataforma.agreagar(
                        new Pelicula(
                             "The Dark Knight",
                             "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                             152,
                             "Action",
                             9.0,
                             LocalDate.of(2008, 7, 18),
                             true
                        )
              );
                plataforma.agreagar(
                            new Pelicula(
                                 "Interstellar",
                                 "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                                 169,
                                 "Sci-Fi",
                                 8.6,
                                 LocalDate.of(2014, 11, 7),
                                 true
                            )
                );
                plataforma.agreagar(
                        new Pelicula(
                             "The Matrix",
                             "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
                             136,
                             "Sci-Fi",
                             8.7,
                             LocalDate.of(1999, 3, 31),
                             true
                        )
                );
                plataforma.agreagar(
                        new Pelicula(
                             "Forrest Gump",
                             "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75.",
                             142,
                             "Drama",
                             8.8,
                             LocalDate.of(1994, 7, 6),
                             true
                        )
                );
        }


}
