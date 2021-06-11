package test;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import grafo.Grafo;
import utils.EntradaSalida;

class TarzanTest {

	@Test
	void test() throws FileNotFoundException {
		Grafo grafo = EntradaSalida.leer("Tarzan.in");
		EntradaSalida.escribir("Tarzan.out", grafo.obtenerCaminoMinimo(0, 11));
	}

}
