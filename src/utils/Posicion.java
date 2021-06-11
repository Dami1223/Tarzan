package utils;

public class Posicion {

	private int x;
	private int y;

	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double calcularDistancia(Posicion otro) {
		return Math.sqrt(Math.pow(this.x - otro.x, 2) + Math.pow(this.y - otro.y, 2));
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}
