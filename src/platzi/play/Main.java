package platzi.play;

import platzi.play.contenido.*;
import platzi.play.excepcion.PeliculaExistenteExcetion;
import platzi.play.plataforma.Plataforma;
import platzi.play.util.FileUtils;
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
    public static final int REPRODUCIR = 8;



    public static void main(String[] args) {
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

//        String nombre = ScannerUtils.capturarTexto("Nombre del contenido: ");
//        String generoDeContenido = ScannerUtils.capturarTexto("Género del contenido: ");
//        int duracion = ScannerUtils.capturarEntero("Duración en minutos: ");
//        double calificacion = ScannerUtils.capturarDecimal("Calificación (0.0 - 10.0): ");

//        Contenido pelicula = new Contenido(
//                nombre,
//                "",
//                duracion,
//                generoDeContenido,
//                LocalDate.now()
//        ); // instaciando el objeto Contenido
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

        plataforma.getPromocionables().forEach(promocionables -> System.out.println(promocionables.promocional()));
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
                            "9. Buscar por tipo\n" +
                           "Opción: "
           );
           System.out.println("Opcion elegida: " + opcionElegida);

           switch (opcionElegida) {
               case AGREGAR -> {
                   int tipoContenido = ScannerUtils.capturarEntero("Tipo de contenido:\n1. Película\n2. Documental\nOpción: ");
                   String titulo = ScannerUtils.capturarTexto("Título de la película: ");
                   Genero genero = ScannerUtils.capturarGenero("Genero");
                   int duracionMinutos = ScannerUtils.capturarEntero("Duración en minutos: ");


                   try {
                       if(tipoContenido == 1) {
                           plataforma.agreagar(new Pelicula(
                                   titulo,
                                   "",
                                   duracionMinutos,
                                   genero,
                                   9.0,
                                   LocalDate.now(),
                                      true
                           ));
                       } else  {
                            String narrador = ScannerUtils.capturarTexto("Narrador del documental: ");
                            plataforma.agreagar(new Documental(
                                      titulo,
                                      "",
                                      duracionMinutos,
                                      genero,
                                      8.5,
                                      LocalDate.now(),
                                      true,
                                      narrador
                            ));
                       }

                   } catch (PeliculaExistenteExcetion e) {
                       System.out.println("Error al agregar la película: " + e.getMessage());
                   }

               }
               case MOSTRAR_TITULO -> {
                     String nombreBuscado = ScannerUtils.capturarTexto("Ingrese el título de la película a buscar: ");
                     Contenido contenidoEncontrada = plataforma.buscarPorTitulo(nombreBuscado);
                     if(contenidoEncontrada != null) {
                             System.out.println("Película encontrada:");
                             System.out.println(contenidoEncontrada.obtenerFichaTecnica());
                      } else {
                             System.out.println("La película con título '" + nombreBuscado + "' no fue encontrada.");
                     }
               }
               case MOSTRAR -> {
//                   List<String> titulos = plataforma.getTitulos();
//                   titulos.forEach(System.out::println);
                   List<ResumenCotenido> contenidosResumidos = plataforma.getResumenes();
                   contenidosResumidos.forEach(resumen -> System.out.println("- " + resumen.toString()));
               }
               case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Ingrese el título de la película a eliminar: ");
                    Contenido contenidoAEliminar = plataforma.buscarPorTitulo(nombreAEliminar);
                    if(contenidoAEliminar != null) {
                         plataforma.eliminar(contenidoAEliminar);
                         System.out.println("La película '" + nombreAEliminar + "' ha sido eliminada.");
                    } else {
                         System.out.println("La película con título '" + nombreAEliminar + "' no fue encontrada.");
                    }
               }
               case BUSCAR_POR_GENERO -> {
                   Genero generoBuscado = ScannerUtils.capturarGenero("Ingrese el género a buscar");
                   List<Contenido> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                   System.out.println(contenidoPorGenero.size() + " películas encontradas del género '" + generoBuscado + "':");
                   contenidoPorGenero.forEach(pelicula -> System.out.println("- " + pelicula.getTitulo()));

                   }
                case SALIR -> System.exit(0);

               case VER_POPULARES -> {
                   List<Contenido> peliculasPopulares = plataforma.getPopulares(2);
                   peliculasPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));

               }

               case REPRODUCIR -> {
                   String nombre = ScannerUtils.capturarTexto("Ingrese el título de la película a reproducir: ");
                   Contenido contenidoAReproducir = plataforma.buscarPorTitulo(nombre);
                   if(contenidoAReproducir != null) {
                       plataforma.reproducir(contenidoAReproducir);
                       System.out.println("Reproduciendo la película '" + contenidoAReproducir.getTitulo() + "'. Disfrútala!");
                   } else {
                       System.out.println("La película con título '" + nombre + "' no fue encontrada.");
                   }
               }

               case 9 -> {
                   int tipoBuscado = ScannerUtils.capturarEntero("Ingrese el tipo de contenido a buscar (Pelicula/Documental): ");
                   if(tipoBuscado == 1) {
                       List<Pelicula> peliculas = plataforma.getPeliculas();
                       System.out.println("Películas encontradas:");
                       peliculas.forEach(pelicula -> System.out.println("- " + pelicula.getTitulo()));
                   } else if(tipoBuscado == 2) {
                       List<Documental> documentales = plataforma.getDocumentales();
                       System.out.println("Documentales encontrados:");
                       documentales.forEach(documental -> System.out.println("- " + documental.getTitulo()));
                   } else {
                       System.out.println("Tipo de contenido inválido.");
                   }
               }
           }

//           if(opcionElegida == AGREGAR) {
//               String titulo = ScannerUtils.capturarTexto("Título de la película: ");
//               String genero = ScannerUtils.capturarTexto("Género de la película: ");
//               int duracionMinutos = ScannerUtils.capturarEntero("Duración en minutos: ");
//
//               Contenido nuevaPelicula = new Contenido(
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
//               Contenido peliculaEncontrada = plataforma.buscarPorTitulo(nombreBuscado);
//               if(peliculaEncontrada != null) {
//                     System.out.println("Película encontrada:");
//                     System.out.println(peliculaEncontrada.obtenerFichaTecnica());
//                } else {
//                     System.out.println("La película con título '" + nombreBuscado + "' no fue encontrada.");
//               }
//           } else if(opcionElegida == ELIMINAR) {
//                String nombreAEliminar = ScannerUtils.capturarTexto("Ingrese el título de la película a eliminar: ");
//                Contenido peliculaAEliminar = plataforma.buscarPorTitulo(nombreAEliminar);
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
           plataforma.getContenio().addAll(FileUtils.leerContenido());

       }
}
