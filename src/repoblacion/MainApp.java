package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {

	public static void main(String[] args) {
		Bosque bosque;
		try {
			int ancho = Consola.leerAnchura();
			int alto = Consola.leerAltura();
			int poblacion = Consola.leerPoblacion();

			bosque = new Bosque(ancho, alto, poblacion);
			
			bosque.realizarCalculos();
			System.out.println("Árbol más lejano: " + bosque.getArbolMasAlejado().toString());
			System.out.println("Árbol más cercano: " + bosque.getArbolMasCentrado().toString());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

}
