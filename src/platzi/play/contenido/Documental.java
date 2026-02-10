package platzi.play.contenido;

import java.time.LocalDate;
    public class Documental extends Contenido{
        private String narrador;

        public Documental(String titulo, String descripcion, int duracion, Genero genero, LocalDate fechaEstreno) {
        super(titulo, descripcion, duracion, genero, fechaEstreno);
    }

        @Override
        public void reproducir() {
            System.out.println("Reproduciendo documental: " + getTitulo() + " narrado por " + narrador);
        }

        public Documental(String titulo, String descripcion, int duracion, Genero genero, double calificacion, LocalDate fechaEstreno, boolean disponible, String narrador) {
        super(titulo, descripcion, duracion, genero, calificacion, fechaEstreno, disponible);
        this.narrador = narrador;
    }

        public String getNarrador() {
            return narrador;
        }
    }
