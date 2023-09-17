package co.edu.uptc.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.model.Prueba;
import co.edu.uptc.view.PlotFrame;
import co.edu.uptc.view.StatsFrame;

/**
 * Clase que actúa como controlador en la aplicación, gestionando la simulación de juegos y
 * respondiendo a eventos de la interfaz de usuario.
 */
public class Presenter implements ActionListener {

    /**
     * Objeto de simulación.
     */

    private Prueba prueba;

    /**
     * Constructor de la clase Presenter.
     * @param games Cantidad de juegos a simular.
     */
    public Presenter(int games) {
        prueba = new Prueba(games);
        new StatsFrame(this, prueba.getSuerteArquero(), prueba.getExperienciaArqueros(),
                prueba.getEquipoGanador(), prueba.getWinGenero(), prueba.getTotalWinGenero());
    }
    /**
     * Implementación del método actionPerformed de la interfaz ActionListener.
     * Controla las acciones realizadas en respuesta a eventos.
     * @param e El evento que desencadena la acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Plotting":
                new PlotFrame(prueba.getArqueroPorJuego());
                break;
            default:
                break;
        }
    }
}