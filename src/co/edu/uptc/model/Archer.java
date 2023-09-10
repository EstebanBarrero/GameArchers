package co.edu.uptc.model;

public class Archer {
        private int code;
        private Gender gender;
        private int initialResistance;
        private int resistance;
        private int experience;
        private double luck;
        private int points;
        private int roundPoints;
        private int wonRounds;

        private int wonRaffles;
        private int consecutiveWonRaflleNumberRound;
        private int countLuck;
        private MiddleSquare generator;

        public Archer(int code) {
            generator = new MiddleSquare(0, 1);
            this.code = code;
            gender = generateGender();
            initialResistance = generateResistance();
            resistance = initialResistance;
            experience = 10;
            luck = generateLuck();
            points = 0;
            roundPoints = 0;
            wonRounds = 0;
            wonRaffles = 0;
            consecutiveWonRaflleNumberRound = -1;
            countLuck = 0;
        }

        public int getCode() {
            return code;
        }
        public Gender getGender() {
            return gender;
        }

        public int getResistance() {
            return resistance;
        }

        public int getExperience() {
            return experience;
        }

        public double getLuck() {
            return luck;
        }

        public int getPoints() {
            return points;
        }

        public int getWonRounds() {
            return wonRounds;
        }

        public int getWonRaffles() {
            return wonRaffles;
        }

        public int getRoundPoints() {
            return roundPoints;
        }

        public int getCountLuck() {
            return countLuck;
        }

        public void launch() {
            int launch = 0;
            while (this.resistance > 0) {
                launch = individualLaunch();
                points += launch;
                roundPoints += launch;
                resistance -= 5;
            }
            regainResistanceRound();
            regainLuck();
        }


        public int individualLaunch() {
            return (gender.getGender() == 'M') ? throwingMale() : throwingFemale();
        }


        private int throwingMale() {
            int score = 0;
            double random = generator.generateNi();
            if (random > 0 && random <= 0.2)
                score = Shoot.CENTRAL.getScore();
            else if (random > 0.2 && random <= 0.53)
                score = Shoot.INTERMEDIATE.getScore();
            else if (random > 0.53 && random <= 0.93)
                score = Shoot.OUTSIDE.getScore();
            else if (random > 0.93 && random <= 1)
                score = Shoot.ERROR.getScore();
            return score;
        }

        private int throwingFemale() {
            double random = generator.generateNi();
            int score = 0;
            if (random > 0 && random <= 0.3)
                score = Shoot.CENTRAL.getScore();
            else if (random > 0.3 && random <= 0.68)
                score = Shoot.INTERMEDIATE.getScore();
            else if (random > 0.68 && random <= 0.95)
                score = Shoot.OUTSIDE.getScore();
            else if (random > 0.95 && random <= 1)
                score = Shoot.ERROR.getScore();
            return score;
        }


        public void increaseWonRounds() {
            wonRounds++;
        }

        public void increaseWonRaffles(int round) {
            if (consecutiveWonRaflleNumberRound == -1) {
                consecutiveWonRaflleNumberRound = round;
                wonRaffles++;
            } else if (consecutiveWonRaflleNumberRound + 1 == round) {
                consecutiveWonRaflleNumberRound = round;
                wonRaffles++;
            } else {
                wonRaffles = 1;
                consecutiveWonRaflleNumberRound = round;
            }
        }

        private Gender generateGender() {
            return generator.generateNi() >= 0.5 ? Gender.MALE : Gender.FEMALE;
        }
        private int generateResistance() {
            return (int) (generator.generateNi() * (45 - 25 + 1)) + 25;
        }

        private double generateLuck() {
            return generator.generateNi() * 2 + 1;
        }

        private void regainLuck() {
            luck = generateLuck();
        }

        private void regainResistanceRound() {
            resistance = initialResistance - generateFatigue();
            initialResistance = resistance;
        }

        public void regainResistance() {
            resistance = initialResistance;
        }
        public int generateFatigue() {
            return (int) (generator.generateNi() * 2) + 1;
        }

        public void gainExperience() {
            experience += 3;
        }

        public void decreaseResistanceByExperience() {
            this.resistance--;
        }

        public void regainRoundPoints() {
            roundPoints = 0;
        }

        public void increaseCountLuck() {
            countLuck++;
        }

        public void regainCountLuck() {
            countLuck = 0;
        }
    }
