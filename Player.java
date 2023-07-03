import java.util.Random;

abstract class Player {
    private String name;
    private int point;
    public Dice dice;
    public boolean winGame = false;

    public Player(String name) {
        setName(name);
        setPoint(0);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public int rollDice() throws NumberDiceException {
        Random random = new Random();
        int rollHighPro = this.dice.pro20;
        int rollNum = random.nextInt(6) + 1;
        double randomValue = random.nextDouble(); // in bound 0-1
        if (randomValue <= 0.2) {
            rollNum = rollHighPro;
        }
        if (rollNum > 6 || rollNum <= 0) {
            throw new NumberDiceException("Number " + rollNum + " roll is not in range ");
        }
        return rollNum;
    }

    public abstract void loseGame();

}