package repoblacion.modelo;

import java.text.DecimalFormat;

public class Posicion {
	private double x;
	private double y;

	// Constructor con parametros
	public Posicion(double x, double y) {
		setX(x);
		setY(y);
	}

	// Constructor Copia
	public Posicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: No se puede copiar una posición nula.");
		}
		setX(posicion.getX());
		setY(posicion.getY());
	}

	// Metodo devuelve la distancia entre 2 posiciones
	public static double distancia(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
		}
		Double calculoDistancia;
		calculoDistancia = Math.sqrt(Math.pow((posicion.getX() - 0), 2) + Math.pow((posicion.getY() - 0), 2));
		return calculoDistancia;
	}

	// Setters
	private void setX(double x) {
		this.x = x;
	}

	private void setY(double y) {
		this.y = y;
	}

	// Getters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	// Metodo toString
	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#.###");
		return "x=" + formato.format(x) + ", y=" + formato.format(y);
	}
}
