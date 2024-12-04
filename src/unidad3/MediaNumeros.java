package unidad3;

import java.util.Scanner;

public class MediaNumeros {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int max = 0;
		int min = 1000000;
		float media = 0f;
		int i = 0;
		
		while (i < 10) {
			System.out.print("Introduce un número (" + (i+1) + "/10): ");
			int num = teclado.nextInt();
			media += num;
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
			i++;
		}
		
		media = media/10;
		
		System.out.println("La media es " + media + ", el mínimo es " + min + " y el máximo es " + max);
		teclado.close();
	}

}
