package arrays;

public class Tablero {
	
	public static void main(String[] args) {
		char[][] tablero;
		
		tablero = inicializarTableroDeclaracion();
		imprimeTablero(tablero);
		System.out.println();
		tablero = inicializarTableroEjecucion();
		imprimeTablero(tablero);
	}

	private static char[][] inicializarTableroDeclaracion() {
		char[][] tablero = {
				{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
				{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
				{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
				{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '}};
		System.out.println("Tablero inicializado al declarlo");
		return tablero;
	}
	
	private static char[][] inicializarTableroEjecucion() {
		char[][] tablero;
		tablero = new char[8][8];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (i % 2 == 0) {
					tablero[i][j] = (j % 2 == 0) ? ' ' : 'X';
				} else {
					tablero[i][j] = (j % 2 != 0) ? ' ' : 'X';
				}
			}
			
		}
		System.out.println("Tablero inicializado en tiempo de ejecución");
		return tablero;
	}

	private static void imprimeTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}

}
