package co.edu.uptc.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * clase prueba en donde se realizaran los diferentes juegos y pruebas
 */
public class Prueba {
    //Atributos de tipo int o entero
    private int countGanadorRondaH, countGanadorRondaM, totalEquipo1, totalEquipo2;
    //Atributos de ArrayList de tipo Juego
    private ArrayList<Juego> listJuegos;
    //Atributos de Equipo
    private Equipo equipo1, equipo2;

    /**
     * Es metodo constructor lo que hace instaciar la lista de juego,
     * y inicializar las diferentes variables de la clase
     * @param games Cantidad de juegos a simular
     */
    public Prueba(int games) {
        listJuegos = new ArrayList<Juego>();
        countGanadorRondaH = 0;
        countGanadorRondaM = 0;
        totalEquipo1 = 0;
        totalEquipo2 = 0;
        SimulationP(games);
    }

    /**
     * Simula una serie de juegos y realiza el seguimiento de sus resultados.
     * @param games Cantidad de juegos a simular
     */
    private void SimulationP(int games) {
        for (int i = 0; i < games; i++) {
            equiposP();
            Juego juegoActual = new Juego(equipo1, equipo2);
            listJuegos.add(juegoActual);
            for (int j = 0; j < 10; j++) {
                for (Equipo equipo : listJuegos.get(i).getEquipos())
                    for (Arquero arquero : equipo.getArquero()) {
                        arquero.tiro();
                    }
                juegoActual.sorteoTiro();
                if (j >= 2) {
                    juegoActual.TiroExtraTresTiros();
                }
                juegoActual.arqueroGanador();
                juegoActual.equipoGanadorRonda();
                juegoActual.incrementaRondas();
                juegoActual.regainRoundPoints();

            }
            juegoActual.ganadorGenero();
        }
    }
    /**
     * Calcula y devuelve el género predominante entre los ganadores de juegos.
     * @return El género predominante entre los ganadores de juegos (MASCULINO o FEMENINO).
     */
    private Genero totalWinGenero() {
        for (Juego juego : listJuegos)
            if (juego.getGanadorGenero().getGenero() == 'M')
                countGanadorRondaH++;
            else
                countGanadorRondaM++;
        return (countGanadorRondaH > countGanadorRondaM) ? Genero.MASCULINO : Genero.FEMENINO;
    }

    /**
     * Calcula y almacena el puntaje total de cada equipo en la lista de juegos.
     */
    private void equipoGanador() {
        for (Juego juego : listJuegos) {
            totalEquipo1 += juego.scoreEquipo(0);
            totalEquipo2 += juego.scoreEquipo(1);
        }
    }
    /**
     * Obtiene una lista de todos los arqueros de todos los juegos en la lista.
     * @return Una lista que contiene todos los arqueros de los juegos.
     */
    public ArrayList<Arquero> getArqueroPorJuego() {
        ArrayList<Arquero> arqueros = new ArrayList<Arquero>();
        for (Juego juego : listJuegos)
            for (Arquero arquero : juego.getArqueros())
                arqueros.add(arquero);
        return arqueros;
    }

    /**
     * Obtiene una cadena que muestra el código del arquero con mayor suerte en cada juego.
     * @return Una cadena que contiene información sobre el arquero con mayor suerte en cada juego.
     */

    public String getSuerteArquero() {
        String suerteArquerosString = "";
        for (int i = 0; i < listJuegos.size(); i++)
            suerteArquerosString += "Game " + (i + 1) + " : Archer " + listJuegos.get(i).mayorSuerteArquero().getCodigo()
                    + "\n";
        return suerteArquerosString;
    }

    /**
     * Obtiene una cadena que muestra el código del arquero con mayor experiencia en cada juego.
     * @return Una cadena que contiene información sobre el arquero con mayor experiencia en cada juego.
     */
    public String getExperienciaArqueros() {
        String experienciaArqueroSt = "";
        for (int i = 0; i < listJuegos.size(); i++) {
            experienciaArqueroSt += "Game " + (i + 1) + " : Archer "
                    + listJuegos.get(i).ganadorExperiencia().getCodigo() + "\n";
        }
        return experienciaArqueroSt;
    }

    /**
     * Obtiene una cadena que muestra el código del arquero con mayor experiencia en cada juego.
     * @return Una cadena que contiene información sobre el arquero con mayor experiencia en cada juego.
     */
    public String getEquipoGanador() {
        equipoGanador();
        Equipo selectEquipo = null;
        int targetPoints = 0;
        if (totalEquipo1 > totalEquipo2) {
            selectEquipo = equipo1;
            targetPoints = totalEquipo1;
        } else {
            selectEquipo = equipo2;
            targetPoints = totalEquipo2;
        }
        return "TEAM " + selectEquipo.getCodigo() + " with " + new DecimalFormat("#,###,###,##0").format(targetPoints)
                + " points";
    }

    /**
     * Obtiene y devuelve el género predominante entre los ganadores de juegos.
     * @return Una cadena que representa el género predominante (FEMALE o MALE).
     */
    public String getTotalWinGenero() {
        return totalWinGenero().getGenero() == 'F' ? "FEMALE" : "MALE";
    }

    /**
     * Inicializa y configura dos equipos para el juego.
     */
    private void equiposP() {
        equipo1 = new Equipo(new ArrayList<Arquero>(
                Arrays.asList(new Arquero(1), new Arquero(2), new Arquero(3), new Arquero(4), new Arquero(5))), 1);
        equipo2 = new Equipo(new ArrayList<Arquero>(
                Arrays.asList(new Arquero(6), new Arquero(7), new Arquero(8), new Arquero(9), new Arquero(10))), 2);
    }
    /**
     * Obtiene una cadena que muestra el género del ganador de cada juego.
     * @return Una cadena que contiene el género del ganador de cada juego.
     */
    public String getWinGenero() {
        String getWinGeneroString = "";
        for (int i = 0; i < listJuegos.size(); i++) {
            getWinGeneroString += "Game " + (i + 1) + " : " + listJuegos.get(i).getGanadorGenero().getGenero() + "\n";
        }
        return getWinGeneroString;
    }
}