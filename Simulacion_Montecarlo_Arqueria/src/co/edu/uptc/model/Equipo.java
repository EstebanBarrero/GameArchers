package co.edu.uptc.model;

import java.util.ArrayList;

public class Equipo {

    private ArrayList<Arquero> arqueros;
    private int puntaje;
    private int codigo;
    private int rondasGanadas;

    public Equipo(ArrayList<Arquero> arqueros, int code) {
        this.arqueros = arqueros;
        this.codigo = code;
        puntaje = 0;
        rondasGanadas = 0;
    }
    public void darTiroArqueroSuerte(int round) {
        Arquero arquero = getSuerteArquero();
        puntaje += arquero.generoDeTiro();
        arquero.incrementalSorteoGanado(round);
        arquero.AumentarContadorSuerte();
    }
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
    public void increaseLuckToArcher() {
        getSuerteArquero().AumentarContadorSuerte();
    }

    public void tiroExtraConsecutivos() {
        for (Arquero arquero : arqueros) {
            if (arquero.getGanadorSorteo() == 3)
                puntaje += arquero.generoDeTiro();
        }
    }
    public Arquero mayorExperienciaA() {
        Arquero mayorExperiencia = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            if (arqueros.get(i).getExperiencia() > mayorExperiencia.getExperiencia())
                mayorExperiencia = arqueros.get(i);
        return mayorExperiencia;
    }
    public Arquero mayorPuntajeArquero() {
        Arquero mayorPuntajeArquero = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            if (arqueros.get(i).getPuntosRonda() > mayorPuntajeArquero.getPuntosRonda())
                mayorPuntajeArquero = arqueros.get(i);
        return mayorPuntajeArquero;
    }
    public Arquero mayorGanadorRonda() {
        Arquero mayorGanadorRonda = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            if (arqueros.get(i).getRondasGanadas() > mayorGanadorRonda.getRondasGanadas())
                mayorGanadorRonda = arqueros.get(i);
        return mayorGanadorRonda;
    }

    public int obtainRoundScore() {
        int roundScore = 0;
        for (Arquero arquero : arqueros)
            roundScore += arquero.getPuntosRonda();
        return roundScore;
    }
    public Arquero arqueroMayorSuerte() {
        Arquero target = arqueros.get(0);
        for (int i = 1; i < arqueros.size(); i++)
            target = arqueros.get(i).getContadorSuerte() > target.getContadorSuerte() ? arqueros.get(i) : target;
        return target;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public ArrayList<Arquero> getArquero() {
        return arqueros;
    }

    public void aumentarRondasGanadas() {
        rondasGanadas++;
    }
    public void restablecerRoundPoints() {
        for (Arquero arquero : arqueros)
            arquero.restablecerExperiencia();
    }
}