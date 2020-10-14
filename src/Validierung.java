public class Validierung {
    public static boolean validate(int column, char[][] grid){
        if (column < 0 || column > grid[0].length){
            return false;
        }
        if (' ' != grid[0][column]) return false;
        return true;
    }
}
