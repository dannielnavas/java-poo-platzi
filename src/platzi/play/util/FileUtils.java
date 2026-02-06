package platzi.play.util;

import platzi.play.contenido.Genero;
import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String FILE_NAME = "contenido.txt";
    public static final String SEPARADOR = "\\|";

    public static List<Pelicula> leerContenido() {
        List<Pelicula> contenidoDesdeArchivo = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            lines.forEach(line -> {
                String[] datos = line.split(SEPARADOR);
                if(datos.length == 5) {
                    String titulo = datos[0].trim();
                    int duracion = Integer.parseInt(datos[1].trim());
                    Genero genero = Genero.valueOf(datos[2].trim().toUpperCase());
                    double calificacion = datos[3].isBlank() ? 0 : Double.parseDouble(datos[3].trim());
                    LocalDate fechaEstreno = LocalDate.parse(datos[4].trim());
                    Pelicula pelicula = new Pelicula(
                            titulo,
                            "",
                            duracion,
                            genero,
                            calificacion,
                            fechaEstreno,
                            true
                    );
                    contenidoDesdeArchivo.add(pelicula);
                }
            });
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de contenidos: " + e.getMessage());
        }

        return  contenidoDesdeArchivo;
    }

}
