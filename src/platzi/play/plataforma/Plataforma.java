package platzi.play.plataforma;

import platzi.play.contenido.Genero;
import platzi.play.contenido.Pelicula;
import platzi.play.contenido.ResumenCotenido;
import platzi.play.excepcion.PeliculaExistenteExcetion;

import java.util.*;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido;
    private Map<Pelicula, Integer> visualizaciones;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agreagar(Pelicula pelicula) {
        Pelicula contenido = this.buscarPorTitulo(pelicula.getTitulo());
        if(contenido != null){
            throw new PeliculaExistenteExcetion(contenido.getTitulo());
        }
        this.contenido.add(pelicula);
    }

    public void reproducir(Pelicula pelicula) {
        int conteoActual = visualizaciones.getOrDefault(pelicula, 0);
        System.out.println("Reproduciendo " + pelicula.getTitulo() + ". Visualizaciones actuales: " + conteoActual);
        contarVisualizacion(pelicula);
        pelicula.reproducir();

    }

    private void contarVisualizacion(Pelicula contenido) {
        visualizaciones.put(contenido, visualizaciones.getOrDefault(contenido, 0) + 1);
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

    public List<Pelicula> buscarPorGenero(Genero genero) {
        return contenido.stream().filter(pelicula -> pelicula.getGenero().equals(genero)).toList();
            }
    public int getDuracionTotal() {
        return contenido.stream().mapToInt(Pelicula::getDuracion).sum();
    }

    public List<Pelicula> getPopulares(int cantidad) {

        return contenido.stream().sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed()).limit(cantidad).toList();
    }

    public List<ResumenCotenido> getResumenes() {
        return contenido.stream().map(contenido -> new ResumenCotenido(contenido.getTitulo(), contenido.getDuracion(), contenido.getGenero())).toList();
    }
}
