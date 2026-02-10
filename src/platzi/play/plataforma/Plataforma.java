package platzi.play.plataforma;

import platzi.play.contenido.*;
import platzi.play.excepcion.PeliculaExistenteExcetion;
import platzi.play.util.FileUtils;

import java.util.*;

public class Plataforma {
    private String nombre;
    private List<Contenido> contenido;
    private Map<Contenido, Integer> visualizaciones;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agreagar(Contenido pelicula) {
        Contenido contenido = this.buscarPorTitulo(pelicula.getTitulo());
        if(contenido != null){
            throw new PeliculaExistenteExcetion(contenido.getTitulo());
        }
        FileUtils.escribirContenido(pelicula);

        this.contenido.add(pelicula);
    }

    public void reproducir(Contenido contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        System.out.println("Reproduciendo " + contenido.getTitulo() + ". Visualizaciones actuales: " + conteoActual);
        contarVisualizacion(contenido);
        contenido.reproducir();

    }

    private void contarVisualizacion(Contenido contenido) {
        visualizaciones.put(contenido, visualizaciones.getOrDefault(contenido, 0) + 1);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Contenido> getContenio() {
        return contenido;
    }

    public List<String> getTitulos() {
//        for (Contenido pelicula : contenio) {
//            System.out.println(pelicula.getTitulo());
//        }

//        contenido.forEach(pelicula -> System.out.println(pelicula.getTitulo()));
       return contenido.stream().map(Contenido::getTitulo).toList();
    }

    public void eliminar(Contenido contenido) {
        this.contenido.remove(contenido);
    }

    public Contenido buscarPorTitulo(String titulo) {
//        for (Contenido pelicula : contenio) {
//            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
//                return pelicula;
//            }
//        }
//        return null;
      return  this.contenido.stream().filter(pelicula -> pelicula.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
    }

    public List<Contenido> buscarPorGenero(Genero genero) {
        return contenido.stream().filter(pelicula -> pelicula.getGenero().equals(genero)).toList();
            }
    public int getDuracionTotal() {
        return contenido.stream().mapToInt(Contenido::getDuracion).sum();
    }

    public List<Contenido> getPopulares(int cantidad) {

        return contenido.stream().sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed()).limit(cantidad).toList();
    }

    public List<ResumenCotenido> getResumenes() {
        return contenido.stream().map(contenido -> new ResumenCotenido(contenido.getTitulo(), contenido.getDuracion(), contenido.getGenero())).toList();
    }

    public List<Pelicula> getPeliculas() {
        return contenido.stream().filter(contendio -> contendio instanceof Pelicula).map(contenidoFiltrado -> (Pelicula) contenidoFiltrado).toList();
    }

    public List<Documental> getDocumentales() {
        return contenido.stream().filter(contendio -> contendio instanceof Documental).map(contenidoFiltrado -> (Documental) contenidoFiltrado).toList();
    }

    public List<Promocionables> getPromocionables() {
        return contenido.stream().filter(contendio -> contendio instanceof Promocionables).map(contenidoFiltrado -> (Promocionables) contenidoFiltrado).toList();
    }
}
