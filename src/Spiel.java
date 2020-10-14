import java.util.Random;
import java.util.Scanner;

public class Spiel {
    public Spielfeld spielfeld = new Spielfeld();



    public void Felder(){
        Scanner in = new Scanner(System.in);
        Random ai = new Random();

        //char[][] spielfeld = new char[6][7];


        int turn = 1;
        char player = 'R';
        char AI = 'B';
        boolean winner = false;

        while (!winner && turn <= 42){

            boolean validPlay;
            int play;
            int aiplay;


            do {
                spielfeld.display();
                System.out.print("Spieler Rot wähle eine Spalte aus: ");
                play = in.nextInt();
                aiplay = ai.nextInt(7);

                validPlay = spielfeld.validate(play);

            }while (!validPlay);


            spielfeld.setValueIntoFieldComputer(play, player);
            /*for (int row = spielfeld.feld.length-1; row >= 0; row--){
                if(spielfeld.feld[row][play] == ' '){
                    spielfeld.feld[row][play] = player;
                    break;
                }
            }
                        spielfeld.setValueIntoFieldPlayer(play,player);
*/
            for (int row = spielfeld.feld.length-1; row >= 0; row--){
                if(spielfeld.feld[row][aiplay] == ' '){
                    spielfeld.feld[row][aiplay] = AI;
                    break;
                }
            }
            winner = this.isWinner(player);
            turn++;
        }


        if (winner){
            if (player=='R'){
                System.out.println("Rot gewinnt");
            }else{
                System.out.println("Blau gewinnt");
            }
        }else{
            System.out.println("Unentschieden");
        }
    }

    public boolean isWinner(char player)
    {
        return spielfeld.has4(player);
    }
}

