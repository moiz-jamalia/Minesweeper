public class Difficulties {
    public static int AmountMines;
    public static int Xboard;
    public static int Yboard;



    public static void easy(){
        // Mines 10
        // Board 8x8
        AmountMines = 10;
        Xboard = 9;
        Yboard = 9;
    }

    public static void medium(){
        // Mines 40
        // Board 16x16
        AmountMines = 40;
        Xboard = 17;
        Yboard = 17;
    }

    public static void hard(){
        // Mines 90
        // Board 30x16
        AmountMines = 90;
        Xboard = 31;
        Yboard = 17;
    }

    public static int getAmountMines(){
        return AmountMines;
    }
}