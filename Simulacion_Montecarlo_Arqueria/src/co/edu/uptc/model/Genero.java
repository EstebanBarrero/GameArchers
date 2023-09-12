package co.edu.uptc.model;

public enum Genero {
    FEMENINO('F'), MASCULINO('M');
    private char genero;
    private Genero(char genero) {
        this.genero = genero;
    }
    public char getGenero() {
        return genero;
    }
}