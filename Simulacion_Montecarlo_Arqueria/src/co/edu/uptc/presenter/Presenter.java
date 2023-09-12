package co.edu.uptc.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.model.Prueba;
import co.edu.uptc.view.PlotFrame;
import co.edu.uptc.view.StatsFrame;

/**
 * Presenter class.
 *
 */

public class Presenter implements ActionListener {

    /**
     * Simulation object.
     */

    private Prueba prueba;

    /**
     *
     * Constructor method.
     *
     * @param games.
     */

    public Presenter(int games) {
        prueba = new Prueba(games);
        new StatsFrame(this, prueba.getSuerteArquero(), prueba.getExperienciaArqueros(),
                prueba.getEquipoGanador(), prueba.getWinGenero(), prueba.getTotalWinGenero());
    }

    /**
     *
     * actionPerformed overwrite method
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Plotting":
                new PlotFrame(prueba.getArchersPorJuego());
                break;

            default:
                break;
        }
    }
}