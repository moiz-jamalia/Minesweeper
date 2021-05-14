public class Difficulties {
    public static int XMines;
    public static int YMines;
    public static char XBoard;
    public static char YBoard;


    public static void easy(){
        // Mines 10
        // Board 8x8
        XMines = 10;
        YMines = 10;
        XBoard = 9;
        YBoard = 10;
    }

    public static void medium(){
        // Mines 40
        // Board 16x16
        XMines = 40;
        YMines = 40;
        XBoard = 17;
        YBoard = 18;
    }

    public static void hard(){
        // Mines 90
        // Board 30x16
        XMines = 90;
        YMines = 90;
        XBoard = 31;
        YBoard = 18;
    }

    public static int getXMines(){
        return XMines;
    }

    public static int getYMines(){
        return YMines;
    }

    public static char getXBoard() {
        return XBoard;
    }

    public static char getYBoard(){
        return YBoard;
    }
}
