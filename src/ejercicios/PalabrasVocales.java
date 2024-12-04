package ejercicios;

import java.util.Scanner;

public class PalabrasVocales {

    public static void main(String[] args) {

        int palabrasVocal = 0;
        int totalPalabras = 0;
        Scanner teclado = new Scanner(System.in);
        String cadena = "";
        int inicioPalabra = -1;

        System.out.print("Introduce una frase: ");
        cadena = teclado.nextLine();
        System.out.println("Palabras que empiezan o terminan en vocal invertidas:");

        for (int i = 0; i <= cadena.length(); i++) {
            if (i == cadena.length() || cadena.charAt(i) == ' ') {
                if (inicioPalabra != -1) {
                    totalPalabras++;
                    char primeraLetra = Character.toLowerCase(cadena.charAt(inicioPalabra));
                    char ultimaLetra = Character.toLowerCase(cadena.charAt(i - 1));
                    
                    if ("aeiou".indexOf(primeraLetra) >= 0 || "aeiou".indexOf(ultimaLetra) >= 0) {
                        palabrasVocal++;

                        for (int j = i - 1; j >= inicioPalabra; j--) {
                            System.out.print(cadena.charAt(j));
                        }
                        System.out.println();
                    }
                    inicioPalabra = -1; // Reiniciar palabra
                }
            } else if (inicioPalabra == -1) {
                inicioPalabra = i; // Nueva palabra
            }
        }
        	System.out.println("Hay " + totalPalabras + " palabras en total, de las cuales "
                + palabrasVocal + " empiezan o terminan por vocal");

        teclado.close();
    }
}

