package platzi.play.util;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Genero;

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



        try {
            Files.writeString(Paths.get(FILE_NAME), linea + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
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
                if(datos.length == 5) {
                    String titulo = datos[0].trim();
                    int duracion = Integer.parseInt(datos[1].trim());
                    Genero genero = Genero.valueOf(datos[2].trim().toUpperCase());
                    double calificacion = datos[3].isBlank() ? 0 : Double.parseDouble(datos[3].trim());
                    LocalDate fechaEstreno = LocalDate.parse(datos[4].trim());
                    Contenido contenido = new Contenido(
                            titulo,
                            "",
                            duracion,
                            genero,
                            calificacion,
                            fechaEstreno,
                            true
                    );
                    contenidoDesdeArchivo.add(contenido);
                }
            });
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de contenidos: " + e.getMessage());
        }

        return  contenidoDesdeArchivo;
    }

}
