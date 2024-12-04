package unidad3;

public class GeneradorNombre {

	public static void main(String[] args) {

		String nombre = "";
		
		// ASCII chars mayus = 65 a 90
		
		int i = (int) ((Math.random()*7)+6);
		int repVoc = 0;
		int repCon = 0;
		int vocales = 0;
		char comp = ' ';
		
		while (i>0) {
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
				i--;
			}
		}
		
		for (int x = 0; x < i; x++) {
			comp = nombre.charAt(i);
			if (comp == 'A' || comp == 'E' || comp == 'I' || comp == 'O' || comp == 'U') {
				vocales ++;
			}
		}
		
		
		System.out.println("El nombre es " + nombre + ", y tiene " + vocales + " vocales");
		
	}

}
