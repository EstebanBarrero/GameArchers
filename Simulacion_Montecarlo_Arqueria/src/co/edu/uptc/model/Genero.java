package co.edu.uptc.model;

/**
 * Enumeración que representa los géneros.
 */
public enum Genero {
    FEMENINO('F'), MASCULINO('M');
    private char genero;
    /**
     * Constructor privado para establecer el género.
     * @param genero El carácter que representa el género.
     */
    private Genero(char genero) {
        this.genero = genero;
    }
    /**
     * Obtiene el carácter que representa el género.
     * @return El carácter que representa el género.
     */
    public char getGenero() {
        return genero;
    }
}