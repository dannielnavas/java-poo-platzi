package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    public String nombre;
    public String email;
    public String contrasena;
    public int edad;
    public boolean suscripcionActiva;
    public LocalDateTime fechaRegistro;

    public void ver(Pelicula pelicula){
        System.out.println("El usuario " + nombre + " está viendo la película: " );
        pelicula.reproducir();
    }
}
