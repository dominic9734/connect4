public class Ausgabe{
    public static void display(char[][] grid){
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
        for (char[] chars : grid) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(chars[col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
    }



}

