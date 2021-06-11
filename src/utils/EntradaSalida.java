package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import dijkstra.Camino;
import grafo.Arista;
import grafo.Grafo;
import grafo.GrafoDireccional;
import grafo.Nodo;

public class EntradaSalida {

	private static int primero;
	private static int ultimo;

	public static Grafo leer(String path) {
		Grafo grafo = new GrafoDireccional();

		File file = new File(path);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			int nroNodo = 1;
			while (scanner.hasNext()) {
				Nodo nodo = new Nodo(nroNodo);
				nodo.setPosicion(scanner.nextInt(), scanner.nextInt());
				grafo.agregarNodo(nodo);
				nroNodo++;
			}
			for (Nodo nodo : grafo.getNodos()) {
				for (Nodo nodo2 : grafo.getNodos()) {
					if (nodo2.calcularDistancia(nodo) <= 50 && nodo != nodo2)
						grafo.agregarAristaNodo(nodo2, new Arista(1, nodo));
				}
			}
			primero = 1;
			ultimo = nroNodo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return grafo;
	}

	public static void escribir(String pathSalida, Camino caminoResultado) throws FileNotFoundException {
		File archivoSalida = new File(pathSalida);
		PrintWriter pwOut = new PrintWriter(archivoSalida);
		for (Nodo arbol : caminoResultado.getNodosCamino()) {
			pwOut.println(arbol.getPosicion());
		}
		pwOut.close();
	}

	public static int getUltimo() {
		return ultimo;
	}

	public static int getPrimero() {
		return primero;
	}

}
