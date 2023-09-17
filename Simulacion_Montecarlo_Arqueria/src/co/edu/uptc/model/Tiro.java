package co.edu.uptc.model;


public enum Tiro {
    CENTRAL(10), INTERMEDIO(9), EXTERIOR(8), ERROR(0);
    private int puntaje;
    private Tiro(int puntaje) {
        this.puntaje = puntaje;
    }
    public int getPuntaje() {
        return puntaje;
    }
}