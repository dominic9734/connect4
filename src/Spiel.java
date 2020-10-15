import java.util.Random;
import java.util.Scanner;

public class Spiel {
    public Spielfeld spielfeld = new Spielfeld();//Neues Objekt Spielfeld

    public void Start() {
        Scanner in = new Scanner(System.in);
        Random ai = new Random();

        int turn = 1;
        char player = 'R';
        char AI = 'B';
        boolean winner = false;
        boolean running = false;

        while (!running) {
            while (!winner && turn <= 42) {

                boolean validPlay;
                int play;
                int aiplay;

                do {
                    spielfeld.display();
                    System.out.print("Spieler Rot wähle eine Spalte aus: ");
                        while (!in.hasNextInt()) {
                            String input = in.next();
                            System.out.printf("\"%s\" ist keine gültige Zahl!\n", input);
                            System.out.print("Spieler Rot wähle eine Spalte aus: ");
                        }
                    play = in.nextInt() - 1;
                    aiplay = ai.nextInt(7);

                    int playTemp = play + 1;
                    if (playTemp <= 0 || playTemp > 7) {
                        System.err.println("Bitte gebe eine gültige Zahl ein!");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        running = false;
                    }
                    validPlay = spielfeld.validate(play);

                } while (!validPlay);
                {
                    spielfeld.setValueIntoField(play, player);
                    spielfeld.setValueIntoFieldPlayer(aiplay, AI);

                    winner = this.isWinner(player);
                    turn++;
                }
            }

            if (winner) {
                if (player == 'R') {
                    System.out.println("Rot gewinnt");
                    break;
                } else {
                    System.out.println("Blau gewinnt");
                    break;
                }
            } else {
                System.out.println("Unentschieden");
                break;
            }
        }
    }

    public boolean isWinner(char player)
    {
        return spielfeld.has4(player);
    }
}

