package platzi.play;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Platzi Play - Tu plataforma de entretenimiento favorita");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa tu nombre:");
        String nombre = scanner.nextLine();
        System.out.println("¡Hola, " + nombre + "! Bienvenido a Platzi Play.");
        System.out.println(nombre + ", Cuantos años tienes?");
        int edad = scanner.nextInt();
        System.out.println(nombre +", puedes ver contenido +"+ edad);
        scanner.close();
    }
}
