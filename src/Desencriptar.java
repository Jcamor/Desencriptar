
public class Desencriptar {
	static int[] contarEntrada = new int[27];
	static int[] maxEntrada = new int[27];
	static int[][] frecuencia = new int[27][2];
	static String entrada = "";
	static String salida;
	static String maxEspaniol = "eaosrnidctumpbgvyqhfzjñxkw";
	static char[] maxEs = new char[27];
	static boolean correcto = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length == 0) {
			ayuda();
		} else {
			correcto = true;
			entrada = args[0];
		}
		if (correcto) {
			maxEs = maxEspaniol.toCharArray();
			salida = entrada;

			int longitud = entrada.length();
			for (int i = 0; i < longitud; i++) {
				if ((int) (entrada.charAt(i)) < 123 && (int) (entrada.charAt(i)) > 93) {
					char character = entrada.charAt(i);
					int ascii = (int) character;
					ascii = ascii - 97;
					contarEntrada[ascii]++;
				}
			}
			maxEntrada = contarEntrada;

			boolean nosalir = true;

			while (nosalir) {
				for (int i = 0; i < maxEntrada.length; i++) {
					if (maxEntrada[mayor()] != 0) {
						frecuencia[i][0] = mayor();
						frecuencia[i][1] = maxEntrada[frecuencia[i][0]];
						maxEntrada[frecuencia[i][0]] = 0;

					} else {
						nosalir = false;
					}
				}
			}
			imprimir();
			invertir();
			System.out.println();
			System.out.println("El texto original es: ");
			System.out.println(entrada);
			System.out.println("El texto descifrado es: ");
			System.out.println(salida.toLowerCase());
		}
	}

	private static void ayuda() {
		// TODO Auto-generated method stub
		System.out.println("java desencriptar [texto a desencriptar sin comillas]");
	}

	public static void invertir() {
		char letraMax;
		for (int i = 0; i < frecuencia.length && frecuencia[i][1] != 0; i++) {
			letraMax = (char) ((frecuencia[i][0]) + 97);
			salida = salida.replace(letraMax, Character.toUpperCase(maxEs[i]));

		}
	}

	public static void imprimir() {
		char letra = (char) 64;
		for (int i = 0; i < contarEntrada.length; i++) {
			if (frecuencia[i][1] != 0) {
				letra = (char) ((frecuencia[i][0]) + 97);
				System.out.print(" letra: " + letra + "  ");
				if (frecuencia[i][1] == 1) {
					System.out.println(frecuencia[i][1] + " vez");
				} else {
					System.out.println(frecuencia[i][1] + " veces");
				}
			}
		}

	}

	public static int mayor() {

		int max = 0;
		int posicion = 0;

		max = 0;

		for (int i = 0; i < maxEntrada.length; i++) {

			if (maxEntrada[i] > max) {

				max = maxEntrada[i];
				posicion = i;

			}

		}

		return posicion;
	}

}