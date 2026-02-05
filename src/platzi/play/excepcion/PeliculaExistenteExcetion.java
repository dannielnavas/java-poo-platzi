package platzi.play.excepcion;

public class PeliculaExistenteExcetion extends  RuntimeException {
    public PeliculaExistenteExcetion(String titulo) {
        super("La película con el título '" + titulo + "' ya existe en la plataforma.");
    }
}
