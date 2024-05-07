
import salesianos.com.diccionario.Dictionary;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your personal dictionary!");

        while (true) {
            mostrarMenu();
            System.out.print("Choose an option: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("");
                    String palabraAgregar = scanner.nextLine();
                    System.out.println(dictionary.agregarPalabra(palabraAgregar));
                    break;
                case "2":
                    System.out.print("Introduzca la palabra a eliminar: ");
                    String palabraEliminar = scanner.nextLine();
                    System.out.println(dictionary.eliminarPalabra(palabraEliminar));
                    break;
                case "3":
                    System.out.print("Introduzca la palabra a buscar: ");
                    String palabraBuscar = scanner.nextLine();
                    if (dictionary.existePalabra(palabraBuscar)) {
                        System.out.println("La palabra está en el diccionario.");
                    } else {
                        System.out.println("La palabra no está en el diccionario.");
                    }
                    break;
                case "4":
                    System.out.println("Iniciales disponibles: " + dictionary.inicialesDisponibles());
                    break;
                case "5":
                    System.out.print("Introduzca la inicial para ver las palabras: ");
                    char inicial = scanner.nextLine().charAt(0);
                    Set<String> palabras = dictionary.palabrasPorInicial(inicial);
                    System.out.println("Words starts with '" + inicial + "': " + palabras);
                    break;
                case "6":
                    System.out.println("¡Byeee!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Incorrect option. Please try again.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Add word");
        System.out.println("2. Delete word");
        System.out.println("3. Check if word exists");
        System.out.println("4. Show available initials");
        System.out.println("5. Show words by initial");
        System.out.println("6. Close program");
    }
}
