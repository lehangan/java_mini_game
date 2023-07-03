import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    public Player[] players = new Player[4];
    public Dice[] dices = new Dice[4];
    public boolean stateEnd = false;
    public Referee referee = new Referee();

    public Game() {
        setPlayer();
    }

    public void setPlayer() {
        System.out.println("Choose number player in this game ");
        Scanner scanner = new Scanner(System.in);

        int numTruePlayer = scanner.nextInt();
        if (numTruePlayer < 4 && numTruePlayer >= 0) {
            for (int i = 0; i <= numTruePlayer - 1; i++) {
                System.out.println("Player " + (i + 1) + " name:");
                String name = scanner.next();
                players[i] = new TruePlayer(name);
            }
            for (int i = numTruePlayer; i <= 3; i++) {
                int index = i + 1;
                players[i] = new VirtualPlayer("virtual " + index);
            }
            System.out.println("-----------------------STARTGAME----------------------");
        } else if (numTruePlayer == 4) {
            for (int i = 0; i <= numTruePlayer - 1; i++) {
                int index = i + 1;
                System.out.println("Player " + index + " name:");
                String name = scanner.next();
                players[i] = new TruePlayer(name);
            }
            System.out.println("-----------------------STARTGAME----------------------");
        } else {
            System.out.println("You need to choose number between 1-4:");
            setPlayer();
        }
        scanner.close();
    }

    public void setDice() throws NumberDiceException {
        try {
            for (int i = 0; i <= 3; i++)
                dices[i] = new Dice();
        } catch (NumberDiceException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void randomDice() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        Collections.shuffle(numbers);
        for (int i = 0; i <= 3; i++) {
            players[i].setDice(dices[numbers.get(i) - 1]);
        }
    }

    public void roundGame() throws NumberDiceException {
        try {
            while (stateEnd != true) {
                randomDice();
                for (int i = 0; i <= 3; i++) {
                    int rollNum = players[i].rollDice();
                    int old_point = players[i].getPoint();
                    int new_point = referee.calPoint(players[i], rollNum);
                    System.out.println("Player " + players[i].getName() + " rolls " + rollNum + " and old point " + old_point + " new point " + players[i].getPoint());
                    if (new_point == 21) {
                        players[i].winGame = true;
                        for (int j = 0; j <= 3; j++)
                            referee.stateEnd(players[j]);
                        stateEnd = true;
                        break;
                    }
                }
            }
            System.out.println("--------------------------END-----------------------");
        } catch (NumberDiceException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NumberDiceException {
        try {
            Game game = new Game();
            game.setDice();
            game.roundGame();
        } catch (NumberDiceException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}