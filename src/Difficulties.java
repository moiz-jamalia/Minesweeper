public class Difficulties {
    public int AmountMines;
    public int Xboard;
    public int Yboard;

    public void easy(){
        // Mines 10
        // Board 8x8
        AmountMines = 10;
        Xboard = 8;
        Yboard = 8;
    }

    public void medium(){
        // Mines 40
        // Board 16x16
        AmountMines = 40;
        Xboard = 16;
        Yboard = 16;
    }

    public void hard(){
        // Mines 90
        // Board 30x16
        AmountMines = 90;
        Xboard = 30;
        Yboard = 16;
    }
}