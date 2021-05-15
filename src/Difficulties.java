public class Difficulties {
    public static int AmountMines;
    public static char XBoard;
    public static char YBoard;


    public static void easy(){
        // Mines 10
        // Board 8x8
        AmountMines = 10;
        XBoard = 9;
        YBoard = 9;
    }

    public static void medium(){
        // Mines 40
        // Board 16x16
        AmountMines = 40;
        XBoard = 17;
        YBoard = 17;
    }

    public static void hard(){
        // Mines 90
        // Board 30x16
        AmountMines = 90;
        XBoard = 31;
        YBoard = 17;
    }

    public static int getAmountMines(){
        return AmountMines;
    }

    public static char getXBoard() {
        return XBoard;
    }

    public static char getYBoard(){
        return YBoard;
    }
}
