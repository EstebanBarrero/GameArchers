package co.edu.uptc.model;

/**
 * Enumeración que representa los diferentes tipos de tiros en el juego de arquería.
 */
public enum Tiro {
    CENTRAL(10), INTERMEDIO(9), EXTERIOR(8), ERROR(0);
    private int puntaje;
    /**
     * Constructor privado para asignar puntajes a cada tipo de tiro.
     * @param puntaje El puntaje asociado al tipo de tiro.
     */
    private Tiro(int puntaje) {
        this.puntaje = puntaje;
    }
    /**
     * Obtiene el puntaje asociado al tipo de tiro.
     * @return El puntaje del tipo de tiro.
     */
    public int getPuntaje() {
        return puntaje;
    }
}