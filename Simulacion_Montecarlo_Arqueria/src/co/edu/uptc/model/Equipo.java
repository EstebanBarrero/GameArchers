package co.edu.uptc.model;

import java.util.ArrayList;

public class Equipo {
    //Atributos ArrayList de tipo Arquero
    private ArrayList<Arquero> arqueros;
    //Atributos de tipo int o entero
    private int puntaje, codigo, rondasGanadas;

    /**
     * Constructor de la clase Equipo.
     * @param arqueros Una lista de arqueros que componen el equipo.
     * @param code El código identificador del equipo.
     */
    public Equipo(ArrayList<Arquero> arqueros, int code) {
        this.arqueros = arqueros;
        this.codigo = code;
        puntaje = 0;
        rondasGanadas = 0;
    }
    /**
     * Simula el tiro de un arquero seleccionado aleatoriamente del equipo basado en su suerte.
     * Actualiza el puntaje del equipo, el sorteo ganado y el contador de suerte del arquero.
     * @param round El número de ronda actual.
     */
    public void darTiroArqueroSuerte(int round) {
        Arquero arquero = getSuerteArquero();
        puntaje += arquero.generoDeTiro();
        arquero.incrementalSorteoGanado(round);
        arquero.AumentarContadorSuerte();
    }
    /**
     * Obtiene al arquero más afortunado del equipo basado en su nivel de suerte.
     * @return El arquero con el nivel de suerte más alto en el equipo.
     */
    private Arquero getSuerteArquero() {
        Arquero surteArquero = null;
        double suerteMax = 0;
        for (Arquero arquero : arqueros) {
            if (arquero.getSuerte() > suerteMax) {
                suerteMax = arquero.getSuerte();
                surteArquero = arquero;
            }
        }
        return surteArquero;
    }
    /**
     * Incrementa el contador de suerte del arquero más afortunado en el equipo.
     */
    public void increaseLuckToArcher() {
        getSuerteArquero().AumentarContadorSuerte();
    }
    /**
     * Simula tiros extra consecutivos para los arqueros que han ganado 3 sorteos consecutivos.
     * Actualiza el puntaje del equipo.
     */
    public void tiroExtraConsecutivos() {
        for (Arquero arquero : arqueros) {
            if (arquero.getGanadorSorteo() == 3)
                puntaje += arquero.generoDeTiro();
        }
    }
    /**
     * Obtiene al arquero con la mayor experiencia en el equipo.
     * @return El arquero con la mayor experiencia en el equipo.
     */
    public Arquero mayorExperienciaA() {
        Arquero mayorExperiencia = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            if (arqueros.get(i).getExperiencia() > mayorExperiencia.getExperiencia())
                mayorExperiencia = arqueros.get(i);
        return mayorExperiencia;
    }
    /**
     * Obtiene al arquero con el mayor puntaje en la ronda actual en el equipo.
     * @return El arquero con el mayor puntaje en la ronda actual en el equipo.
     */
    public Arquero mayorPuntajeArquero() {
        Arquero mayorPuntajeArquero = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            if (arqueros.get(i).getPuntosRonda() > mayorPuntajeArquero.getPuntosRonda())
                mayorPuntajeArquero = arqueros.get(i);
        return mayorPuntajeArquero;
    }
    /**
     * Obtiene al arquero con el mayor puntaje en la ronda actual en el equipo.
     * @return El arquero con el mayor puntaje en la ronda actual en el equipo.
     */
    public Arquero mayorGanadorRonda() {
        Arquero mayorGanadorRonda = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            if (arqueros.get(i).getRondasGanadas() > mayorGanadorRonda.getRondasGanadas())
                mayorGanadorRonda = arqueros.get(i);
        return mayorGanadorRonda;
    }

    /**
     * Calcula y devuelve el puntaje total de la ronda actual del equipo.
     * @return El puntaje total de la ronda actual del equipo.
     */
    public int obtainRoundScore() {
        int roundScore = 0;
        for (Arquero arquero : arqueros)
            roundScore += arquero.getPuntosRonda();
        return roundScore;
    }
    /**
     * Obtiene al arquero con el mayor contador de suerte en el equipo.
     * @return El arquero con el mayor contador de suerte en el equipo.
     */
    public Arquero arqueroMayorSuerte() {
        Arquero target = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            target = arqueros.get(i).getContadorSuerte() > target.getContadorSuerte() ? arqueros.get(i) : target;
        return target;
    }
    /**
     * Obtiene el puntaje total del equipo.
     * @return El puntaje total del equipo.
     */
    public int getPuntaje() {
        return puntaje;
    }
    /**
     * Obtiene el código identificador del equipo.
     * @return El código identificador del equipo.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el puntaje total del equipo.
     * @param puntaje El nuevo puntaje total del equipo.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    /**
     * Obtiene la lista de arqueros que componen el equipo.
     * @return Una lista de arqueros que conforman el equipo.
     */
    public ArrayList<Arquero> getArquero() {
        return arqueros;
    }

    /**
     * Incrementa el contador de rondas ganadas por el equipo en una unidad.
     */
    public void aumentarRondasGanadas() {
        rondasGanadas++;
    }
    /**
     * Restablece los puntos de la ronda de todos los arqueros del equipo.
     */
    public void restablecerRoundPoints() {
        for (Arquero arquero : arqueros)
            arquero.restablecerExperiencia();
    }
}