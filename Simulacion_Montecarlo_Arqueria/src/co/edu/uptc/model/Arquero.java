package co.edu.uptc.model;

public class Arquero {
        private int codigo;
        private Genero genero;
        private int resistenciaInicial;
        private int resistenciaOriginal;
        private int resistencia;
        private int experiencia;
        private double suerte;
        private int puntos;
        private int puntosRonda;
        private int rondasGanadas;
        private int ganadorSorteo;
        private int ganadorSorteoConsecutivo;
        private int contadorSuerte;
        private GeneratorPseudoRandomNumber generator;


        public Arquero(int codigo) {
            this.codigo = codigo;
            generator = new GeneratorPseudoRandomNumber(0, 1);
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
    private Genero generateGenero() {
        return generator.generateNi() >= 0.5 ? Genero.FEMENINO : Genero.MASCULINO;
    }

    private int generateResistencia() {
            int resistenciaOriginal= (int) ((generator.generateNi() * (45 - 25 + 1)) + 25);
        return (resistenciaOriginal) ;
    }
    public double generateSuerte() {
        return generator.generateNi() * 2 + 1;
    }
        public int getCodigo() {
            return codigo;
        }
        public Genero getGenero() {
            return genero;
        }
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
    private void restablecerSuerte() {
        suerte = generateSuerte();
    }
    private void regainResistanceRound() {
        resistencia = resistenciaInicial - generateFatiga();
        resistenciaInicial = resistencia;
    }
    public int generateFatiga() {
        return (int) (generator.generateNi() * 2) + 1;
    }
        public int generoDeTiro() {
            return (genero.getGenero() == 'M') ? tiroHombre() : tiroMujer();
        }
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
    public void ganarExperiencia() {
        experiencia += 3;
    }
    public void restablecerExperiencia() {
        puntosRonda = 0;
    }
    public void disminuirResistenciaExperiencia() {
        this.resistencia--;
    }
    public void AumentarContadorSuerte() {
        contadorSuerte++;
    }
    public void incrementalRondaGanada() {
        rondasGanadas++;
    }

    }
