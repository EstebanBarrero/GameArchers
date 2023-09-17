package co.edu.uptc.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 */
public class Prueba {
    private int countGanadorRondaH, countGanadorRondaM, totalEquipo1, totalEquipo2;
    private ArrayList<Juego> listJuegos;
    private Equipo equipo1, equipo2;

    public Prueba(int games) {
        listJuegos = new ArrayList<Juego>();
        countGanadorRondaH = 0;
        countGanadorRondaM = 0;
        totalEquipo1 = 0;
        totalEquipo2 = 0;
        SimulationP(games);
    }

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
    private Genero totalWinGenero() {
        for (Juego juego : listJuegos)
            if (juego.getGanadorGenero().getGenero() == 'M')
                countGanadorRondaH++;
            else
                countGanadorRondaM++;
        return (countGanadorRondaH > countGanadorRondaM) ? Genero.MASCULINO : Genero.FEMENINO;
    }

    private void equipoGanador() {
        for (Juego juego : listJuegos) {
            totalEquipo1 += juego.scoreEquipo(0);
            totalEquipo2 += juego.scoreEquipo(1);
        }
    }
    public ArrayList<Arquero> getArqueroPorJuego() {
        ArrayList<Arquero> arqueros = new ArrayList<Arquero>();
        for (Juego juego : listJuegos)
            for (Arquero arquero : juego.getArqueros())
                arqueros.add(arquero);
        return arqueros;
    }
    public String getSuerteArquero() {
        String suerteArquerosString = "";
        for (int i = 0; i < listJuegos.size(); i++)
            suerteArquerosString += "Game " + (i + 1) + " : Archer " + listJuegos.get(i).mayorSuerteArquero().getCodigo()
                    + "\n";
        return suerteArquerosString;
    }

    public String getExperienciaArqueros() {
        String experienciaArqueroSt = "";
        for (int i = 0; i < listJuegos.size(); i++) {
            experienciaArqueroSt += "Game " + (i + 1) + " : Archer "
                    + listJuegos.get(i).ganadorExperiencia().getCodigo() + "\n";
        }
        return experienciaArqueroSt;
    }

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

    public String getTotalWinGenero() {
        return totalWinGenero().getGenero() == 'F' ? "FEMALE" : "MALE";
    }

    private void equiposP() {
        equipo1 = new Equipo(new ArrayList<Arquero>(
                Arrays.asList(new Arquero(1), new Arquero(2), new Arquero(3), new Arquero(4), new Arquero(5))), 1);
        equipo2 = new Equipo(new ArrayList<Arquero>(
                Arrays.asList(new Arquero(6), new Arquero(7), new Arquero(8), new Arquero(9), new Arquero(10))), 2);
    }
    public String getWinGenero() {
        String getWinGeneroString = "";
        for (int i = 0; i < listJuegos.size(); i++) {
            getWinGeneroString += "Game " + (i + 1) + " : " + listJuegos.get(i).getGanadorGenero().getGenero() + "\n";
        }
        return getWinGeneroString;
    }


}