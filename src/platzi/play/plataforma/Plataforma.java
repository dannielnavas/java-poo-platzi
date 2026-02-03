package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenio;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenio = new ArrayList<>();
    }

    public void agreagar(Pelicula pelicula) {
        this.contenio.add(pelicula);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenio() {
        return contenio;
    }

    public void mostrarTitulos() {
        for (Pelicula pelicula : contenio) {
            System.out.println(pelicula.getTitulo());
        }
    }

    public void eliminar(Pelicula pelicula) {
        this.contenio.remove(pelicula);
    }

    public Pelicula buscarPorTitulo(String titulo) {
        for (Pelicula pelicula : contenio) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }
}
