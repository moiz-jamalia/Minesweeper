public class Difficulties implements Difficulty{
    public int AmountBombs;
    public int Xboard;
    public int Yboard;


    @Override
    public void easy() {
        // Mines: 10
        // Board: 8x8
        AmountBombs = 10;
        Xboard = 8;
        Yboard = 8;
    }

    @Override
    public void medium() {
        // Mines: 40
        // Board: 16x16
        AmountBombs = 40;
        Xboard = 16;
        Yboard = 16;
    }

    @Override
    public void hard() {
        // Mines: 99
        // Board: 30x16
        AmountBombs = 99;
        Xboard = 30;
        Yboard = 16;
    }
}