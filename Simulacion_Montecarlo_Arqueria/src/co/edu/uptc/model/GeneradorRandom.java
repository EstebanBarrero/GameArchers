package co.edu.uptc.model;
import java.security.SecureRandom;

//usa metodos cuadrados medios

public class GeneradorRandom {


    private long seed;
    private int min, max;

    public GeneradorRandom(int min, int max) {
        seed = new SecureRandom().nextLong();
        this.min = min;
        this.max = max;
    }

    private double generateRi() {
        long square = seed * seed;
        String squareStr = String.format("%012d", square);
        int size = squareStr.length();
        int start = (size - 8) / 2;
        int end = start + 4;
        String numberStr = squareStr.substring(start, end);
        double number = Double.parseDouble(numberStr) / 10000.0;
        seed = Long.parseLong(squareStr.substring(2, 10));
        return number;
    }
    public double generateNi() {
        return min + (max - min) * generateRi();
    }
}

