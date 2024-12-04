package ejercicios;

import java.util.Scanner;

public class PrimosYDivisores {

	public static void main(String[] args) {
		
		int cantidad = 0;
        int divsPrimNum = 0;
        int numPrimos = 0;
        int suma = 0;
		Scanner teclado = new Scanner(System.in);
		
        System.out.print("Números a ingresar: ");
        cantidad = teclado.nextInt();

        int numeros[] = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce el número (" + (i+1) + "/" + cantidad + "): ");
        	numeros[i] = teclado.nextInt();
        	
        	for (int div = 1; div <= numeros[i]; div++) {
				if (numeros[i] % div == 0) {
					suma++;
				}
			}
        	
        	if (i == 0) { divsPrimNum = suma; } // Divisores del primer número
			if (suma <= 2) { numPrimos++; } // Cantidad de primos
			
			suma = 0;
        }

        System.out.println("Hay " + numPrimos + " números primos, y el primer número tiene "
        + divsPrimNum + " divisores");
        
        teclado.close();
    }
}