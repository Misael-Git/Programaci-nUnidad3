package ejercicios;

import java.util.Scanner;

public class HundirLaFlotaManual {

	public static void main(String[] args) {

		char tablero[][] =  {
	            {'-', '-', '-', '-', '-', '-', '-', '-'},
	            {'-', 'b', '-', 'b', 'b', 'b', '-', '-'},
	            {'-', 'b', '-', '-', '-', '-', '-', '-'},
	            {'-', 'b', '-', '-', '-', '-', '-', '-'},
	            {'-', 'b', '-', 'b', 'b', 'b', 'b', 'b'},
	            {'-', '-', '-', '-', '-', '-', '-', '-'},
	            {'b', 'b', 'b', '-', '-', '-', '-', '-'},
	            {'-', '-', '-', '-', '-', '-', 'b', 'b'}
	        };
		
		Scanner teclado = new Scanner(System.in);
		String jugada = "";
		int contadorX = 0;
		int contadorY = 0;
		int tempX = 0;
		int tempY = 0;
		int barcos = 1;
		int barcosCount = 0;
		int crear = 0;
					
        do {
        	System.out.print("¿Crear tablero personalizado? (0/1): ");
    		crear = teclado.nextInt();
        } while (crear < 0 || crear > 1);
		
// CREACIÓN TABLERO
			
			if (crear == 1) {
				for (int i = 0; i < tablero.length; i++) {
					for (int j = 0; j < tablero.length; j++) {
						
				        System.out.println("Introduce el tablero (8x8) fila por fila usando 'b' para barco y 'n' para nada (agua):");
				        System.out.println("       **Hay un barco de 5, uno de 4, dos de 3 y uno de 2**");
						
						for (int x = 0; x < tablero.length; x++) {
							tablero[i][j]='/';
							for (int y = 0; y < tablero[x].length; y++)
								System.out.print(tablero[x][y] + " ");
							System.out.println("");
						}
						
						jugada = teclado.next();
								
						if (jugada.equalsIgnoreCase("b"))
							tablero[i][j]='b';
						
						if (jugada.equalsIgnoreCase("n"))
							tablero[i][j]='-';	
					}
				}
			}
		
// COMPROBACIONES
			
			for (int y = 0; y < 8; y++) {
				
				for (int x = 0; x < 8; x++) {
					
					// FILAS
					if (tablero[y][x] == 'b') {
						contadorX++;
						tempX = 3;
					}
					tempX--;
					
					// COLUMNAS
					if (tablero[x][y] == 'b') {
						contadorY++;
						tempY = 3;
					}
					tempY--;
					
					// ESQUINAS O SUPERPOSICIÓN
					if (tablero[y][x] == 'b') {
					    if (y + 1 < tablero.length && x + 1 < tablero[0].length && tablero[y + 1][x + 1] == 'b') {
					        System.out.println("Error: Barcos superpuestos o tocando esquinas");
					        break;
					    }
					    if (y + 1 < tablero.length && x - 1 >= 0 && tablero[y + 1][x - 1] == 'b') {
					        System.out.println("Error: Barcos superpuestos o tocando esquinas");
					        break;
					    }
					}
										
					// X
					if (tempX == 1) { // Si después de detectar algún barco detecta agua...
						tempX = 0;
						if (contadorX > 5) {
							System.out.println("Error: Barco muy grande"); break;
						} else {
							if (contadorX > 1) { // Si ese barco ocupa más de 1...
								barcos *= contadorX;
								barcosCount++;
								if (barcosCount > 5)
									System.out.println("Error: Demasiados barcos"); break;
							}
						}
						contadorX = 0;
					}
					
					// Y
					if (tempY == 1) { // Si después de detectar algún barco detecta agua...
						tempY = 0;
						if (contadorY > 1) { // Si ese barco ocupa más de 1...
							barcos *= contadorY;
							barcosCount++;
							if (barcosCount > 5)
								System.out.println("Error: Demasiados barcos"); break;
						}
					}
					contadorY = 0;
				}
			}
			
// COMPROBACIONES FINALES
			
			// Para que sean los barcos requeridos, y teniendo en cuenta que haya exactamente 5 barcos, 
			// solo habrá que comprobar que el resultado sea 360 (2 * 3 * 3 * 4 * 5),
			// pues no hay otra combinación posible para que salga eso con 5 números del 2 al 5
			
			if (barcosCount == 5 && barcos == 360) {
				System.out.println("Todo salió bien!!! Aquí está tu tablero");
				for (int x = 0; x < tablero.length; x++) {
					for (int y = 0; y < tablero[x].length; y++)
						System.out.print(tablero[x][y] + " ");
					System.out.println("");
				}
			}
			
			System.out.println("Hay " + barcosCount + " barcos, y multiplicados dan " + barcos);
				
		teclado.close();
	}

}
