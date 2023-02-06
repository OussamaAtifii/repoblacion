package repoblacion.modelo;

public enum Especie {
	ALAMO("Álamo"), ENCINA("Encina"), CASTANO("Castaño"), CIPRES("Ciprés"), PINO("Pino"), ROBLE("Roble"),
	OLIVO("Olivo");

	private String cadenaAmostrar;

	private Especie(String cadenaAmostrar) {
		this.cadenaAmostrar = cadenaAmostrar;
	}

	@Override
	public String toString() {
		return cadenaAmostrar;
	}
}
