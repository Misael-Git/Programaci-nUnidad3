package unidad3;

import java.util.Scanner;

public class Factoriales {

	public static void main(String[] args) {

		int factorial = 0;
		double num = 1;
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número para calcular su factorial: ");
		factorial = teclado.nextInt();
		
		for (int i = 1; i <= factorial; i++) {
			num *= i;
		}
		
		System.out.println("El factorial de " + factorial + " es " + num);
	}

}
