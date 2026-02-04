package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agreagar(Pelicula pelicula) {
        this.contenido.add(pelicula);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenio() {
        return contenido;
    }

    public List<String> getTitulos() {
//        for (Pelicula pelicula : contenio) {
//            System.out.println(pelicula.getTitulo());
//        }

//        contenido.forEach(pelicula -> System.out.println(pelicula.getTitulo()));
       return contenido.stream().map(Pelicula::getTitulo).toList();
    }

    public void eliminar(Pelicula pelicula) {
        this.contenido.remove(pelicula);
    }

    public Pelicula buscarPorTitulo(String titulo) {
//        for (Pelicula pelicula : contenio) {
//            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
//                return pelicula;
//            }
//        }
//        return null;
      return  this.contenido.stream().filter(pelicula -> pelicula.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return contenido.stream().filter(pelicula -> pelicula.getGenero().equalsIgnoreCase(genero)).toList();
            }
    public int getDuracionTotal() {
        return contenido.stream().mapToInt(Pelicula::getDuracion).sum();
    }

    public List<Pelicula> getPopulares(int cantidad) {

        return contenido.stream().sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed()).limit(cantidad).toList();
    }
}
