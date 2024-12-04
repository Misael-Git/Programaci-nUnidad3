package hundirLaFLotaIntentos;

import java.util.Scanner;

public class HundirLaFlotaCopiaSeguridad {

    public static void main(String[] args) {

        char tablero[][] = {
            {'-', '-', '-', 'b', 'b', 'b', 'b', '-'},
            {'-', 'b', '-', '-', '-', '-', '-', '-'},
            {'-', 'b', '-', '-', '-', '-', '-', '-'},
            {'-', 'b', '-', '-', '-', '-', '-', '-'},
            {'-', '-', 'b', 'b', 'b', 'b', 'b', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'b', 'b', 'b', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', 'b', 'b'}
        };
        boolean errorEsquinas = false;
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
        boolean[][] procesado = new boolean[8][8]; // Para evitar modificar el tablero original

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (tablero[y][x] == 'b' && !procesado[y][x]) {
                    int tamañoBarco = 1;
                    boolean horizontal = false, vertical = false;

                    // HORIZONTAL
                    if (x + 1 < 8 && tablero[y][x + 1] == 'b') {
                        horizontal = true;
                        while (x + tamañoBarco < 8 && tablero[y][x + tamañoBarco] == 'b') {
                            tamañoBarco++;
                        }
                    }

                    // VERTICAL
                    if (y + 1 < 8 && tablero[y + 1][x] == 'b') {
                        vertical = true;
                        tamañoBarco = 1; // Reiniciar para contar vertical
                        while (y + tamañoBarco < 8 && tablero[y + tamañoBarco][x] == 'b') {
                            tamañoBarco++;
                        }
                    }

                    if (horizontal && vertical) {
                        System.out.println("Error: Barcos superpuestos");
                        return;
                    }

                    // ESQUINAS
                    if (y + 1 < 8 && x + 1 < 8 && tablero[y + 1][x + 1] == 'b') {
                        errorEsquinas = true;
                    }
                    if (y + 1 < 8 && x - 1 >= 0 && tablero[y + 1][x - 1] == 'b') {
                        errorEsquinas = true;
                    }

                    if (errorEsquinas) {
                        System.out.println("Error: Barcos tocando esquinas");
                        return;
                    }

                    // Registrar el barco
                    barcos *= tamañoBarco;
                    barcosCount++;

                    // Marcar las posiciones como procesadas
                    for (int i = 0; i < tamañoBarco; i++) {
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
        }

        teclado.close();
    }
}
