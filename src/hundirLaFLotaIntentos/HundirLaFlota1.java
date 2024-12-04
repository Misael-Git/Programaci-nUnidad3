package hundirLaFLotaIntentos;

import java.util.Scanner;

public class HundirLaFlota1 {

    public static void main(String[] args) {
        char tablero[][] = {
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'}
        };

        // Escáner para que el jugador ingrese el tablero
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el tablero (8x8) fila por fila usando '_' para agua y 'B' para barco:");
        System.out.println("       **Hay un barco de 5, uno de 4, dos de 3 y tres de 2**");

        // Ingresar las filas del tablero
        for (int i = 0; i < 8; i++) {
            String fila = teclado.nextLine();
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = fila.charAt(j);
            }
        }

        // Declarar los barcos esperados: 1 de tamaño 5, 1 de tamaño 4, 2 de tamaño 3, 3 de tamaño 2
        int[] barcosEsperados = {2, 3, 3, 4, 5}; // Indica la cantidad de barcos de 2, 3, 4 y 5
        int[] barcosEncontrados = new int[5]; // Almacena cuántos barcos de cada tamaño hemos encontrado

        // Matriz de visitas para marcar las casillas que ya hemos procesado
        boolean[][] visitado = new boolean[8][8];
        
        // Recorrer todo el tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Si encontramos una casilla con un barco ('B') y no ha sido visitada
                if (tablero[i][j] == 'B' && !visitado[i][j]) {
                    // Contamos el tamaño del barco que empieza en esa posición
                    int tamañoBarco = 0;
                    int[] dx = {0, 1, 0, -1}; // Dirección de movimientos en el eje x
                    int[] dy = {1, 0, -1, 0}; // Dirección de movimientos en el eje y

                    // Marcar la casilla actual como visitada
                    visitado[i][j] = true;
                    tamañoBarco++;

                    // Recorrer las 4 direcciones (arriba, derecha, abajo, izquierda)
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        // Verificar si la nueva casilla está dentro de los límites del tablero
                        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                            // Si encontramos una parte del barco ('B') que aún no hemos visitado
                            if (tablero[nx][ny] == 'B' && !visitado[nx][ny]) {
                                // Si el barco ya tiene más de 1 casilla, prohibir barcos en esquinas
                                if (tamañoBarco > 1 && dir >= 2) {
                                    System.out.println("Error: Barcos tocándose en esquinas");
                                    teclado.close();
                                    return;
                                }
                                // Marcar como visitado y contar la siguiente parte del barco
                                visitado[nx][ny] = true;
                                tamañoBarco++;
                            }
                        }
                    }

                    // Si el tamaño del barco es inválido (menor a 2 o mayor a 5), mostrar error
                    if (tamañoBarco < 2 || tamañoBarco > 5) {
                        System.out.println("Error: Barco de tamaño inválido encontrado");
                        teclado.close();
                        return;
                    }

                    // Aumentamos el contador del tamaño correspondiente en el arreglo de barcos encontrados
                    barcosEncontrados[tamañoBarco - 2]++;
                }
            }
        }

        // Comparar los barcos encontrados con los barcos esperados
        for (int i = 0; i < 4; i++) {
            if (barcosEncontrados[i] != barcosEsperados[i]) {
                System.out.println("Error: Número incorrecto de barcos de tamaño " + (i + 2) + ".");
                teclado.close();
                return;
            }
        }

        // Si todo está correcto, mostrar el tablero
        System.out.println("Tablero válido:");
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }

        // Cerrar el scanner
        teclado.close();
    }
}
