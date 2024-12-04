package ejercicios;

import java.util.Scanner;

public class HundirLaFlota {

    public static void main(String[] args) {

        char tablero[][] = {
            {'-', '-', '-', 'b', 'b', 'b', 'b', '-'},
            {'-', 'b', '-', '-', '-', '-', '-', '-'},
            {'-', 'b', '-', '-', '-', '-', '-', '-'},
            {'-', 'b', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', 'b', 'b', 'b', 'b', 'b'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'b', 'b', 'b', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', 'b', 'b'}
        };
        int barcos = 1;
        int barcosCount = 0;
        Scanner teclado = new Scanner(System.in);
        int crear;
        
        do {
            System.out.print("¿Crear tablero personalizado? (0/1): ");
            crear = teclado.nextInt();
        } while (crear < 0 || crear > 1);

        // CREACIÓN TABLERO
        if (crear == 1) {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.println("Introduce 'b' para barco o 'n' para agua en posición [" + i + "][" + j + "]:");
                    
                    for (int x = 0; x < tablero.length; x++) {
						tablero[i][j]='/';
						for (int y = 0; y < tablero[x].length; y++)
							System.out.print(tablero[x][y] + " ");
						System.out.println("");
					}
                    
                    String jugada = teclado.next();
                    if (jugada.equalsIgnoreCase("b")) {
                        tablero[i][j] = 'b';
                    } else {
                        tablero[i][j] = '-';
                    }
                    
                }
            }
        }

        // COMPROBACIONES
        boolean[][] procesado = new boolean[8][8]; 
        // Procesado es un mapa paralelo al original, en el que cada casilla almacena la información
        // de si ha sido procesado. Sirve para marcar qué partes del tablero ya hemos revisado,
        // así no volvemos a mirar el mismo barco más de una vez

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (tablero[y][x] == 'b' && !procesado[y][x]) { // Si es barco y no lo ha procesado aún
                    int tamañoBarco = 1;
                    boolean horizontal = false, vertical = false;

                    // HORIZONTAL
                    if (x + 1 < 8 && tablero[y][x + 1] == 'b') { // Si no se sale del tablero el siguiente, y si es b
                        horizontal = true;
                        while (x + tamañoBarco < 8 && tablero[y][x + tamañoBarco] == 'b') { // Aumenta hasta que no sea b
                            tamañoBarco++;
                        }
                    }

                    // VERTICAL
                    if (y + 1 < 8 && tablero[y + 1][x] == 'b') { // Si no se sale del tablero el siguiente, y si es b
                        vertical = true;
                        tamañoBarco = 1; // Reiniciar para contar vertical
                        while (y + tamañoBarco < 8 && tablero[y + tamañoBarco][x] == 'b') { // Aumenta hasta que no sea b
                            tamañoBarco++;
                        }
                    }

                    if (horizontal && vertical) {
                        System.out.println("Error: Barcos superpuestos");
                        return;
                    }

                    // ESQUINAS
                    int[] dx = {-1, 1, -1, 1}; // Posibles movimientos diagonales
                    int[] dy = {-1, -1, 1, 1}; // Posibles movimientos diagonales
                    for (int i = 0; i < 4; i++) {
                    	// Este bucle comprueba  4 posibilidades:
                    	// Esquina superior izquierda.
                    	// Esquina superior derecha.
                    	// Esquina inferior izquierda.
                    	// Esquina inferior derecha.
                        int nuevoX = x + dx[i];
                        int nuevoY = y + dy[i];
                        if (nuevoX >= 0 && nuevoX < 8 && nuevoY >= 0 && nuevoY < 8 &&
                        		tablero[nuevoY][nuevoX] == 'b') {
                            // La primera parte comprueba que las coordenadas de la esquina
                        	// estén dentro del tablero, y la segunda parte comprueba que
                        	// alguna de esas 4 sean b

                        	System.out.println("Error: Barcos tocando esquinas");
                            return;
                        }
                    }

                    // Registrar el barco
                    barcos *= tamañoBarco;
                    barcosCount++;

                    // Marcar las posiciones como procesadas
                    for (int i = 0; i < tamañoBarco; i++) {
                    	// Si el barco que se vio es horizontal, se da como procesado esa casilla y las demás
                    	// hasta cubrir el barco entero
                        if (horizontal) procesado[y][x + i] = true;
                        if (vertical) procesado[y + i][x] = true;
                    }
                }
            }
        }


        // COMPROBACIONES FINALES
        if (barcosCount == 5 && barcos == 360) {
            System.out.println("Todo salió bien!!! Aquí está tu tablero:");
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Error: La configuración no cumple con los requisitos.");
            System.out.println("(" + barcos + "/360) puntos y " + barcosCount + " barcos detectados");
        }

        teclado.close();
    }
}
