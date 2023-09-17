package co.edu.uptc.model;

import java.util.ArrayList;


public class Juego {

    private Equipo[] equipos;

    private int rondas;

    private Genero ganadorGenero;

    public Juego(Equipo equipo1, Equipo equipo2) {
        equipos = new Equipo[2];
        equipos[0] = equipo1;
        equipos[1] = equipo2;
        rondas = 1;
    }
    public int scoreEquipo(int position) {
        return equipos[position].getPuntaje();
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void incrementaRondas() {
        rondas++;
    }
    public ArrayList<Arquero> getArqueros() {
        ArrayList<Arquero> arqueros = new ArrayList<Arquero>();
        for (Equipo equipo : equipos)
            for (Arquero arquero : equipo.getArquero())
                arqueros.add(arquero);
        return arqueros;
    }
    public void arqueroGanador() {
        Arquero ganadorRonda = desempateRonda(equipos[0].mayorPuntajeArquero(),
                equipos[1].mayorPuntajeArquero());
        ganadorRonda.ganarExperiencia();
    }
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
    public void sorteoTiro() {
        for (Equipo equipo : equipos)
            equipo.darTiroArqueroSuerte(rondas);
    }

    private Arquero ganadorIndividual() {
        Arquero a = equipos[0].mayorGanadorRonda();
        Arquero b = equipos[1].mayorGanadorRonda();
        return a.getRondasGanadas() > b.getRondasGanadas() ? a : b;
    }
    public Arquero ganadorExperiencia() {
        Arquero a = equipos[0].mayorExperienciaA();
        Arquero b = equipos[1].mayorExperienciaA();
        return a.getExperiencia() > b.getExperiencia() ? a : b;
    }
    public void equipoGanadorRonda() {
        int scoreTeam1 = equipos[0].obtainRoundScore();
        int scoreTeam2 = equipos[1].obtainRoundScore();
        equipos[0].setPuntaje(equipos[0].getPuntaje() + equipos[0].obtainRoundScore());
        equipos[1].setPuntaje(equipos[1].getPuntaje() + equipos[1].obtainRoundScore());
        Equipo equipoWinner = (scoreTeam1 == scoreTeam2) ? null : (scoreTeam1 > scoreTeam2) ? equipos[0] : equipos[1];
        if (equipoWinner != null)
            equipoWinner.aumentarRondasGanadas();
    }
    public void ganadorGenero() {
        ganadorGenero = ganadorIndividual().getGenero();
    }
    public Arquero mayorSuerteArquero() {
        Arquero countLuckArqueroTeam1 = equipos[0].arqueroMayorSuerte();
        Arquero countLuckArqueroTeam2 = equipos[1].arqueroMayorSuerte();
        return (countLuckArqueroTeam1.getContadorSuerte() == countLuckArqueroTeam2.getContadorSuerte()) ? countLuckArqueroTeam1
                : (countLuckArqueroTeam1.getContadorSuerte() > countLuckArqueroTeam2.getContadorSuerte()) ? countLuckArqueroTeam1
                : countLuckArqueroTeam2;
    }
    public void TiroExtraTresTiros() {
        equipos[0].tiroExtraConsecutivos();
        equipos[1].tiroExtraConsecutivos();
    }
    public void regainRoundPoints() {
        for (Equipo equipo : equipos)
            equipo.restablecerRoundPoints();
    }
    public Genero getGanadorGenero() {
        return ganadorGenero;
    }
}