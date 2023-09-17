package co.edu.uptc.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

    /**
     * StatsFrame class that shows simulation statistics.
     *
     */

    public class StatsFrame extends JFrame {

        /**
         * Constant.
         */

        private static final long serialVersionUID = 1L;

        /**
         * JFrame content pane.
         */

        private JPanel contentPane;

        /**
         * First stat label.
         */

        private JLabel firstStatistic;

        /**
         * Separator.
         */

        private JSeparator firstSeparator;

        /**
         * First stat text area.
         */

        private JTextArea firstStatisticTextArea;

        /**
         * First stat scroll pane.
         */

        private JScrollPane firstStatisticScrollPane;

        /**
         * Second stat scroll pane.
         */

        private JScrollPane secondStatisticScrollPane;

        /**
         * Fourth stat scroll pane.
         */

        private JScrollPane fourthStatisticScrollPane;

        /**
         * Second stat label.
         */

        private JLabel secondtStatistic;

        /**
         * Second stat text area.
         */

        private JTextArea secondStatistictTextArea;

        /**
         * Separator.
         */

        private JSeparator secondSeparator;

        /**
         * Separator.
         */

        private JSeparator thirdSeparator;

        /**
         * Separator.
         */

        private JSeparator fourthSeparator;

        /**
         * Third stat label.
         */

        private JLabel thirdtStatistic;

        /**
         * Fourth stat label.
         */

        private JLabel fourthStatistic;

        /**
         * Fourth stat text area.
         */

        private JTextArea fourthStatisticTextArea;

        /**
         * Third stat text area.
         */

        private JTextArea thirdStatisticTextArea;

        /**
         * Separator.
         */

        private JSeparator fifthSeparator;

        /**
         * Fifth stat label.
         */

        private JLabel fifthStatistic;

        /**
         * Fifth stat text area.
         */

        private JTextArea fifthStatisticTextArea;

        /**
         * Botón para generar la grafica.
         */

        private JButton plotButton;

        /**
         * Constructor de la clase StatsFrame para crear una ventana de estadísticas.
         * @param listener ActionListener para gestionar eventos de la interfaz.
         * @param firstStatisticString  Texto para la primera estadística que es Arqueros con más suerte.
         * @param secondStatisticString Texto para la segunda estadística que es Arqueros más experimentados.
         * @param thirdStatisticString  Texto para la tercera estadística que es el Equipo ganador.
         * @param fourthStatisticString Texto para la cuarta estadística que son los Ganadores por género.
         * @param fifthStatisticString  Texto para la quinta estadística que es el Género ganador.
         */
        public StatsFrame(ActionListener listener, String firstStatisticString, String secondStatisticString,
                          String thirdStatisticString, String fourthStatisticString, String fifthStatisticString) {
            super("MonteCarlo Game Simulator");
            setSize(900, 450); //Establece el tamaño de la ventana en 900 píxeles de ancho y 450 píxeles de alto.
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null); //Centra la ventana en el medio de la pantalla.
            setResizable(false);
            setLookAndFeel();
            initComponents(listener, firstStatisticString, secondStatisticString, thirdStatisticString,
                    fourthStatisticString, fifthStatisticString);
            setVisible(true);
        }

        /**
         * Configura el aspecto y la sensación (look and feel) de la ventana de la aplicación
         * utilizando el aspecto del sistema operativo.
         */
        private void setLookAndFeel() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * Inicializa y configura los componentes de la interfaz de usuario.
         * @param listener El ActionListener para manejar eventos.
         * @param firstStatisticString Cadena de texto para la primera estadística que es Arqueros con más suerte
         * @param secondStatisticString Cadena de texto para la segunda estadística que es Arqueros más experimentados.
         * @param thirdStatisticString Cadena de texto para la tercera estadística que es el Equipo ganador.
         * @param fourthStatisticString Cadena de texto para la cuarta estadística que son los Ganadores por género
         * @param fifthStatisticString Cadena de texto para la quinta estadística que es el Género ganador.
         */
        private void initComponents(ActionListener listener, String firstStatisticString, String secondStatisticString,
                                    String thirdStatisticString, String fourthStatisticString, String fifthStatisticString) {

            contentPane = new JPanel();
            contentPane.setLayout(null);
            contentPane.setBackground(Color.gray);

            firstStatistic = new JLabel("Most Lucky Archers");
            firstStatistic.setHorizontalAlignment(SwingConstants.CENTER);
            firstStatistic.setFont(new Font("Arial", Font.BOLD, 12));
            firstStatistic.setForeground(Color.white);
            firstStatistic.setBounds(10, 25, 411, 26);
            contentPane.add(firstStatistic);

            firstSeparator = new JSeparator();
            firstSeparator.setOrientation(SwingConstants.VERTICAL);
            firstSeparator.setBounds(441, 25, 2, 132);
            contentPane.add(firstSeparator);

            firstStatisticTextArea = new JTextArea(firstStatisticString);
            firstStatisticTextArea.setForeground(Color.WHITE);
            firstStatisticTextArea.setBackground(Color.GRAY);
            firstStatisticTextArea.setEditable(false);
            firstStatisticTextArea.setWrapStyleWord(true);
            firstStatisticTextArea.setLineWrap(true);
            firstStatisticTextArea.setBounds(20, 62, 411, 91);
            contentPane.add(firstStatisticTextArea);

            firstStatisticScrollPane = new JScrollPane(firstStatisticTextArea);
            firstStatisticScrollPane.setBounds(20, 62, 411, 97);
            contentPane.add(firstStatisticScrollPane);

            secondtStatistic = new JLabel("Most Experienced Archers");
            secondtStatistic.setHorizontalAlignment(SwingConstants.CENTER);
            secondtStatistic.setFont(new Font("Arial", Font.BOLD, 12));
            secondtStatistic.setForeground(Color.white);
            secondtStatistic.setBounds(20, 183, 411, 26);
            contentPane.add(secondtStatistic);

            secondStatistictTextArea = new JTextArea(secondStatisticString);
            secondStatistictTextArea.setBackground(Color.GRAY);
            secondStatistictTextArea.setForeground(Color.white);
            secondStatistictTextArea.setEditable(false);
            secondStatistictTextArea.setWrapStyleWord(true);
            secondStatistictTextArea.setLineWrap(true);
            secondStatistictTextArea.setBounds(20, 221, 411, 21);
            contentPane.add(secondStatistictTextArea);

            secondStatisticScrollPane = new JScrollPane(secondStatistictTextArea);
            secondStatisticScrollPane.setBounds(20, 220, 411, 97);
            contentPane.add(secondStatisticScrollPane);

            secondSeparator = new JSeparator();
            secondSeparator.setBounds(19, 170, 402, 2);
            contentPane.add(secondSeparator);

            thirdSeparator = new JSeparator();
            thirdSeparator.setBounds(463, 172, 411, 2);
            contentPane.add(thirdSeparator);

            fourthSeparator = new JSeparator();
            fourthSeparator.setOrientation(SwingConstants.VERTICAL);
            fourthSeparator.setBounds(441, 185, 2, 132);
            contentPane.add(fourthSeparator);

            thirdtStatistic = new JLabel("Game Winning Team");
            thirdtStatistic.setHorizontalAlignment(SwingConstants.CENTER);
            thirdtStatistic.setFont(new Font("Arial", Font.BOLD, 12));
            thirdtStatistic.setForeground(Color.WHITE);
            thirdtStatistic.setBounds(453, 25, 421, 26);
            contentPane.add(thirdtStatistic);

            thirdStatisticTextArea = new JTextArea(thirdStatisticString);
            thirdStatisticTextArea.setForeground(Color.WHITE);
            thirdStatisticTextArea.setBackground(Color.GRAY);
            thirdStatisticTextArea.setEditable(false);
            thirdStatisticTextArea.setWrapStyleWord(true);
            thirdStatisticTextArea.setLineWrap(true);
            thirdStatisticTextArea.setBounds(453, 63, 421, 20);
            contentPane.add(thirdStatisticTextArea);

            fourthStatistic = new JLabel("Gender Winners");
            fourthStatistic.setHorizontalAlignment(SwingConstants.CENTER);
            fourthStatistic.setFont(new Font("Arial", Font.BOLD, 12));
            fourthStatistic.setForeground(Color.WHITE);
            fourthStatistic.setBounds(453, 185, 411, 26);
            contentPane.add(fourthStatistic);

            fourthStatisticTextArea = new JTextArea(fourthStatisticString);
            fourthStatisticTextArea.setForeground(Color.WHITE);
            fourthStatisticTextArea.setBackground(Color.GRAY);
            fourthStatisticTextArea.setEditable(false);
            fourthStatisticTextArea.setWrapStyleWord(true);
            fourthStatisticTextArea.setLineWrap(true);
            fourthStatisticTextArea.setBounds(453, 222, 411, 87);
            contentPane.add(fourthStatisticTextArea);

            fourthStatisticScrollPane = new JScrollPane(fourthStatisticTextArea);
            fourthStatisticScrollPane.setBounds(453, 222, 421, 88);
            contentPane.add(fourthStatisticScrollPane);

            fifthSeparator = new JSeparator();
            fifthSeparator.setBounds(10, 328, 864, 2);
            contentPane.add(fifthSeparator);

            fifthStatistic = new JLabel("Game Winning Gender");
            fifthStatistic.setHorizontalAlignment(SwingConstants.CENTER);
            fifthStatistic.setFont(new Font("Arial", Font.BOLD, 12));
            fifthStatistic.setForeground(Color.WHITE);
            fifthStatistic.setBounds(453, 90, 421, 26);
            contentPane.add(fifthStatistic);

            fifthStatisticTextArea = new JTextArea(fifthStatisticString);
            fifthStatisticTextArea.setForeground(Color.WHITE);
            fifthStatisticTextArea.setBackground(Color.GRAY);
            fifthStatisticTextArea.setEditable(false);
            fifthStatisticTextArea.setWrapStyleWord(true);
            fifthStatisticTextArea.setLineWrap(true);
            fifthStatisticTextArea.setBounds(453, 110, 421, 20);
            contentPane.add(fifthStatisticTextArea);

            plotButton = new JButton("Archers Score vs Games");
            plotButton.setFont(new Font("Arial", Font.BOLD, 14));
            plotButton.setFocusPainted(false);
            plotButton.addActionListener(listener);
            plotButton.setActionCommand("Plotting");
            plotButton.setBounds(296, 356, 282, 34);
            contentPane.add(plotButton);

            getRootPane().setDefaultButton(plotButton);

            setContentPane(contentPane);
        }
    }

