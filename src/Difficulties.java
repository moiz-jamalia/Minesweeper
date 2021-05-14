public class Difficulties {
    public static int[][] minen;
    public static char[][] board;


    public static void easy(){
        minen = new int[10][10];
        board = new char[9][9];
    }

    public static void medium(){
        minen = new int[40][40];
        board = new char[17][17];
    }

    public static void hard(){
        minen = new int[100][100];
        board = new char[31][17];
    }

    public static int[][] getMinen(){
        return minen;
    }

    public static char[][] getBoard() {
        return board;
    }
}
