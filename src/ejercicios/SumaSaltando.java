package ejercicios;

import java.util.Scanner;

public class SumaSaltando {

	public static void main(String[] args) {

		int n = 0;
		int d = 0;
		int suma = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce el primer número (n): ");
		n = teclado.nextInt();
		System.out.print("Introduce el segundo número (d): ");
		d = teclado.nextInt();
		
		for (int i = 0; i < n; i++) {
			if (i%d == 0) {
				suma += i;
			}
		}
		
		System.out.println("La suma es " + suma);
		
		teclado.close();	
	}

}
