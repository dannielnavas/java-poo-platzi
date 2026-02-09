package platzi.play.plataforma;

import platzi.play.contenido.Contenido;

import java.time.LocalDateTime;

public class Usuario {
    public String nombre;
    public String email;
    public String contrasena;
    public int edad;
    public boolean suscripcionActiva;
    public LocalDateTime fechaRegistro;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = LocalDateTime.now();
    }

    public void ver(Contenido contenido){
        System.out.println("El usuario " + nombre + " está viendo la película: " );
        contenido.reproducir();
    }
}
