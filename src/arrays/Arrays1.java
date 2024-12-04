package arrays;

public class Arrays1 {

	public static void main(String[] args) {

		double listaAltura[] = {200,185,190,230,170,10,201,234,780,180};
		String listaNombres[];
		// Cantidad jugadores
		int cantidadJugadores = 10;
		
		
// Generador alturas entre 150 y 230
		
		for (int i = 0; i < listaAltura.length; i++) {
			listaAltura[i] = (double)((int)(Math.random()*8000))/100 + 150;
		}
		
		//Para definir el tamaño de un array usamos new
		//el tipo de dato y las posiciones que va a tener
		listaNombres = new String[cantidadJugadores];
		
		// Se puede definir así:
		listaNombres[9] = "Juanjo";
		
		
// Generador nombres
		
		for (int i = 0; i < listaAltura.length; i++) {
			String nombre = "";

			int numLetras = (int) ((Math.random()*6)+4);
			int repVoc = 0;
			int repCon = 0;
		
			while (numLetras>0) {
				char c = (char) ((Math.random()*26)+65);
				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					repCon = 0;
					repVoc ++;
				} else {
					repVoc = 0;
					repCon ++;
				}
			
				if (repVoc > 2 || repCon > 2) {
					continue;
				} else {
					nombre += c;
					numLetras--;
				}
			}
			listaNombres[i] = nombre;
		}
				
		
// Media alturas y sysos de jugadores
		
		int i = 0;
		double mediaAlturas = 0;

		while (i<listaAltura.length) {
			mediaAlturas += listaAltura[i];
			System.out.println("El jugador " + (i+1) + " es " + listaNombres[i] +
					", y su altura es " + listaAltura[i] + " cm.");
			i++;
		}
		
		mediaAlturas /= listaAltura.length; 
		
		// Con esto forzamos que solo haya 2 posiciones después de la coma:
		System.out.printf("La media (en cm) de las alturas es %.2f ", mediaAlturas);
	}

}
