package hundirLaFLotaIntentos;

import java.util.Scanner;

public class HundirLaFlotaAntiguo {

    public static void main(String[] args) {
        char[][] tablero = {
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'}
        };

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el tablero (8x8) fila por fila usando '_' para agua y 'B' para barco:");
        System.out.println("       **Hay un barco de 4, dos de 3, tres de 2 y cuatro de 1**");
        for (int i = 0; i < 8; i++) {
            String fila = teclado.nextLine();
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = fila.charAt(j);
            }
        }

        if (validarTablero(tablero)) {
            System.out.println("Tablero válido:");
            mostrarTablero(tablero);
        } else {
            System.out.println("Tablero inválido");
        }

        teclado.close();
    }

    public static boolean validarTablero(char[][] tablero) {
        int[] barcosEsperados = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        int[] barcosEncontrados = new int[10];

        boolean[][] visitado = new boolean[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] == 'B' && !visitado[i][j]) {
                    int tamañoBarco = contarBarco(tablero, visitado, i, j);
                    if (tamañoBarco < 1 || tamañoBarco > 4) {
                        System.out.println("Error: Barco de tamaño inválido encontrado");
                        return false;
                    }
                    barcosEncontrados[tamañoBarco - 1]++;
                }
            }
        }

        // Comparar barcos encontrados con los esperados
        for (int i = 0; i < 4; i++) {
            if (barcosEncontrados[i] != barcosEsperados[i]) {
                System.out.println("Error: Número incorrecto de barcos de tamaño " + (i + 1) + ".");
                return false;
            }
        }

        return true;
    }

    public static int contarBarco(char[][] tablero, boolean[][] visitado, int x, int y) {
        int tamaño = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        visitado[x][y] = true;
        tamaño++;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                if (tablero[nx][ny] == 'B') {
                    if (visitado[nx][ny]) {
                        continue;
                    }
                    if (tamaño > 1 && dir >= 2) { // Prohibir barcos en esquinas
                        System.out.println("Error: Barcos tocándose en esquinas");
                        return -1;
                    }
                    tamaño += contarBarco(tablero, visitado, nx, ny);
                }
            }
        }
        return tamaño;
    }

    public static void mostrarTablero(char[][] tablero) {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}
