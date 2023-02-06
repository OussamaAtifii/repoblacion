package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private Consola() {

	}

	public static int leerAnchura() {
		int anchura = 0;
		System.out.println("Introduzca la anchura del bosque(10 - 1000): ");
		anchura = Entrada.entero();
		while (anchura < 10 || anchura > 1000) {
			System.out.println("Anchura introducida incorrecta, vuelta a introducirla: ");
			anchura = Entrada.entero();
		}
		return anchura;
	}

	public static int leerAltura() {
		int altura = 0;
		System.out.println("Introduzca la altura del bosque(10 - 500): ");
		altura = Entrada.entero();
		while (altura < 10 || altura > 500) {
			System.out.println("Altura introducida incorrecta, vuelta a introducirla: ");
			altura = Entrada.entero();
		}
		return altura;
	}

	public static int leerPoblacion() {
		int poblacion = 0;
		System.out.println("Introduce la población de especies: ");
		poblacion = Entrada.entero();
		while (poblacion <= 0) {
			System.out.println("Población introducida incorrecta, vuelta a introducirla: ");
			poblacion = Entrada.entero();
		}
		return poblacion;
	}
}
