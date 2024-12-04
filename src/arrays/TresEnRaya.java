package arrays;

import java.util.Scanner;

public class TresEnRaya {

	public static void main(String[] args) {

		char tablero[][] = {{'_', '_', '_',},
							{'_', '_', '_',},
							{'_', '_', '_',}};
		
		String ganador = "";
		int jugador = 1;
		Scanner teclado = new Scanner(System.in);
		String jugada = "";
		int contadorXX = 0;
		int contadorXY = 0;
		int contadorOX = 0;
		int contadorOY = 0;
		int jugadaPosX = 0;
		int jugadaPosY = 0;
		
		while (ganador.equals("")) {
			
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++)
					System.out.print(tablero[i][j] + " ");
				
				System.out.println("");
			}
			
// MOVIMIENTOS JUGADORES
			
			// Pregunto las cordenadas para las fichas X
			do {
				System.out.print("\nJugador " + jugador + ": posición a poner tu ficha (xy): ");
				jugada = teclado.next();
				// Normalmente se usa Integer.parseValue para pasar de String a Int
				jugadaPosX = -1 + (Character.getNumericValue(jugada.charAt(0)));
				jugadaPosY = -1 + (Character.getNumericValue(jugada.charAt(1)));
			} while ((jugadaPosY < 0 || jugadaPosY > 2 || jugadaPosX < 0 || jugadaPosX > 2)
					|| tablero[jugadaPosY][jugadaPosX] != '_');
						
			if (jugador == 1) {
				// Ponemos la ficha en su lugar
				tablero[jugadaPosY][jugadaPosX]='X';
				jugador = 2;
			} else {
				// Ponemos la ficha en su lugar
				tablero[jugadaPosY][jugadaPosX]='O';
				jugador = 1;
			}
			
// COMPROBACIONES
			for (int y = 0; y < 3; y++) {
				
				// FILAS
				for (int x = 0; x < 3; x++) {
					if (tablero[y][x] == 'X') {
						contadorXX++;
					}
					
					if (tablero[x][y] == 'X') {
						contadorXY++;
					}
					
					if (tablero[y][x] == 'O') {
						contadorOX++;
					}
					
					if (tablero[x][y] == 'O') {
						contadorOY++;
					}
				}
				
				if (contadorXX == 3 || contadorXY == 3) {
					ganador = "Jugador X";
					break;
				} else if (contadorOX == 3 || contadorOY == 3) {
					ganador = "Jugador O";
					break;
				}
				
				contadorXX = 0;
				contadorXY = 0;
				contadorOX = 0;
				contadorOY = 0;
				
				if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X') {
					ganador = "Jugador X";
					break;
				} else if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X') {
					ganador = "Jugador X";
					break;
				} else if (tablero[0][0] == 'O' && tablero[1][1] == 'X' && tablero[2][2] == 'X') {
					ganador = "Jugador O";
					break;
				} else if (tablero[0][2] == 'O' && tablero[1][1] == 'X' && tablero[2][0] == 'X') {
					ganador = "Jugador O";
					break;
				}
				
			}
		}
		
		System.out.println("\nHa ganado el " + ganador);
		System.out.println("");
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++)
				System.out.print(tablero[i][j] + " ");
			
			System.out.println("");
		}
				
		teclado.close();
	}

}
