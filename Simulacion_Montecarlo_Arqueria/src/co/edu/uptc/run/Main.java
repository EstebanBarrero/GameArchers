package co.edu.uptc.run;
import co.edu.uptc.presenter.Presenter;

/**
 * Clase de punto de entrada para iniciar la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        // Crea una instancia de la clase Presenter con 20000 juegos a simular.
        new Presenter(20000);
    }
}