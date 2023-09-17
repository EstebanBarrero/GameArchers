package co.edu.uptc.model;

import java.util.ArrayList;

/**
 * Clase que representa un juego de arquería entre dos equipos.
 */
public class Juego {
    private Equipo[] equipos;
    private int rondas;
    private Genero ganadorGenero;
    /**
     * Constructor de la clase Juego que inicializa los equipos y rondas.
     * @param equipo1 El primer equipo.
     * @param equipo2 El segundo equipo.
     */
    public Juego(Equipo equipo1, Equipo equipo2) {
        equipos = new Equipo[2];
        equipos[0] = equipo1;
        equipos[1] = equipo2;
        rondas = 1;
    }

    /**
     * Obtiene el puntaje total de un equipo.
     * @param position La posición del equipo (0 o 1).
     * @return El puntaje total del equipo en la partida.
     */
    public int scoreEquipo(int position) {
        return equipos[position].getPuntaje();
    }

    /**
     * Obtiene los equipos participantes en el juego.
     * @return Un arreglo de equipos.
     */
    public Equipo[] getEquipos() {
        return equipos;
    }
    /**
     * Incrementa el contador de rondas en una unidad.
     */
    public void incrementaRondas() {
        rondas++;
    }
    /**
     * Obtiene la lista de arqueros que participan en el juego.
     * @return Una lista de arqueros de ambos equipos.
     */
    public ArrayList<Arquero> getArqueros() {
        ArrayList<Arquero> arqueros = new ArrayList<Arquero>();
        for (Equipo equipo : equipos)
            for (Arquero arquero : equipo.getArquero())
                arqueros.add(arquero);
        return arqueros;
    }
    /**
     * Determina y registra al arquero ganador de la ronda actual.
     */
    public void arqueroGanador() {
        Arquero ganadorRonda = desempateRonda(equipos[0].mayorPuntajeArquero(),
                equipos[1].mayorPuntajeArquero());
        ganadorRonda.ganarExperiencia();
    }
    /**
     * Determina el arquero ganador en caso de empate en una ronda.
     * @param a El primer arquero en empate.
     * @param b El segundo arquero en empate.
     * @return El arquero ganador tras el desempate.
     */

    private Arquero desempateRonda(Arquero a, Arquero b) {
        Arquero winner = null;
        int shootA = a.getPuntosRonda();
        int shootB = b.getPuntosRonda();
        while (shootA == shootB) {
            shootA = a.generoDeTiro();
            shootB = b.generoDeTiro();
        }
        winner = shootA > shootB ? a : b;
        winner.incrementalRondaGanada();
        return winner;
    }

    /**
     * Realiza el sorteo de tiros para todos los arqueros en los equipos.
     */
    public void sorteoTiro() {
        for (Equipo equipo : equipos)
            equipo.darTiroArqueroSuerte(rondas);
    }

    /**
     * Obtiene al arquero ganador individual en base a las rondas ganadas.
     * @return El arquero ganador individual.
     */
    private Arquero ganadorIndividual() {
        Arquero a = equipos[0].mayorGanadorRonda();
        Arquero b = equipos[1].mayorGanadorRonda();
        return a.getRondasGanadas() > b.getRondasGanadas() ? a : b;
    }
    /**
     * Obtiene al arquero ganador en base a la experiencia acumulada.
     * @return El arquero con mayor experiencia acumulada.
     */
    public Arquero ganadorExperiencia() {
        Arquero a = equipos[0].mayorExperienciaA();
        Arquero b = equipos[1].mayorExperienciaA();
        return a.getExperiencia() > b.getExperiencia() ? a : b;
    }
    /**
     * Determina y registra al equipo ganador de la ronda actual.
     */
    public void equipoGanadorRonda() {
        int scoreTeam1 = equipos[0].obtainRoundScore();
        int scoreTeam2 = equipos[1].obtainRoundScore();
        equipos[0].setPuntaje(equipos[0].getPuntaje() + equipos[0].obtainRoundScore());
        equipos[1].setPuntaje(equipos[1].getPuntaje() + equipos[1].obtainRoundScore());
        Equipo equipoWinner = (scoreTeam1 == scoreTeam2) ? null : (scoreTeam1 > scoreTeam2) ? equipos[0] : equipos[1];
        if (equipoWinner != null)
            equipoWinner.aumentarRondasGanadas();
    }
    /**
     * Determina el género del arquero ganador individual.
     */
    public void ganadorGenero() {
        ganadorGenero = ganadorIndividual().getGenero();
    }
    /**
     * Obtiene al arquero con mayor contador de suerte en ambos equipos.
     * @return El arquero con el mayor contador de suerte.
     */
    public Arquero mayorSuerteArquero() {
        Arquero countLuckArqueroTeam1 = equipos[0].arqueroMayorSuerte();
        Arquero countLuckArqueroTeam2 = equipos[1].arqueroMayorSuerte();
        return (countLuckArqueroTeam1.getContadorSuerte() == countLuckArqueroTeam2.getContadorSuerte()) ? countLuckArqueroTeam1
                : (countLuckArqueroTeam1.getContadorSuerte() > countLuckArqueroTeam2.getContadorSuerte()) ? countLuckArqueroTeam1
                : countLuckArqueroTeam2;
    }
    /**
     * Realiza tiros extra de tres tiros para los arqueros de ambos equipos.
     */
    public void TiroExtraTresTiros() {
        equipos[0].tiroExtraConsecutivos();
        equipos[1].tiroExtraConsecutivos();
    }
    /**
     * Restablece los puntos de la ronda para todos los arqueros en ambos equipos.
     */
    public void regainRoundPoints() {
        for (Equipo equipo : equipos)
            equipo.restablecerRoundPoints();
    }
    /**
     * Obtiene el género del arquero ganador individual en el juego.
     * @return El género del arquero ganador individual.
     */
    public Genero getGanadorGenero() {
        return ganadorGenero;
    }
}