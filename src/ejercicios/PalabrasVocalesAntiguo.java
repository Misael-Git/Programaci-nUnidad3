package ejercicios;

import java.util.Scanner;

public class PalabrasVocalesAntiguo {

    public static void main(String[] args) {
        
        int palabrasVocal = 0;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una cadena:");
        String cadena = teclado.nextLine();
        
        // Dividimos la cadena en varias palabras con split \\s+
        String[] palabras = cadena.split("\\s+");
        int totalPalabras = palabras.length;
        
        System.out.println("Palabras que empiezan o terminan en vocal invertidas:");
        for (String palabra : palabras) {
            if (palabra.matches("^[aeiouAEIOU].*") || palabra.matches(".*[aeiouAEIOU]$")) {
                palabrasVocal++;
                // Invertimos la palabra
                StringBuilder palabraInvertida = new StringBuilder();
                for (int i = palabra.length() - 1; i >= 0; i--) {
                    palabraInvertida.append(palabra.charAt(i));
                }
                System.out.println(palabraInvertida.toString());
            }
        }
        
        System.out.println("Hay " + totalPalabras + " palabras en total, de las cuales "
        + palabrasVocal + " empiezan o terminan por vocal");
        
        teclado.close();
    }
}

