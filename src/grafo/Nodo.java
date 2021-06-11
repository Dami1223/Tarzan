package grafo;

import monticulo.Monticulo;
import monticulo.MonticuloMinima;
import utils.Posicion;

public class Nodo {

	private Monticulo<Arista> aristas = new MonticuloMinima<Arista>();
	private int idNodo;
	private Posicion posicion;

	@Override
	public String toString() {
		return posicion.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aristas == null) ? 0 : aristas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		if (aristas == null) {
			if (other.aristas != null)
				return false;
		} else if (!aristas.equals(other.aristas))
			return false;
		return true;
	}

	public Nodo(int id) {
		this.idNodo = id;
	}

	public void agregarArista(Arista nuevaArista) {
		aristas.agregar(nuevaArista);
	}

	public Arista obtenerAristaMinima() {
		return aristas.verTope();
	}

	public Monticulo<Arista> obtenerMonticuloAristas() {
		return aristas;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void setPosicion(int nextInt, int nextInt2) {
		this.posicion = new Posicion(nextInt, nextInt2);
	}

	public double calcularDistancia(Nodo nodo) {
		return this.posicion.calcularDistancia(nodo.posicion);
	}

	public int getIdNodo() {
		return idNodo;
	}
}
