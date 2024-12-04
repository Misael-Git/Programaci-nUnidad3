package unidad3;

import java.util.Scanner;

public class EjemploBucles2 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int numTabla = 0;
		
		System.out.print("Introduce un número para hacer la tabla de multiplicar: ");
		numTabla = teclado.nextInt();
		
		for (int i=0; i<60; i++) {
			System.out.print("-");
		}
		
		System.out.println("");
		
		for (int i=0; i<10; i++) {
			System.out.println(numTabla + "x" + (i+1) + "=" + (i+1)*numTabla);
		}
		
	}

}
