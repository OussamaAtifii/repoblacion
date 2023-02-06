package repoblacion.modelo;

import java.util.Random;

public class Bosque {
	public final int MAX_ALTURA = 500;
	public final int MINIMO = 10;
	public final int MAX_ANCHURA = 1000;
	public final int MAX_ESPECIES = 4;

	private int alto;
	private int ancho;
	private Random generador;
	private static Arbol arbolMasAlejado;
	private static Arbol arbolMasCentrado;
	private static Arbol[] arboles;

	// Constructor con parametros
	public Bosque(int ancho, int alto, int poblacion) {
		setAncho(ancho);
		setAlto(alto);
		checkPoblacion(poblacion);
		arboles = new Arbol[poblacion];
		repoblar();
	}

	public void checkPoblacion(int poblacion) {
		while (poblacion <= 0) {
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
		}
		if (poblacion > 2 * (ancho + alto)) {
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}
	}

	public Arbol[] duplicaBosque() {
		Arbol[] copiaArboles = new Arbol[arboles.length];
		for (int i = 0; i < arboles.length; i++) {
			if (arboles[i] != null) {
				copiaArboles[i] = new Arbol(arboles[i]);
			}
		}
		return copiaArboles;
	}

	public Especie generadorEspecie() {
		int numArbol = 0;
		Especie especie = null;

		generador = new Random();
		numArbol = generador.nextInt(0, 7);
		switch (numArbol) {
			case 0:
				especie = Especie.ALAMO;
				break;
			case 1:
				especie = Especie.ENCINA;
				break;
			case 2:
				especie = Especie.CASTANO;
				break;
			case 3:
				especie = Especie.CIPRES;
				break;
			case 4:
				especie = Especie.PINO;
				break;
			case 5:
				especie = Especie.ROBLE;
				break;
			case 6:
				especie = Especie.OLIVO;
				break;
		}
		return especie;
	}

	public Especie[] generadorArray4Especies() {
		Especie[] coleccionEspecies = new Especie[MAX_ESPECIES];
		for (int i = 0; i < coleccionEspecies.length; i++) {
			coleccionEspecies[i] = generadorEspecie(); // Generamos un array con 4 especies diferentes
		}

		// Comprobamos que la primera posicion sea diferente a las anteriores
		while (coleccionEspecies[0].equals(coleccionEspecies[1]) || coleccionEspecies[0].equals(coleccionEspecies[2])
				|| coleccionEspecies[0].equals(coleccionEspecies[3])) {
			coleccionEspecies[0] = generadorEspecie();
		}
		// Comprobamos que la segunda posicion sea diferente a las anteriores
		while (coleccionEspecies[1].equals(coleccionEspecies[2]) || coleccionEspecies[1].equals(coleccionEspecies[3])) {
			coleccionEspecies[1] = generadorEspecie();
		}
		// Comprobamos que la tercera posicion sea diferente a las anteriores
		while (coleccionEspecies[2].equals(coleccionEspecies[3])) {
			coleccionEspecies[2] = generadorEspecie();
		}
		return coleccionEspecies;
	}

	// Una vez conseguido el array con 4 especies diferentes generamos especies sobre el
	public Especie generadorEspecieLimitada(Especie[] especieLimitada) {
		int numArbol = 0;
		Especie especie = null;

		generador = new Random();
		numArbol = generador.nextInt(0, 4);
		switch (numArbol) {
			case 0:
				especie = especieLimitada[0];
				break;
			case 1:
				especie = especieLimitada[1];
				break;
			case 2:
				especie = especieLimitada[2];
				break;
			case 3:
				especie = especieLimitada[3];
				break;
		}
		return especie;
	}

	//Generamos posicion aleatoria
	private Posicion generadorPosicion() {
		double posX = 0;
		double posY = 0;

		generador = new Random();
		posX = generador.nextDouble(-ancho / 2, ancho / 2 + 1);
		posY = generador.nextDouble(-alto / 2, alto / 2 + 1);
		return new Posicion(posX, posY);
	}

	private void repoblar() {
		Especie especie = null;
		Posicion posicion;
		Especie[] especies = generadorArray4Especies(); // Obtenemos array con 4 especies diferentes

		for (int i = 0; i < arboles.length; i++) {
			if (arboles[i] == null) {
				especie = generadorEspecieLimitada(especies);
				// Comprobamos las incompatibilidades de alamo
				if (i != 0 && arboles[i - 1].getEspecie().equals(Especie.ALAMO)) {
					while (especie.equals(Especie.CASTANO) || especie.equals(Especie.CIPRES)
							|| especie.equals(Especie.OLIVO)) {
						especie = generadorEspecieLimitada(especies);
					}
				}
				// Comprobamos las incompatibilidades de olivo
				if (i != 0 && arboles[i - 1].getEspecie().equals(Especie.OLIVO)) {
					while (especie.equals(Especie.ALAMO) || especie.equals(Especie.ENCINA)) {
						especie = generadorEspecieLimitada(especies);
					}
				}
				posicion = new Posicion(generadorPosicion()); //Generamos posicion
				arboles[i] = new Arbol(especie, posicion); // Creamos arbol y lo introducimos al array
				System.out.println(arboles[i]);
			}
		}
	}

	public void realizarCalculos() {
		Double distancia1;
		Double distancia2;
		// Comprobación cuando solo hay un arbol, que el lejano y cercano sea ese mismo
		// arbol
		if (arboles.length == 1) {
			arbolMasCentrado = arboles[0];
			arbolMasAlejado = arboles[0];
		} else if (arboles.length == 2) { // Comprobación de cuando solo sean 2 arboles
			if (Posicion.distancia(arboles[0].getPosicion()) > Posicion.distancia(arboles[1].getPosicion())) {
				arbolMasCentrado = arboles[1];
				arbolMasAlejado = arboles[0];
			} else {
				arbolMasCentrado = arboles[0];
				arbolMasAlejado = arboles[1];
			}
		} else { // Calculamos cuando sean mas de 2 arboles
			for (int i = 1; i < arboles.length; i++) {
				distancia1 = Posicion.distancia(arboles[i - 1].getPosicion());
				distancia2 = Posicion.distancia(arboles[i].getPosicion());

				if (distancia1 >= distancia2) {
					arbolMasCentrado = arboles[i];
				}
				if (distancia1 <= distancia2) {
					arbolMasAlejado = arboles[i];
				}
			}
		}
	}

	// Getters
	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}

	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}

	// Setters
	public void setAlto(int alto) {
		if (alto < MINIMO || alto > MAX_ALTURA) {
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		}
		this.alto = alto;
	}

	public void setAncho(int ancho) {
		if (ancho < MINIMO || ancho > MAX_ANCHURA) {
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		}
		this.ancho = ancho;
	}
}