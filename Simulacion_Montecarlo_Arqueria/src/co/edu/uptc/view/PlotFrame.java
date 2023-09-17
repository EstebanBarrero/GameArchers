package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import co.edu.uptc.model.Arquero;

/**
 * PlotFrame class that generates the archers score vs 250 games plot.
 *
 */

public class PlotFrame extends JFrame {

    /**
     * Constant.
     */

    private static final long serialVersionUID = 1L;

    /**
     * JFrame content pane.
     */

    private JPanel contentPane;


    /**
     * Constructor de la clase PlotFrame para mostrar un gráfico.
     * @param arqueros ArrayList de objetos Arquero para representar en el gráfico.
     */
    public PlotFrame(ArrayList<Arquero> arqueros) {
        super("Graphic");
        setSize(1800, 1000); //Tamaño de la grafica
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLookAndFeel();
        initComponents(arqueros);
        setVisible(true);
    }


    /**
     * Configura el aspecto visual de la aplicación para que coincida con el aspecto del sistema operativo.
     */
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa los componentes necesarios para crear un gráfico XY y lo muestra en la ventana.
     * @param arqueros La lista de arqueros utilizada para crear el gráfico.
     */
    private void initComponents(ArrayList<Arquero> arqueros) {

        XYDataset dataset = createDataset(arqueros);

        JFreeChart chart = ChartFactory.createXYLineChart("Archer Points vs Games", "Game", "Points",
                dataset);

        personalizarGrafico(chart);

        contentPane = new ChartPanel(chart);

        setContentPane(contentPane);
    }

    /**
     * El propósito principal de este método es estructurar los datos de los arqueros en una forma que pueda ser
     * utilizada para crear gráficos XY, como gráficos de dispersión o líneas, en un entorno de visualización,
     * como una gráfica.
     */
    private XYDataset createDataset(ArrayList<Arquero> arqueros) {

        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries archer1 = new XYSeries("Archer 1");
        XYSeries archer2 = new XYSeries("Archer 2");
        XYSeries archer3 = new XYSeries("Archer 3");
        XYSeries archer4 = new XYSeries("Archer 4");
        XYSeries archer5 = new XYSeries("Archer 5");
        XYSeries archer6 = new XYSeries("Archer 6");
        XYSeries archer7 = new XYSeries("Archer 7");
        XYSeries archer8 = new XYSeries("Archer 8");
        XYSeries archer9 = new XYSeries("Archer 9");
        XYSeries archer10 = new XYSeries("Archer 10");

        Arquero auxArquero = null;

        for (int i = 0; i < 20000; i++) {

            auxArquero = arqueros.get(i);

            switch (auxArquero.getCodigo()) {
                case 1:
                    archer1.add(i + 1, auxArquero.getPuntos());
                    break;

                case 2:
                    archer2.add(i + 1, auxArquero.getPuntos());
                    break;

                case 3:
                    archer3.add(i + 1, auxArquero.getPuntos());
                    break;

                case 4:
                    archer4.add(i + 1, auxArquero.getPuntos());
                    break;

                case 5:
                    archer5.add(i + 1, auxArquero.getPuntos());
                    break;

                case 6:
                    archer6.add(i + 1, auxArquero.getPuntos());
                    break;

                case 7:
                    archer7.add(i + 1, auxArquero.getPuntos());
                    break;

                case 8:
                    archer8.add(i + 1, auxArquero.getPuntos());
                    break;

                case 9:
                    archer9.add(i + 1, auxArquero.getPuntos());
                    break;

                case 10:
                    archer10.add(i + 1, auxArquero.getPuntos());
                    break;

                default:
                    break;
            }
        }
        dataset.addSeries(archer1);
        dataset.addSeries(archer2);
        dataset.addSeries(archer3);
        dataset.addSeries(archer4);
        dataset.addSeries(archer5);
        dataset.addSeries(archer6);
        dataset.addSeries(archer7);
        dataset.addSeries(archer8);
        dataset.addSeries(archer9);
        dataset.addSeries(archer10);

        return dataset;
    }


    /**
     * Personaliza la apariencia y el estilo del gráfico XY.
     * @param chart El gráfico XY que se va a personalizar.
     */
    private void personalizarGrafico(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Define colores para cada serie en el gráfico (en este caso, se definen colores para 13 series).
        renderer.setSeriesPaint(0, Color.LIGHT_GRAY);
        renderer.setSeriesPaint(1, Color.MAGENTA);
        renderer.setSeriesPaint(2, Color.ORANGE);
        renderer.setSeriesPaint(3, Color.RED);
        renderer.setSeriesPaint(4, Color.BLUE);
        renderer.setSeriesPaint(5, Color.GREEN);
        renderer.setSeriesPaint(6, Color.LIGHT_GRAY);
        renderer.setSeriesPaint(7, Color.MAGENTA);
        renderer.setSeriesPaint(8, Color.YELLOW);
        renderer.setSeriesPaint(9, Color.ORANGE);
        renderer.setSeriesPaint(10, Color.PINK);
        renderer.setSeriesPaint(11, Color.CYAN);
        renderer.setSeriesPaint(12, Color.WHITE);


        // Define el grosor de las líneas para cada serie.
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
        renderer.setSeriesStroke(2, new BasicStroke(1.0f));
        renderer.setSeriesStroke(3, new BasicStroke(1.0f));
        renderer.setSeriesStroke(4, new BasicStroke(1.0f));
        renderer.setSeriesStroke(5, new BasicStroke(1.0f));
        renderer.setSeriesStroke(6, new BasicStroke(1.0f));
        renderer.setSeriesStroke(7, new BasicStroke(1.0f));
        renderer.setSeriesStroke(8, new BasicStroke(1.0f));
        renderer.setSeriesStroke(9, new BasicStroke(1.0f));

        // Oculta las formas llenas en el gráfico.
        renderer.setBaseShapesFilled(false);
        // Oculta los contornos alrededor de las formas.
        renderer.setDrawOutlines(false);
        // Asigna el renderer personalizado al plot del gráfico.
        plot.setRenderer(renderer);

        // Establece el color de fondo del plot.
        plot.setBackgroundPaint(Color.WHITE);

        // Configura la apariencia de las líneas de la cuadrícula en el gráfico.
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
    }
}