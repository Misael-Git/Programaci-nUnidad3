package ejercicios;

import java.util.Scanner;

public class NumeroCratico {
	
    public static void main(String[] args) {
    	
        // Guardo el número como String
    	String numero = "";
        boolean cratico = true;
        boolean perfecto = true;
    	
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        numero = teclado.nextLine();

        for (int i = 0; i < numero.length(); i++) {
            char actual = numero.charAt(i);

            // Comparar si se repite desde el siguiente número
            for (int j = i + 1; j < numero.length(); j++) {
                if (actual == numero.charAt(j)) {
                    cratico = false;
                    break;
                }
            }

            // Comprobar si no está en la última posición,
            // y si es menor que el siguiente
            if (i < numero.length() - 1 && actual > numero.charAt(i + 1)) {
                perfecto = false;
            }
        }

        if (cratico && perfecto) { System.out.println(numero + " es cratico perfecto"); }
        else if (cratico) { System.out.println(numero + " es cratico"); }
        else { System.out.println(numero + " no es cratico"); }
        
        teclado.close();
    }
}
