package co.edu.uptc.model;


import java.util.ArrayList;

public class Generator{

    private int seed;
    private ArrayList<Double> niValues;
    private ArrayList<Double> riValues;
    private ArrayList<Integer> xiValues;
    private ArrayList<Integer> centers;
    private int min;
    private int max;
    private int numAmount;

    public Generator(int seed, int min, int max, int numAmount) {
        this.seed = seed;
        this.niValues = new ArrayList<>();
        this.riValues = new ArrayList<>();
        this.xiValues = new ArrayList<>();
        this.centers = new ArrayList<>();
        this.min = min;
        this.max = max;
        this.numAmount = numAmount;
    }

    public void generateRandoms() {
        int seed = this.seed;
        int len_seed = Integer.toString(this.seed).length();
        for (int i = 0; i < numAmount; i++) {
            this.xiValues.add(seed);
            int xi2 = seed * seed;
            int center = getCenter(String.valueOf(xi2));
            this.centers.add(center);
            double ri = center / getDivNum(len_seed);
            this.riValues.add(ri);
            double ni = genNiNumber(ri);
            this.niValues.add(ni);
            seed = center;
        }
    }

    public Double genNiNumber(Double ri){
        return (this.min+((this.max-this.min)*ri));
    };

    public int getCenter(String num) {
        int len_seed = String.valueOf(this.seed).length();
        int len_num = String.valueOf(num).length();
        String padded = "";

        if (len_num == (len_seed * 2)) {
            padded = num;
        } else if (num.length() < len_seed * 2) {
            while (padded.length() < len_seed * 2 - len_num) {
                padded = "0" + padded;
            }
            padded = padded + num;
        }

        int startIndex = len_seed / 2;
        int endIndex = startIndex + len_seed;  // Corrected calculation of endIndex
        String center = padded.substring(startIndex, endIndex);

        return Integer.parseInt(center);
    }

    public Double getDivNum(int length){
        String num = "";
        for (int i = 0; i < length; i++) {
            num+="0";
        }
        num ="1" + num;
        return Double.valueOf(num);
    }

    public ArrayList<Double> getNiValues() {
        return niValues;
    }

    public ArrayList<Double> getRiValues() {
        return riValues;
    }

    public ArrayList<Integer> getXiValues() {
        return xiValues;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumAmount() {
        return numAmount;
    }

    public void setNumAmount(int numAmount) {
        this.numAmount = numAmount;
    }

    @Override
    public String toString() {
        return "MiddleSquareGenerator{" +
                "seed=" + seed +
                ", niValues=" + niValues +
                ", riValues=" + riValues +
                ", xiValues=" + xiValues +
                ", min=" + min +
                ", max=" + max +
                ", numAmount=" + numAmount +
                '}';
    }

    public static void main(String[] args) {
       Generator mc = new Generator(3456, 8, 10, 12);
        mc.generateRandoms();
        for (int i = 0; i < 12; i++) {
            System.out.println(" " + mc.xiValues.get(i) + " " + mc.riValues.get(i) + " " + mc.niValues.get(i) + "\n");
        }
    }
}
