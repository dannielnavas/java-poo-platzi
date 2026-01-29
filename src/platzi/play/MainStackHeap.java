package platzi.play;

import platzi.play.contenido.Pelicula;

import java.time.LocalDate;

public class MainStackHeap {
     public static void main(String[] args) {
         Pelicula inception = new Pelicula(
                    "Inception",
                    "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                    148,
                    "Science Fiction",
                    LocalDate.now()
         );

         Pelicula interstellar = new Pelicula(
                    "Interstellar",
                    "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                    169,
                    "Science Fiction",
                    LocalDate.now()
         );

         inception = interstellar;

         System.out.println("Inception Title: " + inception.getTitulo());
         System.out.println("Interstellar Title: " + interstellar.getTitulo());
    }
}
