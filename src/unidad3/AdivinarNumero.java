package unidad3;

import java.util.Scanner;

public class AdivinarNumero {

	public static void main(String[] args) {

		int numRandom = (int) (Math.random()*50+1);
		int numIntentos = 5;
		int num = 0; 
		boolean encontrado = false;
		
		Scanner teclado = new Scanner(System.in);
		
		for (int i=numIntentos; i!=0 && !encontrado; i--) {
			System.out.print("Intenta adivinar el número (" + i + "/5): ");
			num = teclado.nextInt();
			if (num == numRandom) {
				System.out.println("Has acertado!");
				// Una de las 2 siguientes opciones, o incluso poner break
				i = 1;
				encontrado = true;
			} else if (Math.abs(num-numRandom)<=2) {
				System.out.println("Caliente caliente");
			} else if (Math.abs(num-numRandom)>=20) {
				System.out.println("Frío frío"); 
			} else if (num>numRandom) {
				System.out.println("Baja");
			} else {
				System.out.println("Sube");
			}
		}		
		
		System.out.println("Cambio para merge 1");
		
		System.out.println("Adiós");
		
		teclado.close();
	}

}
