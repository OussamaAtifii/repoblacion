package repoblacion.modelo;

public class Arbol {
	private Especie especie;
	private Posicion posicion;

	// Constructor con parametros
	public Arbol(Especie especie, Posicion posicion) {
		setEspecie(especie);
		setPosicion(posicion);

	}

	// Constructor copia
	public Arbol(Arbol arbol) {
		if (arbol == null) {
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
		}
		setEspecie(arbol.getEspecie());
		setPosicion(arbol.getPosicion());

	}

	// Getters
	public Especie getEspecie() {
		return especie;
	}

	public Posicion getPosicion() {
		return new Posicion(posicion);
	}

	// Setters
	private void setEspecie(Especie especie) {
		if (especie == null) {
			throw new NullPointerException("ERROR: La especie no puede ser nula.");
		}
		this.especie = especie;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: La posición no puede ser nula.");
		}
		this.posicion = posicion;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "especie=" + especie + ", posicion=(" + posicion + ")";
	}
}
