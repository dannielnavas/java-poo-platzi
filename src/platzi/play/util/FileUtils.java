package platzi.play.util;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Documental;
import platzi.play.contenido.Genero;
import platzi.play.contenido.Pelicula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String FILE_NAME = "contenido.txt";
    public static final String SEPARADOR = "|";

    public static void escribirContenido(Contenido contenido) {
        String linea = String.join(SEPARADOR,
                contenido.getTitulo(),
                String.valueOf(contenido.getDuracion()),
                contenido.getGenero().name(),
                String.valueOf(contenido.getCalificacion()),
                contenido.getFechaEstreno().toString());

        String lineaFinal;

        if(contenido instanceof Documental documental) {
            lineaFinal = "DOCUMENTAL" + SEPARADOR + linea + SEPARADOR + documental.getNarrador();
        } else {
            lineaFinal = "PELICULA" + SEPARADOR + linea;
        }

        try {
            Files.writeString(Paths.get(FILE_NAME), lineaFinal + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de contenidos: " + e.getMessage());
        }
    }


    public static List<Contenido> leerContenido() {
        List<Contenido> contenidoDesdeArchivo = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            lines.forEach(line -> {
                String[] datos = line.split("\\"+SEPARADOR);

                String tipo = datos[0].trim();
                if("PELICULA".equals(tipo) && datos.length == 6 || "DOCUMENTAL".equals(tipo) && datos.length == 7) {
                    String titulo = datos[1].trim();
                    int duracion = Integer.parseInt(datos[2].trim());
                    Genero genero = Genero.valueOf(datos[3].trim().toUpperCase());
                    double calificacion = datos[4].isBlank() ? 0 : Double.parseDouble(datos[4].trim());
                    LocalDate fechaEstreno = LocalDate.parse(datos[5].trim());
                    Contenido contenido;
                    if("PELICULA".equals(tipo)) {
                        contenido = new Pelicula(titulo, "", duracion, genero, calificacion, fechaEstreno, true);
                    } else {
                        String narrador = datos[6].trim();
                        contenido = new Documental(titulo, "", duracion, genero, calificacion, fechaEstreno, true, narrador);
                    }
                    contenidoDesdeArchivo.add(contenido);
                }
            });
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de contenidos: " + e.getMessage());
        }

        return  contenidoDesdeArchivo;
    }

}
