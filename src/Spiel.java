import java.util.Random;
import java.util.Scanner;

public class Spiel {
    static Validierung validate = new Validierung();
    static Ausgabe display = new Ausgabe();
    static Pruefung isWinner = new Pruefung();



    public static void Felder(){
        Scanner in = new Scanner(System.in);
        Random ai = new Random();

        char[][] spielfeld = new char[6][7];

        for (int row = 0; row < spielfeld.length; row++){
            for (int col = 0; col < spielfeld[0].length; col++){
                spielfeld[row][col] = ' ';
            }
        }
        int turn = 1;
        char player = 'R';
        char AI = 'B';
        boolean winner = false;

        while (!winner && turn <= 42){

            boolean validPlay;
            int play;
            int aiplay;

            do {
                display.display(spielfeld);
                System.out.print("Spieler Rot wähle eine Spalte aus: ");
                play = in.nextInt();
                aiplay = ai.nextInt(7);

                validPlay = validate.validate(play,spielfeld);

            }while (!validPlay);


            for (int row = spielfeld.length-1; row >= 0; row--){
                if(spielfeld[row][play] == ' '){
                    spielfeld[row][play] = player;
                    break;
                }
            }
            for (int row = spielfeld.length-1; row >= 0; row--){
                if(spielfeld[row][aiplay] == ' '){
                    spielfeld[row][aiplay] = AI;
                    break;
                }
            }
            winner = isWinner.isWinner(player,spielfeld);
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
}

