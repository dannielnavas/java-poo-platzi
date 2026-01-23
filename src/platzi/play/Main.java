package platzi.play;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo desde mi primer proyecto en Java");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa tu nombre:");
        String nombre = scanner.nextLine();
        System.out.println("¡Hola, " + nombre + "! Bienvenido a Platzi Play.");
        scanner.close();
    }
}
