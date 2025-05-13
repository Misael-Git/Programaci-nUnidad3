package ejercicios;

import java.util.Scanner;

public class DivisoresImpares {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int num = teclado.nextInt();
        
        System.out.print("Divisores impares: ");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
            	if (num == i) {
            		System.out.print(" y ");
            	} else if (i != 1 && num != i) {
            		System.out.print(", ");
            	}
                System.out.print(i);
            }
        }
        teclado.close();
	} // ACTU 2
 
}
