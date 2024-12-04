package arrays;

public class Ejercicio {

	public static void main(String[] args) {

		// Creamos un array de 10 números
		int listaNumeros[] = new int[10];
		
		for (int i = 0; i < listaNumeros.length; i++) {
			listaNumeros[i] = (int) (Math.random() * 10 + 1);
			System.out.println("El número " + (i+1) + " es " + listaNumeros[i]);
		}
		
		// Sacar el máximo y el mínimo
		
		int MaxNum = Integer.MIN_VALUE;
		int MinNum = Integer.MAX_VALUE;
		
		for (int i = 0; i < listaNumeros.length; i++) {
			if (listaNumeros[i] > MaxNum)
				MaxNum = listaNumeros[i];
			if (listaNumeros[i] < MinNum)
				MinNum = listaNumeros[i];
			
			int numABuscar = listaNumeros[i];
			int cantRep = 0;
			
			for (int j = 0; j < listaNumeros.length; j++) {
				if (numABuscar == listaNumeros[j]) {
					cantRep++;
				}
			}
			
			if (cantRep > 1) {
				System.out.println("El número " + listaNumeros[i] + " se reptite "
			+ (cantRep-1) + " veces"); 
			}
		}
		
		System.out.println("El máximo es " + MaxNum + " el mínimo es " + MinNum);
		
	}

}
