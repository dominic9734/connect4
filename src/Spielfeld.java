public class Spielfeld {
    public char[][] feld = new char[6][7];

    public void display(){
        System.out.println("   _____                            _     _  _   \n" +
                "  / ____|                          | |   | || |  \n" +
                " | |     ___  _ __  _ __   ___  ___| |_  | || |_ \n" +
                " | |    / _ \\| '_ \\| '_ \\ / _ \\/ __| __| |__   _|\n" +
                " | |___| (_) | | | | | | |  __/ (__| |_     | |  \n" +
                "  \\_____\\___/|_| |_|_| |_|\\___|\\___|\\__|    |_|  \n" +
                "                                                 \n" +
                "                                                 ");
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (char[] chars : feld) {
            System.out.print("|");
            for (int col = 0; col < feld[0].length; col++) {
                System.out.print(chars[col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
    }

    public Spielfeld()
    {
        for (int row = 0; row < feld.length; row++){
            for (int col = 0; col < feld[0].length; col++){
                feld[row][col] = ' ';
            }
        }
    }

    public boolean has4(char player) {

        for (char[] chars : feld) {
            for (int col = 0; col < feld[0].length - 3; col++) {
                if (chars[col] == player &&
                        chars[col + 1] == player &&
                        chars[col + 2] == player &&
                        chars[col + 3] == player) {
                    return true;
                }
            }
        }
        for(int row = 0; row < feld.length - 3; row++){
            for(int col = 0; col < feld[0].length; col++){
                if (feld[row][col] == player   &&
                        feld[row+1][col] == player &&
                        feld[row+2][col] == player &&
                        feld[row+3][col] == player){
                    return true;
                }
            }
        }
        for(int row = 3; row < feld.length; row++){
            for(int col = 0; col < feld[0].length - 3; col++){
                if (feld[row][col] == player   &&
                        feld[row-1][col+1] == player &&
                        feld[row-2][col+2] == player &&
                        feld[row-3][col+3] == player){
                    return true;
                }
            }
        }
        for(int row = 0; row < feld.length - 3; row++){
            for(int col = 0; col < feld[0].length - 3; col++){
                if (feld[row][col] == player   &&
                        feld[row+1][col+1] == player &&
                        feld[row+2][col+2] == player &&
                        feld[row+3][col+3] == player){
                    return true;
                }
            }
        }
        return false;
    }

    public void setValueIntoFieldComputer(int aiplay, char AI){
        for (int row = feld.length-1; row >= 0; row--){
            if(feld[row][aiplay] == ' '){
                feld[row][aiplay] = AI;
                break;
            }
        }
    }
    /*
    public void setValueIntoFieldPlayer(int play, char player){
        for (int row = feld.length-1; row >= 0; row--){
            if(feld[row][play] == ' '){
                feld[row][play] = player;
                break;
            }
        }
    }
     */

    public boolean validate(int column){
        if (column < 0 || column > feld[0].length){
            return false;
        }
        if (' ' != feld[0][column]) return false;
        return true;
    }
}
