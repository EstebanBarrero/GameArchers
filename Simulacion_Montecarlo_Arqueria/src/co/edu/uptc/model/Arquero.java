package co.edu.uptc.model;

public class Arquero {
    //Atributos de tipo int o entero
        private int codigo, resistenciaInicial, resistenciaOriginal, resistencia, experiencia;
    //Atributos de tipo Genero
        private Genero genero;
    //Atributos de tipo double
        private double suerte;
    //Atributos de tipo int o entero
        private int puntos, puntosRonda, rondasGanadas, ganadorSorteo, ganadorSorteoConsecutivo, contadorSuerte;
    //Atributos de GeneradorRandom
        private GeneradorRandom generator;

    /**
     * Metodo Constructor de la clase Arquero, en donde se inicializan las variables y atributos de codigo
     * @param codigo identificador de cada arquero
     */
        public Arquero(int codigo) {
            this.codigo = codigo;
            generator = new GeneradorRandom(0, 1);
            genero = generateGenero();
            resistenciaInicial = generateResistencia();
            resistenciaOriginal=resistenciaInicial;
            suerte = generateSuerte();
            resistencia = resistenciaInicial;
            experiencia = 10;
            puntos = 0;
            puntosRonda = 0;
            rondasGanadas = 0;
            ganadorSorteo = 0;
            ganadorSorteoConsecutivo = -1;
            contadorSuerte = 0;
        }

    /**
     * Metodo generador de genero
     * @return si el genero es >= a 0.5, entonces se toma de genero femenino, sino masculino
     */
    private Genero generateGenero() {
        return generator.generateNi() >= 0.5 ? Genero.FEMENINO : Genero.MASCULINO;
    }

    /**
     * devuelve un valor aleatorio de resistencia en el rango de 25 a 45.
     * @return Un valor aleatorio de resistencia dentro del rango especificado.
     */
    private int generateResistencia() {
            int resistenciaOriginal= (int) ((generator.generateNi() * (45 - 25 + 1)) + 25);
        return (resistenciaOriginal) ;
    }
    /**
     * devuelve un valor aleatorio de suerte en el rango de 1 a 3.
     * @return Un valor aleatorio de suerte dentro del rango especificado.
     */
    public double generateSuerte() {
        return generator.generateNi() * 2 + 1;
    }
    public int getCodigo() {
        return codigo;
    }
    public Genero getGenero() {
        return genero;
    }
    /**
     * Obtiene el valor actual de resistencia del arquero.
     * @return El valor actual de resistencia del arquero.
     */
    public int getResistencia() {
        return resistencia;
    }

    public int getExperiencia() {
        return experiencia;
    }
    public double getSuerte() {
        return suerte;
    }
    public int getPuntos() {
        return puntos;
    }
    public int getRondasGanadas() {
        return rondasGanadas;
    }
    public int getGanadorSorteo() {
        return ganadorSorteo;
    }
    public int getPuntosRonda() {
        return puntosRonda;
    }
    public int getContadorSuerte() {
        return contadorSuerte;
    }

    /**
     * Realiza tiros repetidos hasta que la resistencia llega a cero, acumulando puntos y ajustando la resistencia.
     * Luego, restablece la resistencia de la ronda y la suerte.
     */
        public void tiro() {
            int tiro = 0;
            while (this.resistencia > 0) {
                tiro = generoDeTiro();
                puntos += tiro;
                puntosRonda += tiro;
                resistencia -= 5;
            }
            regainResistanceRound();
            restablecerSuerte();

        }
    /**
     * Restablece el valor de la suerte del arquero a un nuevo valor aleatorio.
     */
    private void restablecerSuerte() {
        suerte = generateSuerte();
    }
    /**
     * Restablece la resistencia del arquero al valor inicial de la ronda y ajusta la resistencia inicial
     * considerando la fatiga generada.
     */
    private void regainResistanceRound() {
        resistencia = resistenciaInicial - generateFatiga();
        resistenciaInicial = resistencia;
    }
    /**
     * Genera y devuelve un valor aleatorio que representa la fatiga del arquero.
     * @return Un valor aleatorio que indica la fatiga del arquero.
     */
    public int generateFatiga() {
        return (int) (generator.generateNi() * 2) + 1;
    }
    /**
     * Determina el tipo de tiro basado en el género del arquero y realiza el tiro correspondiente.
     * @return El valor del tiro realizado (dependiendo del género: tiroHombre() o tiroMujer()).
     */
    public int generoDeTiro() {
        return (genero.getGenero() == 'M') ? tiroHombre() : tiroMujer();
    }
    /**
     * Simula un tiro realizado por un arquero de género masculino y devuelve el puntaje obtenido.
     * @return El puntaje obtenido en el tiro.
     */
    private int tiroHombre() {
        int score = 0;
        double random = generator.generateNi();
        if (random > 0 && random <= 0.2)
            score = Tiro.CENTRAL.getPuntaje();
        else if (random > 0.2 && random <= 0.53)
            score = Tiro.INTERMEDIO.getPuntaje();
        else if (random > 0.53 && random <= 0.93)
            score = Tiro.EXTERIOR.getPuntaje();
        else if (random > 0.93 && random <= 1)
            score = Tiro.ERROR.getPuntaje();
        return score;
    }
    /**
     * Simula un tiro realizado por un arquero de género femenino y devuelve el puntaje obtenido.
     * @return El puntaje obtenido en el tiro.
     */
    private int tiroMujer() {
        double random = generator.generateNi();
        int score = 0;
        if (random > 0 && random <= 0.3)
            score = Tiro.CENTRAL.getPuntaje();
        else if (random > 0.3 && random <= 0.68)
            score = Tiro.INTERMEDIO.getPuntaje();
        else if (random > 0.68 && random <= 0.95)
            score = Tiro.EXTERIOR.getPuntaje();
        else if (random > 0.95 && random <= 1)
            score = Tiro.ERROR.getPuntaje();
        return score;
    }
    /**
     * Incrementa el contador de sorteos ganados consecutivos y actualiza el número de ronda.
     * @param round El número de ronda actual.
     */
    public void incrementalSorteoGanado(int round) {
        if (ganadorSorteoConsecutivo == -1) {
            ganadorSorteoConsecutivo = round;
            ganadorSorteo++;
        } else if (ganadorSorteoConsecutivo + 1 == round) {
            ganadorSorteoConsecutivo = round;
            ganadorSorteo++;
        } else {
            ganadorSorteo = 1;
            ganadorSorteoConsecutivo = round;
        }
    }

    /**
     * Incrementa la experiencia del arquero en 3 puntos.
     */
    public void ganarExperiencia() {
        experiencia += 3;
    }
    public void restablecerExperiencia() {
        puntosRonda = 0;
    }
    /**
     * Restablece los puntos de la ronda actual a cero.
     */
    public void disminuirResistenciaExperiencia() {
        this.resistencia--;
    }
    /**
     * Incrementa el contador de suerte en 1 unidad.
     */
    public void AumentarContadorSuerte() {
        contadorSuerte++;
    }
    /**
     * Incrementa el contador de rondas ganadas en 1 unidad.
     */
    public void incrementalRondaGanada() {
        rondasGanadas++;
    }
}