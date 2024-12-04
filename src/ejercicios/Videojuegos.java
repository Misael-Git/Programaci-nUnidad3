package ejercicios;

import java.util.Scanner;

public class Videojuegos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Desea ingresar los datos manualmente o usar datos automáticos?");
        System.out.println("1. Manual");
        System.out.println("2. Automático");
        System.out.print("Elija una opción (1/2): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        String[] nombres;
        int[] puntuaciones;
        double[] precios;
        String[] companias;

        if (opcion == 2) {
            // Datos automáticos
            nombres = new String[]{
                "Mario Kart", "Zelda", "Metroid", "FIFA 23", "Call of Duty",
                "Animal Crossing", "Minecraft", "Fortnite", "Among Us", "Splatoon"
            };
            puntuaciones = new int[]{9, 10, 8, 7, 8, 9, 10, 6, 7, 8};
            precios = new double[]{12.5, 60.0, 14.99, 45.0, 59.99, 13.0, 30.0, 0.0, 5.0, 14.5};
            companias = new String[]{
                "Nintendo", "Nintendo", "Nintendo", "EA Sports", "Activision",
                "Nintendo", "Mojang", "Epic Games", "Innersloth", "Nintendo"
            };
        } else {
            // Datos ingresados manualmente
            System.out.print("Ingrese el número de videojuegos: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            nombres = new String[n];
            puntuaciones = new int[n];
            precios = new double[n];
            companias = new String[n];

            for (int i = 0; i < n; i++) {
                System.out.println("Datos del videojuego " + (i + 1) + ":");
                System.out.print("Nombre: ");
                nombres[i] = scanner.nextLine();
                System.out.print("Puntuación: ");
                puntuaciones[i] = scanner.nextInt();
                System.out.print("Precio: ");
                precios[i] = scanner.nextDouble();
                scanner.nextLine(); // Consumir salto de línea
                System.out.print("Compañía: ");
                companias[i] = scanner.nextLine();
            }
        }

        // Calcular la media de los precios
        int n = nombres.length;
        double sumaPrecios = 0;
        for (double precio : precios) {
            sumaPrecios += precio;
        }
        double mediaPrecios = sumaPrecios / n;

        // Encontrar puntuación máxima y mínima
        int maxPuntuacion = puntuaciones[0];
        String juegoMaxPuntuacion = nombres[0];
        int minPuntuacion = puntuaciones[0];
        String juegoMinPuntuacion = nombres[0];
        for (int i = 1; i < n; i++) {
            if (puntuaciones[i] > maxPuntuacion) {
                maxPuntuacion = puntuaciones[i];
                juegoMaxPuntuacion = nombres[i];
            }
            if (puntuaciones[i] < minPuntuacion) {
                minPuntuacion = puntuaciones[i];
                juegoMinPuntuacion = nombres[i];
            }
        }

        // Contar la cantidad de juegos por compañía
        String[] companiasUnicas = new String[n];
        int[] contadorCompanias = new int[n];
        int totalCompanias = 0;

        for (int i = 0; i < n; i++) {
            boolean encontrada = false;
            for (int j = 0; j < totalCompanias; j++) {
                if (companias[i].equalsIgnoreCase(companiasUnicas[j])) {
                    contadorCompanias[j]++;
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                companiasUnicas[totalCompanias] = companias[i];
                contadorCompanias[totalCompanias] = 1;
                totalCompanias++;
            }
        }

        // Juegos de Nintendo que cuestan menos de 15 euros y cumplen las condiciones
        String[] juegosNintendo = new String[n];
        int totalJuegosNintendo = 0;
        for (int i = 0; i < n; i++) {
            if (companias[i].equalsIgnoreCase("Nintendo") && precios[i] < 15 &&
                    (nombres[i].startsWith("M") || puntuaciones[i] > 8)) {
                juegosNintendo[totalJuegosNintendo] = nombres[i];
                totalJuegosNintendo++;
            }
        }

        // Mostrar resultados
        System.out.println("\nResultados:");
        System.out.println("Media de los precios: " + mediaPrecios);
        System.out.println("Puntuación máxima: " + maxPuntuacion + " (" + juegoMaxPuntuacion + ")");
        System.out.println("Puntuación mínima: " + minPuntuacion + " (" + juegoMinPuntuacion + ")");
        System.out.println("Cantidad de juegos por compañía:");
        for (int i = 0; i < totalCompanias; i++) {
            System.out.println(companiasUnicas[i] + ": " + contadorCompanias[i]);
        }
        System.out.println("Juegos de Nintendo que cuestan menos de 15 euros y cumplen las condiciones:");
        for (int i = 0; i < totalJuegosNintendo; i++) {
            System.out.println(juegosNintendo[i]);
        }

        scanner.close();
    }
}
