public class Game {
    private Board board;
    boolean finish = false;
    boolean win = true;
    int turn = 0;

    public int Xboard = Board.Xboard;
    public int Yboard = Board.Yboard;

    public void Jogo(){
        board = new Board();
        Play(board);
        System.out.println("\nY-Achse: " +Yboard);
        System.out.println("X-Achse: " +Xboard);
    }

    public void Play(Board board){
        board.show();
        board.showMines();
        board.showNeighbors();
    }
}
