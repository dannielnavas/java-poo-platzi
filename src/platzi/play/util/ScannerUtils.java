package platzi.play.util;

import platzi.play.contenido.Genero;

import java.util.Locale;
import java.util.Scanner;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String capturarTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return SCANNER.nextLine();
    }

    public static int capturarEntero(String mensaje) {
        System.out.println(mensaje + ": ");
        while (!SCANNER.hasNextInt()) {
            System.out.println("Por favor ingrese una opcion válida.");
            SCANNER.next(); // Limpiar la entrada inválida
        }
        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;
    }

    public static int capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        while (!SCANNER.hasNextDouble()) {
            System.out.println("Por favor ingrese una opcion válida.");
            SCANNER.next(); // Limpiar la entrada inválida
        }
        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return (int) dato;
    }

    public static  Genero capturarGenero(String mensaje) {
        while(true) {
            String input = capturarTexto(mensaje);
            try {
                return Genero.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Género inválido. Por favor ingrese un género válido.");
            }
        }
    }
}
